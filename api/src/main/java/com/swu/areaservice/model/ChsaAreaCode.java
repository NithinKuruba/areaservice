package com.swu.areaservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "CMNTY_HLTH_SERV_AREA_CODE", "CMNTY_HLTH_SERV_AREA_NAME" })
public class ChsaAreaCode {
    private String CMNTY_HLTH_SERV_AREA_CODE;
    private String CMNTY_HLTH_SERV_AREA_NAME;

    public String getCMNTY_HLTH_SERV_AREA_CODE() {
        return CMNTY_HLTH_SERV_AREA_CODE;
    }

    public void setCMNTY_HLTH_SERV_AREA_CODE(String cMNTY_HLTH_SERV_AREA_CODE) {
        CMNTY_HLTH_SERV_AREA_CODE = cMNTY_HLTH_SERV_AREA_CODE;
    }

    public String getCMNTY_HLTH_SERV_AREA_NAME() {
        return CMNTY_HLTH_SERV_AREA_NAME;
    }

    public void setCMNTY_HLTH_SERV_AREA_NAME(String cMNTY_HLTH_SERV_AREA_NAME) {
        CMNTY_HLTH_SERV_AREA_NAME = cMNTY_HLTH_SERV_AREA_NAME;
    }
}
