package com.tw.todos.service;

import com.tw.todos.model.Todo;
import com.tw.todos.model.User;
import com.tw.todos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Iterable<User> findAll() {
        return repository.findAll();
    }

    public User findOne(Long id) {
        return repository.findOne(id);
    }

    public Iterable<Todo> getAllTodosFor(Long id) {
        User user = repository.findOne(id);
        if(user != null) {
            return user.getTodoList();
        }
        return null;
    }

}
