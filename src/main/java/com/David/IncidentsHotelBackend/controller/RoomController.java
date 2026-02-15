package com.David.IncidentsHotelBackend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.David.IncidentsHotelBackend.dto.room.RoomRequestDto;
import com.David.IncidentsHotelBackend.dto.room.RoomResponseDto;
import com.David.IncidentsHotelBackend.dto.room.UpdateRoomStatusRequest;
import com.David.IncidentsHotelBackend.service.RoomService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hotels/{hotelId}/rooms")
public class RoomController {
	
	private final RoomService roomService;
	
	@GetMapping
	public List<RoomResponseDto> findAllRooms(@PathVariable UUID hotelId){
		
		return roomService.findAllRooms(hotelId);
	}
	
	@GetMapping("/{id}")
	public RoomResponseDto findRoomById(@PathVariable UUID hotelId, 
			@PathVariable UUID id) {
		
		return roomService.findRoomById(hotelId, id);
	}
	
	@PostMapping
	public RoomResponseDto createRoom(@PathVariable UUID hotelId,
			@Valid @RequestBody RoomRequestDto roomRequestDto) {
		
		return roomService.createRoom(hotelId, roomRequestDto);
	}
	
	@PatchMapping("/{id}")
	public RoomResponseDto updateRoomStatus(@PathVariable UUID hotelId, 
			@PathVariable UUID id, 
			@RequestBody UpdateRoomStatusRequest updateRoomStatusRequest) {
		
		return roomService.updateRoomStatus(hotelId, id, updateRoomStatusRequest);
	}
	
	@DeleteMapping("/{id}")
	public void deleteRoom(@PathVariable UUID hotelId, 
			@PathVariable UUID id) {
		
		 roomService.deleteRoom(hotelId, id);
		
	}
	
}