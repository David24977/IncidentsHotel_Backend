package com.David.IncidentsHotelBackend.dto.room;

import java.util.UUID;

import com.David.IncidentsHotelBackend.model.StatusRoom;
import com.David.IncidentsHotelBackend.model.Type;

public record RoomResponseDto(
		
		UUID id,
		UUID hotelId,
		String number,
		Type type,
		StatusRoom status
		) {

}
