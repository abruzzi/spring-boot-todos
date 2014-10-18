package com.tw.todos.controller;

import com.tw.todos.model.Todo;
import com.tw.todos.model.User;
import com.tw.todos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(method=RequestMethod.GET)
    public Iterable<User> getAll() {
        return service.findAll();
    }

    @RequestMapping(value="{id}", method=RequestMethod.GET)
    public User getOne(@PathVariable(value="id") Long id) {
        return service.findOne(id);
    }

    @RequestMapping(value="{id}/todos", method=RequestMethod.GET)
    public Iterable<Todo> getAllTodos(@PathVariable(value="id") Long id) {
        return service.getAllTodosFor(id);
    }

}
