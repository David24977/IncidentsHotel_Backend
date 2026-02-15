package com.David.IncidentsHotelBackend.dto.room;

import com.David.IncidentsHotelBackend.model.StatusRoom;

public record UpdateRoomStatusRequest(
		
		StatusRoom status
		) {

}
