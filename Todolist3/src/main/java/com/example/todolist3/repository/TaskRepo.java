package com.example.todolist3.repository;

import com.example.todolist3.dto.TaskDTO;
import com.example.todolist3.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {

}
