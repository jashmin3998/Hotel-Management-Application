package com.cmpe202.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmpe202.models.Amenities;

@Repository
public interface AmenitiesRepository extends JpaRepository<Amenities, Long> {

}
