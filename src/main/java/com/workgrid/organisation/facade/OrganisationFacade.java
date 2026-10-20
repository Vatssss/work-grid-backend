package com.workgrid.organisation.facade;

import org.springframework.stereotype.Component;

import com.workgrid.organisation.dto.OrganisationRequestDTO;
import com.workgrid.organisation.dto.OrganisationResponseDTO;
import com.workgrid.organisation.mapper.OrganisationMapper;
import com.workgrid.organisation.service.OrganisationService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrganisationFacade {

	private final OrganisationMapper organisationMapper;

	private final OrganisationService service;

	public OrganisationResponseDTO createOrganisation(OrganisationRequestDTO request) {
		return organisationMapper.mapToDTO(service.createOrganisation(organisationMapper.mapToEntity(request)));
	}

}
