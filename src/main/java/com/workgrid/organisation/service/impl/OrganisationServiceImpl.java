package com.workgrid.organisation.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.workgrid.common.exception.ResourceNotFoundException;
import com.workgrid.organisation.entity.OrganisationEntity;
import com.workgrid.organisation.repository.OrganisationRepository;
import com.workgrid.organisation.service.OrganisationService;
import com.workgrid.project.entity.ProjectEntity;
import com.workgrid.project.repository.ProjectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrganisationServiceImpl implements OrganisationService {

	private final OrganisationRepository organisationRepository;
	private final ProjectRepository projectRepository;

	@Override
	public OrganisationEntity createOrganisation(OrganisationEntity request) {
		return organisationRepository.save(request);
	}

//	@Override
//	public List<ProjectEntity> getProjectsByOrganisationId(Long organisationId) {
//		OrganisationEntity organisation = organisationRepository.findById(organisationId)
//				.orElseThrow(() -> new ResourceNotFoundException("Organisation not found: " + organisationId));
//
//		return projectRepository.findAllByOrganisation(organisation);
//	}

	@Override
	public Page<ProjectEntity> getProjectsByOrganisationIdWithPaginationAndSorting(Long organisationId, Integer page,
			Integer pageSize, String fieldName, String direction) {
		OrganisationEntity organisation = organisationRepository.findById(organisationId)
				.orElseThrow(() -> new ResourceNotFoundException("Organisation not found: " + organisationId));

		return projectRepository.findAllByOrganisation(organisation,
				PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), fieldName)));
	}

}
