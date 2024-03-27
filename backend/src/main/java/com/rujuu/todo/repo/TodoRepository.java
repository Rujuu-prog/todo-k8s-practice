package com.rujuu.todo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rujuu.todo.model.Todo;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

}
