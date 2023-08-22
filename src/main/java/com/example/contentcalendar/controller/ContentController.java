package com.example.contentcalendar.controller;

import com.example.contentcalendar.model.Content;
import com.example.contentcalendar.repository.ContentCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private ContentCollectionRepository repository;

    @Autowired
    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Content> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Content getContentById(@PathVariable Integer id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Content with that id is not found.")
                );
    }

    

    @PostMapping("")
    public void saveContent(@RequestBody Content content) {
        repository.save(content);
    }
}
