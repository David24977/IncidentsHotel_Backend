package com.David.IncidentsHotelBackend.model;

import java.time.LocalDateTime;
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
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Incident {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "hotel_id", nullable = false)
	private Hotel hotel;
	
	
	private String roomNumber;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String reportIncident;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status_incident", nullable = false)
	private StatusIncident status = StatusIncident.OPEN;
	
	@Column(nullable = false)
	private String createdByUserId;
	
	
	private String assignedToUserId;
	
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;
	
	@PrePersist
	public void prePersist() {
		
		this.createdAt = LocalDateTime.now();
	}
	
}