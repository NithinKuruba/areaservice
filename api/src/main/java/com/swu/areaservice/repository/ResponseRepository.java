package com.swu.areaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swu.areaservice.data.Response;

public interface ResponseRepository extends JpaRepository<Response, Long> {

}
