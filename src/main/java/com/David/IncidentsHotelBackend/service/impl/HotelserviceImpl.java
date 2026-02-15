package com.David.IncidentsHotelBackend.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.David.IncidentsHotelBackend.dto.hotel.HotelRequestDto;
import com.David.IncidentsHotelBackend.dto.hotel.HotelResponseDto;
import com.David.IncidentsHotelBackend.exception.ResourceNotFoundException;
import com.David.IncidentsHotelBackend.model.Hotel;
import com.David.IncidentsHotelBackend.repository.HotelRepository;
import com.David.IncidentsHotelBackend.service.HotelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class HotelserviceImpl implements HotelService{
	
	private final HotelRepository hotelRepository;

	@Override
	public List<HotelResponseDto> findAllHotels() {
		
		return hotelRepository.findAll()
				.stream()
				.map(this::mapToResponseDto)
				.toList();
	}

	@Override
	public HotelResponseDto findHotelById(UUID id) {
		Hotel hotel = hotelRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Hotel not found"));
		
		return mapToResponseDto(hotel);
		
	}

	@Override
	public HotelResponseDto createHotel(HotelRequestDto hotelRequestDto) {
		Hotel hotel = new Hotel();
		
		hotel.setName(hotelRequestDto.name());
		hotel.setCity(hotelRequestDto.city());
		
		Hotel savedHotel = hotelRepository.save(hotel);
		
		return mapToResponseDto(savedHotel);
	}
	
	@Override
	public void deleteHotel(UUID id) {
		Hotel hotel = hotelRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Hotel not found"));
		
		hotelRepository.delete(hotel);
	}
	
	private HotelResponseDto mapToResponseDto(Hotel hotel) {
		
		return new HotelResponseDto(
				
				hotel.getId(),
				hotel.getName(),
				hotel.getCity(),
				hotel.isActive()
				);
	}

	
	
	
	
	
	

}
