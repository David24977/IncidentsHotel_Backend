package com.David.IncidentsHotelBackend.dto.room;



import com.David.IncidentsHotelBackend.model.Type;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RoomRequestDto(
	
		@NotBlank
		String number,
		@NotNull
		Type type
		) {

}
