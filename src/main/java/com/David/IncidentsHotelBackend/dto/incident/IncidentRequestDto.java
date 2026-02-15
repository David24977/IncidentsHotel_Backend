package com.David.IncidentsHotelBackend.dto.incident;



import jakarta.validation.constraints.NotBlank;


public record IncidentRequestDto(
	
		String roomNumber,
		@NotBlank
		String reportIncident,
		@NotBlank
		String createdByUserId,
		String assignedToUserId
		
		) {

}
