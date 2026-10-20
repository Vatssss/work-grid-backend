package com.workgrid.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workgrid.project.dto.ProjectRequestDTO;
import com.workgrid.project.dto.ProjectResponseDTO;
import com.workgrid.project.facade.ProjectFacade;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectFacade projectFacade;

    @PostMapping
    public ResponseEntity<ProjectResponseDTO> createProject(@Valid @RequestBody ProjectRequestDTO request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(projectFacade.createProject(request));
    }

}
