package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoRepository repo;

    public TodoController(TodoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Todo> list() {
        return repo.findAll();
    }

    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody Todo todo) {
        if (todo.getName() == null || todo.getName().trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        Todo saved = repo.save(new Todo(null, todo.getName().trim()));
        return ResponseEntity.created(URI.create("/todos/" + saved.getId())).body(saved);
    }
}
