package com.David.IncidentsHotelBackend.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.David.IncidentsHotelBackend.model.Room;

public interface RoomRepository extends JpaRepository<Room, UUID>{
	
	List<Room> findByHotel_Id(UUID hotelId);
	
	Optional<Room> findByIdAndHotel_Id(UUID id, UUID hotelId);
	
	boolean existsByIdAndHotel_Id(UUID id, UUID hotelId);
	
	boolean existsByHotel_IdAndNumber(UUID hotelId, String number);
	
	}

