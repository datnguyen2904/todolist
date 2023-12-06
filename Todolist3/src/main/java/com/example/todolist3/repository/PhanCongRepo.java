package com.example.todolist3.repository;

import com.example.todolist3.model.Phancong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhanCongRepo extends JpaRepository<Phancong, Integer> {
}
