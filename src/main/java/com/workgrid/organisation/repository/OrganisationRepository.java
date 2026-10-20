package com.workgrid.organisation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workgrid.organisation.entity.OrganisationEntity;

public interface OrganisationRepository extends JpaRepository<OrganisationEntity, Long> {

}
