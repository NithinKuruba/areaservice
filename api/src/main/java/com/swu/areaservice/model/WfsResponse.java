package com.swu.areaservice.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"type", "features", "totalFeatures", "numberMatched", "numberReturned", "timeStamp", "crs"})
public class WfsResponse implements Serializable {

	private String type;
	private List<WfsFeature> features;
	private int totalFeatures;
	private int numberMatched;
	private int numberReturned;
	private String timeStamp;
	private String crs;

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<WfsFeature> getFeatures() {
		return features;
	}
	public void setFeatures(List<WfsFeature> features) {
		this.features = features;
	}
	public int getTotalFeatures() {
		return totalFeatures;
	}
	public void setTotalFeatures(int totalFeatures) {
		this.totalFeatures = totalFeatures;
	}
	public int getNumberMatched() {
		return numberMatched;
	}
	public void setNumberMatched(int numberMatched) {
		this.numberMatched = numberMatched;
	}
	public int getNumberReturned() {
		return numberReturned;
	}
	public void setNumberReturned(int numberReturned) {
		this.numberReturned = numberReturned;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getCrs() {
		return crs;
	}
	public void setCrs(String crs) {
		this.crs = crs;
	}
}
