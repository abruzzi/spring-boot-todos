package com.tw.todos.controller;

import com.tw.todos.model.Todo;
import com.tw.todos.model.User;
import com.tw.todos.service.TodoService;
import com.tw.todos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TodoService todoService;

    @RequestMapping(method=RequestMethod.GET)
    public Iterable<User> getAll() {
        return userService.findAll();
    }

    @RequestMapping(value="{id}", method=RequestMethod.GET)
    public User getOne(@PathVariable(value="id") Long id) {
        return userService.findOne(id);
    }

    @RequestMapping(method=RequestMethod.POST)
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(value="{id}/todos", method=RequestMethod.GET)
    public Iterable<Todo> getAllTodos(@PathVariable(value="id") Long id) {
        User user = new User(id, null);
        return userService.getAllTodosFor(user);
    }

    @RequestMapping(value="{id}/todos", method=RequestMethod.POST)
    public Todo createTodoForUser(@RequestBody Todo todo) {
        return todoService.save(todo);
    }

    @RequestMapping(value="{id}/todos/{todoId}", method=RequestMethod.GET)
    public Todo getTodo(@PathVariable(value="id") Long userId, @PathVariable(value="todoId") Long todoId) {
        return userService.getTodoFor(userId, todoId);
    }
}
