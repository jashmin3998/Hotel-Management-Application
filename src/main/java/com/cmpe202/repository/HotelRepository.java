package com.cmpe202.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmpe202.models.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

	List<Hotel> findAll();
	
	List<Hotel> findByState(String state);
	
	List<Hotel> findByCountry(String country);
	
}

