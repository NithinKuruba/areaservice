package com.swu.areaservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swu.areaservice.model.ChsaAreaCode;
import com.swu.areaservice.model.WfsResponse;
import com.swu.areaservice.service.GeoService;

@RestController
@RequestMapping("/area")
public class AreaController {

	Logger logger = LoggerFactory.getLogger(AreaController.class);

	@Autowired
	GeoService geoService;

	@GetMapping("/{coordinate}")
	public ResponseEntity<ChsaAreaCode> getAreaAndCodeByLocation(@PathVariable("coordinate") String coordinate) {

		if (coordinate.matches("-1\\d{2}\\.\\d{1,7}\\+\\d{2}\\.\\d{1,7}")) {

			try {
				ChsaAreaCode chsaAreaCode = new ChsaAreaCode();
				WfsResponse wfsResponse = geoService.getFeaturesPlainJSON(coordinate);

				if (wfsResponse.getFeatures().size() > 0) {
					chsaAreaCode.setCMNTY_HLTH_SERV_AREA_CODE(
							wfsResponse.getFeatures().get(0).getProperties().get("CMNTY_HLTH_SERV_AREA_CODE"));
					chsaAreaCode.setCMNTY_HLTH_SERV_AREA_NAME(
							wfsResponse.getFeatures().get(0).getProperties().get("CMNTY_HLTH_SERV_AREA_NAME"));
				} else {
					return ResponseEntity
							.status(HttpStatus.BAD_REQUEST)
							.body(null);
				}
				return ResponseEntity
						.status(HttpStatus.OK).body(chsaAreaCode);
			} catch (Exception e) {
				return ResponseEntity
						.status(HttpStatus.SERVICE_UNAVAILABLE)
						.body(null);
			}
		} else {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(null);
		}
	}
}
