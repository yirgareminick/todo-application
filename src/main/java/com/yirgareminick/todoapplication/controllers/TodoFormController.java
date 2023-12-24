package com.yirgareminick.todoapplication.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yirgareminick.todoapplication.models.TodoItem;
import com.yirgareminick.todoapplication.repositories.TodoItemRepository;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TodoFormController {
    
    private final Logger logger = LoggerFactory.getLogger(TodoFormController.class);

    @Autowired
    private TodoItemRepository todoItemRepository;

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        TodoItem todoItem = todoItemRepository.findById(id).orElse(null);

        if (todoItem == null) {
            logger.error("TodoItem id: {} not found", id);
            throw new IllegalArgumentException("TodoItem id: " + id + " not found");
        } else {
            model.addAttribute("todo", todoItem);
            return "update-todo-item";
        } 
    }

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") long id, Model model) {
        TodoItem todoItem = todoItemRepository.findById(id).orElse(null);

        if (todoItem == null) {
            logger.error("TodoItem id: {} not found", id);
            throw new IllegalArgumentException("TodoItem id: " + id + " not found");
        } else {
            todoItemRepository.delete(todoItem);
            return "redirect:/";
        }
    
}
}
