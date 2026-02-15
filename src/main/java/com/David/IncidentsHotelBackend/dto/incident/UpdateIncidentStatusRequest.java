package com.David.IncidentsHotelBackend.dto.incident;

import com.David.IncidentsHotelBackend.model.StatusIncident;

import jakarta.validation.constraints.NotNull;

public record UpdateIncidentStatusRequest(
		@NotNull
		StatusIncident status
		) {

}
