package com.ramiaslan.todo.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ramiaslan.todo.controller.request.TodoCreateRequest;
import com.ramiaslan.todo.controller.response.GenericResponse;
import com.ramiaslan.todo.controller.response.TodoResponse;
import com.ramiaslan.todo.service.TodoService;


@RestController
@RequestMapping("api/v1/todo")
public class TodoController {
	
	private final TodoService todoService;
	
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@PostMapping
	public ResponseEntity<?> createTodo(@Valid @RequestBody TodoCreateRequest todoCreateRequest){
		todoService.createTodo(todoCreateRequest);
		
		return ResponseEntity.ok(new GenericResponse(200,"Successfully created."));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TodoResponse> getTodoById(@PathVariable("id") Long id){
		TodoResponse todoResponse = todoService.getTodoById(id);		
		return ResponseEntity.ok(todoResponse);
		
	}

}
