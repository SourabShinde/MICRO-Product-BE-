package com.app.product.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public abstract class AuditableEntity<T> {

	@CreatedBy
	@JsonProperty("created_by")
	protected T createdBy;

	@JsonProperty("created_date")
	@CreatedDate
	@JsonFormat(pattern = "dd-MMM-yyy")
	protected Date createdDate;

	@LastModifiedBy
	@JsonProperty("updated_by")
	protected T updatedBy;

	@JsonProperty("updated_date")
	@LastModifiedDate
	@JsonFormat(pattern = "dd-MMM-yyy")
	protected Date updatedDate;
}
