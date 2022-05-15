package com.swu.areaservice.service;

import static org.junit.jupiter.api.Assertions.*;

import com.swu.areaservice.model.WfsResponse;
import com.swu.areaservice.service.GeoService;

import org.junit.jupiter.api.Test;

class GeoServiceTest {
	final static String Area_Name = "Downtown Victoria/Vic West";
	final static String Coordinate = "-123.3646335+48.4251378";
	final static String Area_Code = "4111";

	@Test
	void testGetGeo() {
		GeoService geoService = new GeoService();

		try {
			WfsResponse wfsResponse = geoService.getFeaturesPlainJSON(Coordinate);
			assertEquals(1, wfsResponse.getFeatures().size());
			assertEquals(Area_Code, wfsResponse.getFeatures().get(0).getProperties().get("CMNTY_HLTH_SERV_AREA_CODE"));
			assertEquals(Area_Name, wfsResponse.getFeatures().get(0).getProperties().get("CMNTY_HLTH_SERV_AREA_NAME"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
