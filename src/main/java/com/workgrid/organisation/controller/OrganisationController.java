package com.workgrid.organisation.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workgrid.organisation.dto.OrganisationRequestDTO;
import com.workgrid.organisation.dto.OrganisationResponseDTO;
import com.workgrid.organisation.facade.OrganisationFacade;
import com.workgrid.project.dto.ProjectResponseDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/organisations")
@RequiredArgsConstructor
@Validated
public class OrganisationController {

	private final OrganisationFacade organisationFacade;

	@PostMapping
	public ResponseEntity<OrganisationResponseDTO> createOrganisation(
			@Valid @RequestBody OrganisationRequestDTO request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(organisationFacade.createOrganisation(request));
	}

//	@GetMapping("/{organisationId}/projects")
//	public ResponseEntity<List<ProjectResponseDTO>> getProjectsByOrganisationId(
//			@PathVariable @Positive(message = "Organisation ID must be positive") Long organisationId) {
//		return ResponseEntity.ok(organisationFacade.getProjectsByOrganisationId(organisationId));
//
//	}

	@GetMapping("/{organisationId}/projects")
	public ResponseEntity<Page<ProjectResponseDTO>> getProjectsByOrganisationIdWithPaginationAndSorting(
			@PathVariable @Positive(message = "Organisation ID must be positive") Long organisationId,
			@RequestParam(defaultValue = "0") @Min(0) Integer page,
			@RequestParam(value = "size", defaultValue = "10") @Min(1) @Max(100) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = "name") String fieldName,
			@RequestParam(defaultValue = "ASC") @Pattern(regexp = "^(?i)(ASC|DESC)$", message = "Direction must be either ASC or DESC") String direction) {
		return ResponseEntity.ok(organisationFacade.getProjectsByOrganisationIdWithPaginationAndSorting(organisationId,
				page, pageSize, fieldName, direction));
	}

}