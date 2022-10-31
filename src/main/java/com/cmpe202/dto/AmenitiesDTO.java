package com.cmpe202.dto;

import java.util.ArrayList;
import java.util.List;

import com.cmpe202.models.Amenities;
import com.cmpe202.models.EAmenities;

public class AmenitiesDTO {

	private Long id;

	private EAmenities name;

	public AmenitiesDTO() {
		// TODO Auto-generated constructor stub
	}

	public AmenitiesDTO(Long id, EAmenities name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EAmenities getName() {
		return name;
	}

	public void setName(EAmenities name) {
		this.name = name;
	}

	public static AmenitiesDTO convertToAmenitiesDTO(Amenities amenities) {

		return new AmenitiesDTO(amenities.getId(), amenities.getName());

	}

	public static List<AmenitiesDTO> convertToAmenitiesDTOSet(List<Amenities> set) {

		List<AmenitiesDTO> amen = new ArrayList<>();
		for (Amenities amenities : set) {
			amen.add(convertToAmenitiesDTO(amenities));
		}
		return amen;

	}

}
