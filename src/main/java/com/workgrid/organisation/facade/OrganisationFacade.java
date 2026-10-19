package com.workgrid.organisation.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.workgrid.organisation.dto.OrganisationRequestDTO;
import com.workgrid.organisation.dto.OrganisationResponseDTO;
import com.workgrid.organisation.mapper.OrganisationMapper;
import com.workgrid.organisation.service.OrganisationService;

@Component
public class OrganisationFacade {

    @Autowired
    private OrganisationMapper organisationMapper;

    @Autowired
    private OrganisationService service;

    public OrganisationResponseDTO createOrganisation(OrganisationRequestDTO request) {
        return organisationMapper.mapToDTO(service.createOrganisation(organisationMapper.mapToEntity(request)));
    }

}
