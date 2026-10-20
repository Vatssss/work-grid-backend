package com.workgrid.project.service;

import com.workgrid.project.dto.ProjectRequestDTO;
import com.workgrid.project.entity.ProjectEntity;

public interface ProjectService {

	ProjectEntity createProject(ProjectRequestDTO request);

}
