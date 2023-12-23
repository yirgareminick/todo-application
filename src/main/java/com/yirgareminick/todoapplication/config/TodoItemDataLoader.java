package com.yirgareminick.todoapplication.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.yirgareminick.todoapplication.models.TodoItem;
import com.yirgareminick.todoapplication.repositories.TodoItemRepository;

@Component
public class TodoItemDataLoader implements CommandLineRunner {
    
    private final Logger logger = LoggerFactory.getLogger(TodoItemDataLoader.class);

    @Autowired
    TodoItemRepository todoItemRepository;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    private void loadSeedData() {
        if (todoItemRepository.count() == 0) {
            TodoItem todoItem1 = new TodoItem("get the milk");
            TodoItem todoItem2 = new TodoItem("wash the car");

            todoItemRepository.save(todoItem1);
            todoItemRepository.save(todoItem2);
        }

        logger.info("Number of TodoItems; {}", todoItemRepository.count());
    }

}
