package com.ramiaslan.todo.service;


import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ramiaslan.todo.controller.request.TodoCreateRequest;
import com.ramiaslan.todo.controller.response.TodoResponse;
import com.ramiaslan.todo.entity.Todo;
import com.ramiaslan.todo.repository.TodoRepository;

@Service
public class TodoService {

	private final TodoRepository todoRepository;

	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public void createTodo(TodoCreateRequest todoCreateRequest) {
		
		String text = todoCreateRequest.getText(); //text
		Boolean status = todoCreateRequest.getStatus(); //status
		
		Todo todo = new Todo();
		todo.setText(text);
		todo.setStatus(status);
		
		todoRepository.save(todo);
	}
	
	public TodoResponse getTodoById(Long id) {
		
		Optional<Todo> todo = todoRepository.findById(id);
		if (todo.isEmpty()) {
			return null;
		}
		
		Long id1 = todo.get().getId();
		String text = todo.get().getText();
		Boolean status = todo.get().getStatus();
		
		TodoResponse todoResponse = new TodoResponse();
		todoResponse.setId(id1);
		todoResponse.setText(text);
		todoResponse.setStatus(status);
		
		return todoResponse; 
		
	}

}
