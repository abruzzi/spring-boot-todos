package com.tw.todos.controller;

import com.tw.todos.model.Todo;
import com.tw.todos.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/todos")
public class TodoController {
    @Autowired
    private TodoService service;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Todo> getAll() {
        return service.all();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public Todo getOne(@PathVariable(value="id") Long id) {
        return service.get(id);
    }

}
