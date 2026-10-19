package com.workgrid.organisation.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workgrid.organisation.entity.OrganisationEntity;
import com.workgrid.organisation.repository.OrganisationRepository;
import com.workgrid.organisation.service.OrganisationService;

@Service
public class OrganisationServiceImpl implements OrganisationService {

    @Autowired
    private OrganisationRepository organisationRepository;

    @Override
    public OrganisationEntity createOrganisation(OrganisationEntity request) {
        return organisationRepository.save(request);
    }

}
