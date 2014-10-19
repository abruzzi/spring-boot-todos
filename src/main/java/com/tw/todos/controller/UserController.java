package com.tw.todos.controller;

import com.tw.todos.model.Todo;
import com.tw.todos.model.User;
import com.tw.todos.service.TodoService;
import com.tw.todos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TodoService todoService;

    @RequestMapping(method=RequestMethod.GET)
    public Map<String, Iterable<User>> getAll() {
        Map map = new HashMap();
        map.put("users", userService.findAll());
        return map;
    }

    @RequestMapping(value="{id}", method=RequestMethod.GET)
    public Map<String, User> getOne(@PathVariable(value="id") Long id) {
        Map map = new HashMap();
        map.put("user", userService.findOne(id));
        return map;
    }

    @RequestMapping(method=RequestMethod.POST)
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(value="{id}/todos", method=RequestMethod.GET)
    public Map<String, Iterable<Todo>> getAllTodos(@PathVariable(value="id") Long id) {
        User user = new User(id);
        Map map = new HashMap();
        map.put("todos", userService.getAllTodosFor(user));
        return map;
    }

    @RequestMapping(value="{id}/todos", method=RequestMethod.POST)
    public Todo createTodoForUser(@RequestBody Todo todo) {
        return todoService.save(todo);
    }

    @RequestMapping(value="{id}/todos/{todoId}", method=RequestMethod.GET)
    public Todo getTodo(@PathVariable(value="id") Long userId, @PathVariable(value="todoId") Long todoId) {
        User user = new User(userId);
        Todo todo = new Todo(todoId);
        return userService.getTodoFor(user, todo);
    }
}
