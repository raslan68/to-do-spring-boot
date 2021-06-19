package com.ramiaslan.todo.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.ramiaslan.todo.controller.request.TodoCreateRequest;
import com.ramiaslan.todo.controller.request.TodoUpdateRequest;
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
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> createTodo(@Valid @RequestBody TodoCreateRequest todoCreateRequest){
		todoService.createTodo(todoCreateRequest);
		return ResponseEntity.ok(new GenericResponse(201,"Successfully created."));
	}
	
	@PutMapping
	public ResponseEntity<?> updateTodo(@Valid @RequestBody TodoUpdateRequest todoUpdateRequest) {
		todoService.updateTodo(todoUpdateRequest);
		return ResponseEntity.ok(new GenericResponse(200, "Successfully updated"));
	}	

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTodo(@PathVariable("id") Long id ){
		todoService.deleteTodo(id);
		return ResponseEntity.ok(new GenericResponse(200, "Successfully deleted"));	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TodoResponse> getTodoById(@PathVariable("id") Long id){
		TodoResponse todoResponse = todoService.getTodoById(id);		
		return ResponseEntity.ok(todoResponse);	
	}
	
	@GetMapping
	public ResponseEntity<List<TodoResponse>> getAllTodos(){
		List<TodoResponse> allTodos = todoService.getAllTodos();
		return ResponseEntity.ok(allTodos);
	}
	
	@GetMapping("/slice")
	public ResponseEntity<List<TodoResponse>> slice(Pageable pageable){
		List<TodoResponse>  result =  todoService.slice(pageable);
		return ResponseEntity.ok(result);
		
	}

}
