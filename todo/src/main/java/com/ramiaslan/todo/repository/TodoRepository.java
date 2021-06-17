package com.ramiaslan.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ramiaslan.todo.entity.Todo;


@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{

}
