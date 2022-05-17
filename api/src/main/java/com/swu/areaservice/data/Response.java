package com.swu.areaservice.data;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "response")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(toBuilder = true)
public class Response {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "responseid", unique = true, nullable = false)
	@Getter
	@Setter
	private Long id;

	@Column(name = "requestid")
	@Getter
	@Setter
	private Long requestid;

	@Column(name = "timestamp")
	@Getter
	@Setter
	private Timestamp timestamp;

	@Column(name = "chsaid")
	@Getter
	@Setter
	private int chsaid;

	@Column(name = "crs")
	@Getter
	@Setter
	private String crs;

}
