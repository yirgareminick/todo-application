package com.yirgareminick.todoapplication.repositories;

import org.springframework.data.repository.CrudRepository;

import com.yirgareminick.todoapplication.models.TodoItem;

public interface TodoItemRepository extends CrudRepository<TodoItem, Long>{
}
