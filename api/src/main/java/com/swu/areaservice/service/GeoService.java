package com.swu.areaservice.service;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;

import java.util.Date;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

import com.swu.areaservice.data.Chsa;
import com.swu.areaservice.data.Request;
import com.swu.areaservice.data.Response;
import com.swu.areaservice.model.WfsResponse;
import com.swu.areaservice.repository.ChsaRepository;
import com.swu.areaservice.repository.RequestRepository;
import com.swu.areaservice.repository.ResponseRepository;

@Service
public class GeoService {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(GeoService.class);

	private WebClient webclient;

	@Autowired
	private RequestRepository requestRepository;

	@Autowired
	private ResponseRepository responseRepository;

	@Autowired
	private ChsaRepository chsaRepository;

	static final String FEATURE_ID = "WHSE_ADMIN_BOUNDARIES.BCHA_CMNTY_HEALTH_SERV_AREA_SP.120";

	static final String BASE_URL = "https://openmaps.gov.bc.ca";

	static final String GEO_URL = "/geo/pub/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=pub%3AWHSE_ADMIN_BOUNDARIES.BCHA_CMNTY_HEALTH_SERV_AREA_SP&srsname=EPSG%3A4326&"
			+ "cql_filter=INTERSECTS(SHAPE%2CSRID%3D4326%3BPOINT(";

	static final String SEARCH_URL = "))&propertyName=CMNTY_HLTH_SERV_AREA_CODE%2CCMNTY_HLTH_SERV_AREA_NAME&outputFormat=application%2Fjson";

	public Request addNewRequest(String coordinate) {

		Date date = new Date();

		Request request = new Request();
		request.setFeatureid(FEATURE_ID);
		request.setCoordinate(coordinate);
		request.setRequesttime(new Timestamp(date.getTime()));

		return requestRepository.save(request);
	}

	public void addNewResponse(Long requestId, WfsResponse wfsResponse) {

		if (wfsResponse != null && wfsResponse.getFeatures().size() > 0) {
			Response response = new Response();

			String areaCode = wfsResponse.getFeatures().get(0).getProperties().get("CMNTY_HLTH_SERV_AREA_CODE");
			String areaName = wfsResponse.getFeatures().get(0).getProperties().get("CMNTY_HLTH_SERV_AREA_NAME");
			int objId = Integer.parseInt(wfsResponse.getFeatures().get(0).getProperties().get("OBJECTID"));

			Chsa chsa = chsaRepository.getByAreacodeAndAreaname(areaCode, areaName);

			if (chsa == null) {
				chsa = new Chsa();
				chsa.setAreacode(areaCode);
				chsa.setAreaname(areaName);
				chsa.setObjectid(objId);
				chsa = chsaRepository.save(chsa);
			}

			response.setRequestid(requestId);
			response.setTimestamp(new Timestamp(new Date().getTime()));
			response.setChsaid(chsa.getSysid());
			response.setCrs(wfsResponse.getCrs());

			responseRepository.save(response);
		}
	}

	public WfsResponse getFeaturesPlainJSON(String coordinates) {

		WfsResponse wfsResponse = new WfsResponse();

		try {
			DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(BASE_URL);
			factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);

			this.webclient = WebClient.builder()
					.uriBuilderFactory(factory)
					.baseUrl(BASE_URL)
					.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();

			wfsResponse = this.webclient.get()
					.uri(GEO_URL + coordinates + SEARCH_URL)
					.accept(MediaType.APPLICATION_JSON)
					.acceptCharset(StandardCharsets.UTF_8)
					.retrieve()
					.bodyToMono(WfsResponse.class)
					.block();
		} catch (Exception ex) {
			logger.error("Server is not responding", ex);
		}

		return wfsResponse;
	}
}
