package com.example.todolist3.controller;

import com.example.todolist3.dto.TaskDTO;
import com.example.todolist3.dto.TaskDTOImpl;
import com.example.todolist3.model.Task;
import com.example.todolist3.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/todolist3")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping(value = "/tasks/all")
    public List<TaskDTOImpl> getAllTasksWithDetails() {
        return taskService.getAllTasksWithDetails();
    }

    @PutMapping(value = "/update_important")
    public Task updateImportant(@RequestParam int id) {
        return taskService.updateImportant(id);
    }
    @PutMapping(value = "/update_complete")
    public Task updateComplete(@RequestParam int id) {
        return taskService.updateComplete(id);
    }
    @PutMapping(value = "/update_hide")
    public Task updateHide(@RequestParam int id) {
        return taskService.updateHide(id);
    }

    @GetMapping(value = "/tasks/all/important")
    public List<TaskDTOImpl> getAllTaskByImportant() {
        return taskService.getAllTaskByImportant();
    }
    @GetMapping(value = "/tasks/all/complete")
    public List<TaskDTOImpl> getAllTaskByComplete() {
        return taskService.getAllTaskByComplete();
    }
    @GetMapping(value = "/tasks/all/hide")
    public List<TaskDTOImpl> getAllTaskByHide() {
        return taskService.getAllTaskByHide();
    }
}
