package com.ramiaslan.todo.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ramiaslan.todo.controller.request.TodoCreateRequest;
import com.ramiaslan.todo.controller.request.TodoUpdateRequest;
import com.ramiaslan.todo.controller.response.TodoResponse;
import com.ramiaslan.todo.entity.Todo;
import com.ramiaslan.todo.exception.TodoException;
import com.ramiaslan.todo.repository.TodoRepository;

@Service
public class TodoService {

	private final TodoRepository todoRepository;

	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	/**
	 * Create Todo
	 * @param Todo Create Request
	 */
	public void createTodo(TodoCreateRequest todoCreateRequest) {
		String text = todoCreateRequest.getText();
		Boolean status = todoCreateRequest.getStatus();
		
		Todo todo = new Todo();
		todo.setText(text);
		todo.setStatus(status);
		
		todoRepository.save(todo);
	}

	/**
	 * Update Todo
	 * @param Todo Update Request
	 */
	public void updateTodo(TodoUpdateRequest todoUpdateRequest) {
		Long id = todoUpdateRequest.getId();
		Boolean status = todoUpdateRequest.getStatus();
		
		Optional<Todo> todo = findById(id);
		
		todo.get().setStatus(status);
		todoRepository.save(todo.get());
	}

	/**
	 * Delete Todo
	 * @param id
	 */
	public void deleteTodo(Long id) {
		findById(id);
	
		todoRepository.deleteById(id);
	}
	
	/**
	 * Get Todo By Id
	 * @param id
	 * @return Todo Response
	 */
	public TodoResponse getTodoById(Long id) {
		Optional<Todo> todo = findById(id);
		
		TodoResponse todoResponse = convert(todo.get());
		
		return todoResponse; 
	}

	/**
	 * Get All Todos
	 * @return List of Todo Response
	 */
	public List<TodoResponse> getAllTodos() {
		/**
		return todoRepository.findAll().stream()
				.map(todo -> convert(todo))
				.collect(Collectors.toList());
		*/
		
		return todoRepository.findAll().stream()
				.map(this::convert)
				.collect(Collectors.toList());
	}

	/**
	 * Find By Id
	 * @param id
	 * @return Optional of Todo
	 */
	private Optional<Todo> findById(Long id) {
		Optional<Todo> todo = todoRepository.findById(id);
		if(todo.isEmpty()) {
			throw new TodoException("todo not found");
		}
		return todo;
	}

	/**
	 * Convert Todo Entity to Todo Response
	 * @param Todo
	 * @return Todo Response
	 */
	private TodoResponse convert(Todo todo) {
		TodoResponse todoResponse = new TodoResponse();
		todoResponse.setId(todo.getId());
		todoResponse.setText(todo.getText());
		todoResponse.setStatus(todo.getStatus());
		
		return todoResponse;	
	}

}
