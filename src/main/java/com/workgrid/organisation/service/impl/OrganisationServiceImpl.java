package com.workgrid.organisation.service.impl;

import org.springframework.stereotype.Service;

import com.workgrid.organisation.entity.OrganisationEntity;
import com.workgrid.organisation.repository.OrganisationRepository;
import com.workgrid.organisation.service.OrganisationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrganisationServiceImpl implements OrganisationService {

	private final OrganisationRepository organisationRepository;

	@Override
	public OrganisationEntity createOrganisation(OrganisationEntity request) {
		return organisationRepository.save(request);
	}

}
