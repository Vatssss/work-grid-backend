package com.workgrid.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workgrid.project.entity.ProjectEntity;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

}
