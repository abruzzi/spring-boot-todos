package com.tw.todos.repository;

import com.tw.todos.model.Todo;
import com.tw.todos.model.User;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
    Iterable<Todo> findByUser(User user);
}
