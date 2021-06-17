package com.ramiaslan.todo.controller.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class TodoUpdateRequest {
	
	@Positive(message = "id must be greater than 0")
	private Long id;
	
	@NotNull(message = "must not be null")
	private Boolean status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
