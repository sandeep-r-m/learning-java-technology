package com.srm4knowledge.springtodoservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.srm4knowledge.springtodoservice.repositories.domain.TodoItem;

@Repository
public interface TodoItemRepository extends CrudRepository<TodoItem, Long> {

}
