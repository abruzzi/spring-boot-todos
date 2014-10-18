package com.tw.todos.service;

import com.tw.todos.model.Todo;
import com.tw.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    TodoRepository repository;

    public Iterable<Todo> all() {
        return repository.findAll();
    }

    public Todo get(Long id) {
        return repository.findOne(id);
    }

    public Todo save(Todo todo) {
        return repository.save(todo);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}
