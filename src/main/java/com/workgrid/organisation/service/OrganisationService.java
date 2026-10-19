package com.workgrid.organisation.service;

import org.springframework.stereotype.Service;

import com.workgrid.organisation.entity.OrganisationEntity;

@Service
public interface OrganisationService {

	OrganisationEntity createOrganisation(OrganisationEntity request);

}
