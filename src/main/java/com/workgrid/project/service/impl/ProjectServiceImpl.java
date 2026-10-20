package com.workgrid.project.service.impl;

import org.springframework.stereotype.Service;

import com.workgrid.common.exception.ResourceNotFoundException;
import com.workgrid.organisation.entity.OrganisationEntity;
import com.workgrid.organisation.repository.OrganisationRepository;
import com.workgrid.project.dto.ProjectRequestDTO;
import com.workgrid.project.entity.ProjectEntity;
import com.workgrid.project.mapper.ProjectMapper;
import com.workgrid.project.repository.ProjectRepository;
import com.workgrid.project.service.ProjectService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

	private final ProjectRepository projectRepository;
	private final OrganisationRepository organisationRepository;
	private final ProjectMapper projectMapper;

	@Override
	public ProjectEntity createProject(ProjectRequestDTO request) {

		OrganisationEntity organisation = organisationRepository.findById(request.getOrganisationId()).orElseThrow(
				() -> new ResourceNotFoundException("Organisation not found: " + request.getOrganisationId()));

		ProjectEntity project = projectMapper.mapToEntity(request);
		project.setOrganisation(organisation);

		return projectRepository.save(project);

	}

}
