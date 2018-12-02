package com.srm4knowledge.springbootestingexample.services.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srm4knowledge.springbootestingexample.services.todo.domain.TodoItem;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {

}
