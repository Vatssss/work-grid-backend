package com.workgrid.common.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class BaseAuditEntity {
	
	@Column(name = "created_by", nullable = false, length = 45, updatable = false)
	@CreatedBy
	private String createdBy;

	@Column(name = "created_at", nullable = false, updatable = false)
	@CreatedDate
	private LocalDateTime createdAt;

	@Column(name = "last_updated_by", nullable = false, length = 45)
	@LastModifiedBy
	private String lastUpdatedBy;

	@Column(name = "last_updated_at", nullable = false)
	@LastModifiedDate
	private LocalDateTime lastUpdatedAt;
}
