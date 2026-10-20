package com.workgrid.project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProjectRequestDTO {

    @NotBlank(message = "Project name is required")
    private String name;

    @Size(max = 255, message = "Project description must be at most 255 characters.")
    private String description;

    @Positive(message = "Organisation ID must be positive")
    @NotNull(message = "Organisation ID is required")
    private Long organisationId;
}
