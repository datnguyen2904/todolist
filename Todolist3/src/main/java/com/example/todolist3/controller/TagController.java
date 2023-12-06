package com.example.todolist3.controller;

import com.example.todolist3.model.Tag;
import com.example.todolist3.response.TagResponse;
import com.example.todolist3.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/todolist3")
public class TagController {
    @Autowired
    private TagService tagService;


    @GetMapping(value = "/tags/all")
    public List<Tag> getAllTag() {
        List<Tag> tags =  tagService.getAllTag();
        return tags;
    }
}
