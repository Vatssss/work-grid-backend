package com.workgrid.organisation.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OrganisationRequestDTO {

    @NotBlank(message = "Organisation name cannot be blank")
    private String name;
}
