package com.David.IncidentsHotelBackend.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(
		uniqueConstraints = @UniqueConstraint(
				name = "uk_hotel_room_number",
				columnNames = {"hotel_id", "number"}
				)
		
		)
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "hotel_id", nullable = false)
	private Hotel hotel;
	
	@Column(nullable = false)
	private String number;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 50)
	private Type type;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 50)
	private StatusRoom status = StatusRoom.AVAIBLE;
}
