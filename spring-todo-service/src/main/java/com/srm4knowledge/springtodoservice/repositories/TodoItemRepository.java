package com.srm4knowledge.springtodoservice.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srm4knowledge.springtodoservice.repositories.domain.TodoItem;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {

	// @Query("SELECT ti FROM TodoItem ti WHERE ti.userId = :userId")
	public Optional<List<TodoItem>> findByUserId(long userId);

	public Optional<TodoItem> findByIdAndUserId(long id, long userId);

	public void deleteByUserId(long userId);

}
