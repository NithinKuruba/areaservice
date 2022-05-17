package com.swu.areaservice.data;

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
@Table(name = "chsa")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(toBuilder = true)
public class Chsa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sysid", unique = true, nullable = false)
    @Getter
    @Setter
    private int sysid;

    @Column(name = "areacode")
    @Getter
    @Setter
    private String areacode;

    @Column(name = "areaname")
    @Getter
    @Setter
    private String areaname;

    @Column(name = "objectid")
    @Getter
    @Setter
    private int objectid;
}
