package com.ramiaslan.todo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramiaslan.todo.service.TodoService;

@RestController
@RequestMapping("api/v1/todo")
public class TodoController {
	
	private final TodoService todoService;
	
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@PostMapping
	public ResponseEntity<?> createTodo(){
		todoService.createTodo();
		
		return null;
		
		
	}
	
	
	

}
