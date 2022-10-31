package com.cmpe202.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpe202.models.Amenities;
import com.cmpe202.repository.AmenitiesRepository;

@Service
public class AmenitiesService {

	@Autowired
	AmenitiesRepository amenitiesRepository;

	public Amenities getAmenitiesById(long id) {

		Optional<Amenities> amenities = amenitiesRepository.findById(id);

		if (amenities != null) {
			return amenities.get();
		}
		return null;
	}

}
