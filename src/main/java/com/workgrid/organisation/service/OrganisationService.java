package com.workgrid.organisation.service;

import org.springframework.data.domain.Page;

import com.workgrid.organisation.entity.OrganisationEntity;
import com.workgrid.project.entity.ProjectEntity;

public interface OrganisationService {

	OrganisationEntity createOrganisation(OrganisationEntity request);

//	List<ProjectEntity> getProjectsByOrganisationId(Long organisationId);

	Page<ProjectEntity> getProjectsByOrganisationIdWithPaginationAndSorting(Long organisationId, Integer page,
			Integer pageSize, String fieldName, String direction);
}
