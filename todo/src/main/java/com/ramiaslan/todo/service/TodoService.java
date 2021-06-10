package com.ramiaslan.todo.service;

import org.springframework.stereotype.Service;

import com.ramiaslan.todo.entity.Todo;
import com.ramiaslan.todo.repository.TodoRepository;

@Service
public class TodoService {

	private final TodoRepository todoRepository;

	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public void createTodo() {
				//!!!!!!!!

	}

}
