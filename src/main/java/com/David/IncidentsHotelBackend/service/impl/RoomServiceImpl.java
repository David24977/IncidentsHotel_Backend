package com.David.IncidentsHotelBackend.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.David.IncidentsHotelBackend.dto.room.RoomRequestDto;
import com.David.IncidentsHotelBackend.dto.room.RoomResponseDto;
import com.David.IncidentsHotelBackend.dto.room.UpdateRoomStatusRequest;
import com.David.IncidentsHotelBackend.exception.BadRequestException;
import com.David.IncidentsHotelBackend.exception.ResourceNotFoundException;
import com.David.IncidentsHotelBackend.model.Hotel;
import com.David.IncidentsHotelBackend.model.Room;
import com.David.IncidentsHotelBackend.repository.HotelRepository;
import com.David.IncidentsHotelBackend.repository.RoomRepository;
import com.David.IncidentsHotelBackend.service.RoomService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RoomServiceImpl implements RoomService{
	
	private final RoomRepository roomRepository;
	private final HotelRepository hotelRepository;

	@Override
	public List<RoomResponseDto> findAllRooms(UUID hotelId) {
		
		return roomRepository.findByHotel_Id(hotelId)
					.stream()
					.map(this::mapDto)
					.toList();
		}
	

	@Override
	public RoomResponseDto findRoomById(UUID hotelId, UUID id) {
		Room room = roomRepository.findByIdAndHotel_Id(id, hotelId)
				.orElseThrow(()-> new ResourceNotFoundException("Room not found"));
		
		return mapDto(room);
	}

	@Override
	public RoomResponseDto createRoom(UUID hotelId, RoomRequestDto roomRequestDto) {
		
		Hotel hotel = hotelRepository.findById(hotelId)
				.orElseThrow(()-> new ResourceNotFoundException("Hotel not found"));
		
		Room room = new Room();
		
		room.setHotel(hotel);
		room.setNumber(roomRequestDto.number());
		room.setType(roomRequestDto.type());
		
		if(roomRepository.existsByHotel_IdAndNumber(roomRequestDto.hotelId(), roomRequestDto.number())) {
			throw new BadRequestException("Room is already created");
		}
		
		
		Room savedRoom = roomRepository.save(room);
		
		return mapDto(savedRoom); 
	}

	@Override
	public RoomResponseDto updateRoomStatus(UUID hotelId, UUID id, UpdateRoomStatusRequest updateRoomStatusRequest) {
		Room room = roomRepository.findByIdAndHotel_Id(id, hotelId)
					.orElseThrow(()-> new ResourceNotFoundException("Room not found"));
		
		if(updateRoomStatusRequest.status() == null) {
			throw new BadRequestException("Status is mandatory");
		}
		
		room.setStatus(updateRoomStatusRequest.status());

		
		Room updateRoom = roomRepository.save(room);
		
		return mapDto(updateRoom);
	}

	@Override
	public void deleteRoom(UUID hotelId, UUID id) {
		Room room = roomRepository.findByIdAndHotel_Id(id, hotelId)
				.orElseThrow(()-> new ResourceNotFoundException("Room not found"));
		
		roomRepository.delete(room);
		
	}
	
	private RoomResponseDto mapDto(Room room) {
		
		return new RoomResponseDto(
				
				room.getId(),
				room.getHotel().getId(),
				room.getNumber(),
				room.getType(),
				room.getStatus()
				);
		}

}
