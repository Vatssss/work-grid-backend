package com.workgrid.project.facade;

import org.springframework.stereotype.Component;

import com.workgrid.project.dto.ProjectRequestDTO;
import com.workgrid.project.dto.ProjectResponseDTO;
import com.workgrid.project.mapper.ProjectMapper;
import com.workgrid.project.service.ProjectService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProjectFacade {

    private final ProjectMapper projectMapper;
    private final ProjectService projectService;

    public ProjectResponseDTO createProject(ProjectRequestDTO request) {
        return projectMapper.mapToDTO(projectService.createProject(request));
    }

}
