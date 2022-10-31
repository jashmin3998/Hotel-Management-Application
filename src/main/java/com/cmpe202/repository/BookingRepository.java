package com.cmpe202.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmpe202.models.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>  {


	List<Booking> findAll();

	List<Booking> findByUserId(long id);
	
	void deleteById(long id);
}
