package com.example.todolist3.dto;

import com.example.todolist3.model.Tag;
import com.example.todolist3.model.User;

import java.util.ArrayList;
import java.util.List;

public interface TaskDTO {
     int getTaskId();
     String getTitle();
     Boolean getComplete();
     Boolean getImportant();
     Boolean getHide();

     List<String> getUserAvatars();
     List<String> getTagNames();

}
