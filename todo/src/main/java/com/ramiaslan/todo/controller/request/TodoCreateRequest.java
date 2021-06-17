package com.ramiaslan.todo.controller.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TodoCreateRequest {
	
	@Size(min = 4, max = 250, message = "Text size must be between {min} and {max}")
	@NotBlank(message = "This field must not null and empty")// not null and empty
	private String text;
	
	@NotNull(message = "must not be null")
	private Boolean status;
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public Boolean getStatus() {
		return status;
	}
	
	public void setStatus(Boolean status) {
		this.status = status;
	}

}
