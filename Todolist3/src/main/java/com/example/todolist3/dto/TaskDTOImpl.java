package com.example.todolist3.dto;

import com.example.todolist3.model.Tag;
import com.example.todolist3.model.User;

import java.util.List;

    public class TaskDTOImpl {
        public int taskId;
        public String title;
        public Boolean complete;
        public Boolean important;
        public Boolean hide;
        public List<User> userAvatars;
        public List<Tag> tagNames;

    }
