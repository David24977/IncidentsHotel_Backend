package com.David.IncidentsHotelBackend.dto.room;

import java.util.UUID;

import com.David.IncidentsHotelBackend.model.Type;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RoomRequestDto(
		@NotNull
		UUID hotelId,
		@NotBlank
		String number,
		@NotNull
		Type type
		) {

}
