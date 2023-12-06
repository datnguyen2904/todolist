package com.example.todolist3.service;

import com.example.todolist3.model.Tag;
import com.example.todolist3.model.User;
import com.example.todolist3.repository.dbcontext.DBcontext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUser{
    @Autowired
    private DBcontext dBcontext;

    @Override
    public List<User> getAllUser() {
        return dBcontext.userRepo.findAll();
    }
}
