package com.example.saleskin_test.service;

import java.util.List;
import java.util.Optional;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.saleskin_test.exception.NoDataFoundException;
import com.example.saleskin_test.model.Todos;
import com.example.saleskin_test.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	TodoRepository todoRepository;

	public List<Todos> findAll(){
		return todoRepository.findAll();
	}

	public Todos findByID(Long id) throws NoDataFoundException {
		Optional<Todos> todos = todoRepository.findById(id);
		if (todos.isPresent()) {
			return todos.get();
		} else {
			throw new NoDataFoundException("No data found for requested id");
		}

	}

	public void saveTodo(Todos todo) {
		todoRepository.save(todo);
	}

	public void saveTodos(List<Todos> todos) {
		todoRepository.saveAll(todos);
	}

	public void deleteTodo(Todos todo) {
		todoRepository.delete(todo);
	}

	public void deleteTodoByID(Long id) {
		todoRepository.deleteById(id);
	}
	
	public List<Todos> filterActiveTodos(){
		List<Todos> todos = this.findAll();
		return todos.stream().filter(x -> x.isActive() == true).collect(Collectors.toList());
	}

}
