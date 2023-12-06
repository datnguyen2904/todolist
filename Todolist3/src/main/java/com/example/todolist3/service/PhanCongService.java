package com.example.todolist3.service;

import com.example.todolist3.model.Phancong;
import com.example.todolist3.repository.dbcontext.DBcontext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhanCongService implements IPhanCong{
    @Autowired
    private DBcontext dBcontext;

    @Override
    public List<Phancong> getAll() {
        return dBcontext.phanCongRepo.findAll();
    }
}
