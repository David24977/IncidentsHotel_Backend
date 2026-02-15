package com.David.IncidentsHotelBackend.dto.hotel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record HotelRequestDto(
		
		@NotBlank
		@Size(max = 100)
		String name,
		@NotBlank
		@Size(max = 100)
		String city
		) {

}
