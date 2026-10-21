package com.workgrid.project.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.workgrid.organisation.entity.OrganisationEntity;
import com.workgrid.project.entity.ProjectEntity;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

	List<ProjectEntity> findAllByOrganisation(OrganisationEntity organisation);

	Page<ProjectEntity> findAllByOrganisation(OrganisationEntity organisation, PageRequest of);

}
