package com.example.todolist3.service;

import com.example.todolist3.dto.TaskDTO;
import com.example.todolist3.dto.TaskDTOImpl;
import com.example.todolist3.model.Task;

import java.util.List;

public interface ITask {

    public List<TaskDTOImpl> getAllTasksWithDetails();
    public Task updateImportant (int id);
    public Task updateComplete (int id);
    public Task updateHide (int id);
    public List<TaskDTOImpl> getAllTaskByImportant();
    public List<TaskDTOImpl> getAllTaskByComplete();
    public List<TaskDTOImpl> getAllTaskByHide();

}
