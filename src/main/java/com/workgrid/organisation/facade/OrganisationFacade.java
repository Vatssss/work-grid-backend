package com.workgrid.organisation.facade;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.workgrid.organisation.dto.OrganisationRequestDTO;
import com.workgrid.organisation.dto.OrganisationResponseDTO;
import com.workgrid.organisation.mapper.OrganisationMapper;
import com.workgrid.organisation.service.OrganisationService;
import com.workgrid.project.dto.ProjectResponseDTO;
import com.workgrid.project.mapper.ProjectMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrganisationFacade {

	private final OrganisationMapper organisationMapper;
	private final ProjectMapper projectMapper;

	private final OrganisationService service;

	public OrganisationResponseDTO createOrganisation(OrganisationRequestDTO request) {
		return organisationMapper.mapToDTO(service.createOrganisation(organisationMapper.mapToEntity(request)));
	}

//	public List<ProjectResponseDTO> getProjectsByOrganisationId(Long organisationId) {
//
//		return service.getProjectsByOrganisationId(organisationId).stream().map(projectMapper::mapToDTO).toList();
//	}

	public Page<ProjectResponseDTO> getProjectsByOrganisationIdWithPaginationAndSorting(Long organisationId,
			Integer page, Integer pageSize, String fieldName, String direction) {

		return service.getProjectsByOrganisationIdWithPaginationAndSorting(organisationId, page, pageSize, fieldName,
				direction).map(projectMapper::mapToDTO);
	}

}
