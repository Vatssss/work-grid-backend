package com.workgrid.organisation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workgrid.organisation.dto.OrganisationRequestDTO;
import com.workgrid.organisation.dto.OrganisationResponseDTO;
import com.workgrid.organisation.facade.OrganisationFacade;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/organisations")
@RequiredArgsConstructor
public class OrganisationController {

	private final OrganisationFacade organisationFacade;

	@PostMapping
	public ResponseEntity<OrganisationResponseDTO> createOrganisation(
			@Valid @RequestBody OrganisationRequestDTO request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(organisationFacade.createOrganisation(request));
	}

}