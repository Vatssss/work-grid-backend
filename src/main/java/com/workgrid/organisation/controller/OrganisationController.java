package com.workgrid.organisation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workgrid.organisation.dto.OrganisationRequestDTO;
import com.workgrid.organisation.dto.OrganisationResponseDTO;
import com.workgrid.organisation.facade.OrganisationFacade;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/organisation")
public class OrganisationController {

	@Autowired
	private OrganisationFacade organisationFacade;

	@PostMapping("/v1/create")
	public ResponseEntity<OrganisationResponseDTO> createOrganisation(
			@Valid @RequestBody OrganisationRequestDTO request) {
		return ResponseEntity.ok(organisationFacade.createOrganisation(request));
	}

}