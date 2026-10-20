package com.workgrid.project.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.workgrid.project.dto.ProjectRequestDTO;
import com.workgrid.project.dto.ProjectResponseDTO;
import com.workgrid.project.entity.ProjectEntity;

@Component
public class ProjectMapper {

    public ProjectEntity mapToEntity(ProjectRequestDTO request) {
        ProjectEntity entity = new ProjectEntity();

        BeanUtils.copyProperties(request, entity);
        return entity;
    }

    public ProjectResponseDTO mapToDTO(ProjectEntity entity) {
        ProjectResponseDTO response = new ProjectResponseDTO();

        BeanUtils.copyProperties(entity, response);
        if (entity.getOrganisation() != null) {
            response.setOrganisationId(entity.getOrganisation().getId());
        }
        return response;
    }

}
