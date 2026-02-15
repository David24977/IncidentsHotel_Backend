package com.David.IncidentsHotelBackend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.David.IncidentsHotelBackend.dto.hotel.HotelRequestDto;
import com.David.IncidentsHotelBackend.dto.hotel.HotelResponseDto;
import com.David.IncidentsHotelBackend.service.HotelService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hotels")
public class HotelController {
	
	private final HotelService hotelService;
	
	@GetMapping
	public List<HotelResponseDto> findAllHotels(){
		
		return hotelService.findAllHotels();
	}
	
	@GetMapping("/{id}")
	public HotelResponseDto findHotelById(@PathVariable UUID id) {
		
		return hotelService.findHotelById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public HotelResponseDto createHotel(@Valid @RequestBody HotelRequestDto hotelRequestDto) {
		
		return hotelService.createHotel(hotelRequestDto);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deleteHotel(@PathVariable UUID id) {
		
		hotelService.deleteHotel(id);
	}
	
}
