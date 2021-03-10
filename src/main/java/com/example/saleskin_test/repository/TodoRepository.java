package com.example.saleskin_test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.saleskin_test.model.Todos;

@Repository
public interface TodoRepository extends JpaRepository<Todos, Long>{
	/*
	 * returns only active todos list
	 */
	public List<Todos> findByActive(boolean active);

}
