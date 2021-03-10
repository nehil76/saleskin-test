package com.example.saleskin_test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.saleskin_test.exception.NoDataFoundException;
import com.example.saleskin_test.model.Todos;
import com.example.saleskin_test.service.TodoService;

@RestController
public class TodoController {

	@Autowired
	TodoService todoService;

	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public List<Todos> getAllTodos() {
		return todoService.findAll();
	}
	
	@RequestMapping(value = "/todos/active", method = RequestMethod.GET)
	public List<Todos> getActiveTodos() {
		return todoService.filterActiveTodos();
	}
	
	@RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
	public Todos findById(@PathVariable Long id) throws NoDataFoundException {
		return todoService.findByID(id);
	}

	@RequestMapping(value = "/todos", method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void saveTodos(@RequestBody List<Todos> todos) {
		todoService.saveTodos(todos);
	}

	@RequestMapping(value = "/todo", method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void saveTodo(@RequestBody Todos todo) {
		todoService.saveTodo(todo);
	}

	@RequestMapping(value = "/todo", method = RequestMethod.PUT)
	public void updateTodo(@RequestBody Todos todo) {
		todoService.saveTodo(todo);
	}

	@RequestMapping(value = "/todo", method = RequestMethod.DELETE)
	public void deleteTodo(@RequestBody Todos todo) {
		todoService.deleteTodo(todo);
	}

	@RequestMapping(value = "/todo/{id}", method = RequestMethod.DELETE)
	public void deleteTodo(@PathVariable Long id) {
		todoService.deleteTodoByID(id);
	}

}
