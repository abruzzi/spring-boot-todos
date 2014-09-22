package com.tw.todos.controller;

import com.google.common.collect.Lists;
import com.tw.todos.Application;
import com.tw.todos.model.Todo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@WebAppConfiguration
@ActiveProfiles(value = "test")
@Transactional
@TransactionConfiguration(defaultRollback = true)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class })
public class TodoControllerTest {
    @Autowired
    private TodoController controller;

    @Test
    public void findAllTodoItems() {
        Iterable<Todo> todos = controller.getTodos();
        ArrayList<Todo> list = Lists.newArrayList(todos);
        assertEquals(0, list.size());
    }
}