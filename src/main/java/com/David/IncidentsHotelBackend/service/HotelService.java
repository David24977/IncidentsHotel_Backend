package com.David.IncidentsHotelBackend.service;

import java.util.List;
import java.util.UUID;

import com.David.IncidentsHotelBackend.dto.hotel.HotelRequestDto;
import com.David.IncidentsHotelBackend.dto.hotel.HotelResponseDto;

public interface HotelService {
	
	List<HotelResponseDto> findAllHotels();
	
	HotelResponseDto findHotelById(UUID id);
	
	HotelResponseDto createHotel(HotelRequestDto hotelRequestDto);
	
	void deleteHotel(UUID id);
	
}
