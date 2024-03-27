package com.rujuu.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rujuu.todo.repo.TodoRepository;
import com.rujuu.todo.model.Todo;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {

	@Autowired
	private TodoRepository TodoRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		TodoRepository.save(new Todo("a", true));
		TodoRepository.save(new Todo("b", false));
		TodoRepository.save(new Todo("ccc", false));
	}

}
