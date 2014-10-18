package com.tw.todos.service;

import com.tw.todos.model.Todo;
import com.tw.todos.model.User;
import com.tw.todos.repository.TodoRepository;
import com.tw.todos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TodoRepository todoRepository;

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public Iterable<Todo> getAllTodosFor(User user) {
        return todoRepository.findByUser(user);
    }

    public Todo getTodoFor(Long userId, Long todoId) {
        return null;
    }
}
