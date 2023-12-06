package com.example.todolist3.repository.dbcontext;

import com.example.todolist3.repository.PhanCongRepo;
import com.example.todolist3.repository.TagRepo;
import com.example.todolist3.repository.TaskRepo;
import com.example.todolist3.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBcontext {
    @Autowired
    public TagRepo tagRepo;
    @Autowired
    public TaskRepo taskRepo;
    @Autowired
    public UserRepo userRepo;
    @Autowired
    public PhanCongRepo phanCongRepo;
}
