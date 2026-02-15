package com.David.IncidentsHotelBackend.dto.hotel;

import java.util.UUID;

public record HotelResponseDto(
		
		UUID id,
		String name,
		String city,
		Boolean active
		) {

}
