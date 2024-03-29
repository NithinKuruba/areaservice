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
@Table(name = "request")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(toBuilder = true)
public class Request {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	@Getter
	@Setter
	private Long id;

	@Column(name = "featureid")
	@Getter
	@Setter
	private String featureid;

	@Column(name = "coordinate")
	@Getter
	@Setter
	private String coordinate;

	@Column(name = "requesttime")
	@Getter
	@Setter
	private Timestamp requesttime;

}
