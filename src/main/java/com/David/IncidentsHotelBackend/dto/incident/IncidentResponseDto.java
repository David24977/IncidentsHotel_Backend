package com.David.IncidentsHotelBackend.dto.incident;

import java.time.LocalDateTime;
import java.util.UUID;

import com.David.IncidentsHotelBackend.model.StatusIncident;

public record IncidentResponseDto(
		
		UUID id,
		UUID hotelId,
		String roomNumber,
		String reportIncident,
		StatusIncident status,
		String createdByUserId,
		String assignedToUserId,
		LocalDateTime createdAt
		) {

}
