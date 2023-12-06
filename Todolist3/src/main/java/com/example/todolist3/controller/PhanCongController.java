package com.example.todolist3.controller;

import com.example.todolist3.model.Phancong;
import com.example.todolist3.model.Tag;
import com.example.todolist3.service.PhanCongService;
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
public class PhanCongController {
    @Autowired
    private PhanCongService phanCongService;

    @GetMapping(value = "/phancongs/all")
    public List<Phancong> getALl() {

        List<Phancong> phancongs =  phanCongService.getAll();
        return  phancongs;
    }
}

