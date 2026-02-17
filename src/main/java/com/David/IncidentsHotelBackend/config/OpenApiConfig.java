package com.David.IncidentsHotelBackend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info = @Info(
        title = "IncidentsHotelBackend",
        version = "1.0.0",
        description = "Backend REST API for managing hotel incidents, rooms and operational workflows."
    )
)
public class OpenApiConfig {}
