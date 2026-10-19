package com.workgrid.organisation.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.workgrid.organisation.dto.OrganisationRequestDTO;
import com.workgrid.organisation.dto.OrganisationResponseDTO;
import com.workgrid.organisation.entity.OrganisationEntity;

@Component
public class OrganisationMapper {

    public OrganisationEntity mapToEntity(OrganisationRequestDTO request) {

        OrganisationEntity entity = new OrganisationEntity();

        BeanUtils.copyProperties(request, entity);
        return entity;
    }

    public OrganisationResponseDTO mapToDTO(OrganisationEntity entity) {

        OrganisationResponseDTO response = new OrganisationResponseDTO();

        BeanUtils.copyProperties(entity, response);
        return response;
    }

}
