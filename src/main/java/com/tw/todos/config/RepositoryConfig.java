package com.tw.todos.config;

import com.tw.todos.model.Todo;
import com.tw.todos.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
public class RepositoryConfig extends
        RepositoryRestMvcConfiguration {

    @Override
    protected void configureRepositoryRestConfiguration(
            RepositoryRestConfiguration config) {
        config.exposeIdsFor(User.class, Todo.class);
    }
}
