package com.David.IncidentsHotelBackend.service;

import java.util.List;
import java.util.UUID;

import com.David.IncidentsHotelBackend.dto.room.RoomRequestDto;
import com.David.IncidentsHotelBackend.dto.room.RoomResponseDto;
import com.David.IncidentsHotelBackend.dto.room.UpdateRoomStatusRequest;

public interface RoomService {
	
	List<RoomResponseDto> findAllRooms(UUID hotelId);
	
	RoomResponseDto findRoomById(UUID hotelId, UUID id);
	
	RoomResponseDto createRoom(UUID hotelId, RoomRequestDto roomRequestDto);
	
	RoomResponseDto updateRoomStatus(UUID hotelId, UUID id, UpdateRoomStatusRequest updateRoomStatusRequest);
	
	void deleteRoom(UUID hotelId, UUID id);

}



