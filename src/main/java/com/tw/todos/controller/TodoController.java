package com.tw.todos.controller;

import com.tw.todos.model.Todo;
import com.tw.todos.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/todos")
public class TodoController {
    @Autowired
    private TodoService service;

    @RequestMapping
    @ResponseBody
    public Iterable<Todo> getTodos() {
        return service.all();
    }
}
