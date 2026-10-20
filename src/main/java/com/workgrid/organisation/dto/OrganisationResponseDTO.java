package com.workgrid.organisation.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrganisationResponseDTO {

	private Long id;

	private String name;

	private String createdBy;

	private LocalDateTime createdAt;

	private String lastUpdatedBy;
	
	private LocalDateTime lastUpdatedAt;

}
