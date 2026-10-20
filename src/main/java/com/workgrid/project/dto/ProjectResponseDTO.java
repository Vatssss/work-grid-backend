package com.workgrid.project.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ProjectResponseDTO {

    private Long id;

    private String name;

    private String description;

    private Long organisationId;

    private String createdBy;

    private LocalDateTime createdAt;

    private String lastUpdatedBy;

    private LocalDateTime lastUpdatedAt;
}
