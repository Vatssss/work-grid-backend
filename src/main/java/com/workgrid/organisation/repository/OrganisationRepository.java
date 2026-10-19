package com.workgrid.organisation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganisationRepository
        extends JpaRepository<com.workgrid.organisation.entity.OrganisationEntity, Long> {

}
