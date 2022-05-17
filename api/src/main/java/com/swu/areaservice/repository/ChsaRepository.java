package com.swu.areaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swu.areaservice.data.Chsa;

public interface ChsaRepository extends JpaRepository<Chsa, Long> {

    Chsa getByAreacodeAndAreaname(String areaCode, String areaName);

}
