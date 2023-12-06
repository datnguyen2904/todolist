package com.example.todolist3.service;

import com.example.todolist3.dto.PhanCongDTO;
import com.example.todolist3.dto.TaskDTO;
import com.example.todolist3.dto.TaskDTOImpl;
import com.example.todolist3.model.Phancong;
import com.example.todolist3.model.Tag;
import com.example.todolist3.model.Task;
import com.example.todolist3.model.User;
import com.example.todolist3.repository.dbcontext.DBcontext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService implements ITask{
    @Autowired
    private DBcontext dBcontext;

    @Override
    public List<TaskDTOImpl> getAllTasksWithDetails() {
        List<Task> tasks = dBcontext.taskRepo.findAll();
        List<TaskDTOImpl> taskDTOS = new ArrayList<>();
        tasks.forEach(x->{
            TaskDTOImpl taskDTO = new TaskDTOImpl();
            taskDTO.taskId = x.getTaskId();
            taskDTO.hide = x.getHide();
            taskDTO.complete = x.getComplete();
            taskDTO.title = x.getTitle();
            taskDTO.important = x.getImportant();
            System.out.println(x.getPhancongs().size());
            List<Tag> tags = new ArrayList<>();
            List<User> users = new ArrayList<>();
            x.getPhancongs().forEach(y->{
                Optional<Tag> tag = dBcontext.tagRepo.findById(y.getTagId());
                Optional<User> user = dBcontext.userRepo.findById(y.getUserId());
               tags.add(tag.get());
               users.add(user.get());
            });
            taskDTO.tagNames = tags;
            taskDTO.userAvatars = users;
//            taskDTO.tagNames = dBcontext.tagRepo.findAll().stream().filter(y->x.getPhancongs().stream().anyMatch(z->z.getTaskId() == x.getTaskId())).toList();
//            taskDTO.userAvatars = dBcontext.userRepo.findAll().stream().filter(y->y.getUserId() == x.getPhancongs().get(0).getUserId()).toList();
            taskDTOS.add(taskDTO);
        });
        return taskDTOS;
    }


    @Override
    public Task updateImportant(int id) {
        Optional<Task> taskOptional = dBcontext.taskRepo.findById(id);
        if(taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setImportant(!task.getImportant());
            dBcontext.taskRepo.save(task);
            return task;
        }
        return null;
    }

    @Override
    public Task updateComplete(int id) {
        Optional<Task> taskOptional = dBcontext.taskRepo.findById(id);
        if(taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setComplete(!task.getComplete());
            dBcontext.taskRepo.save(task);
            return task;
        }
        return null;
    }

    @Override
    public Task updateHide(int id) {
        Optional<Task> taskOptional = dBcontext.taskRepo.findById(id);
        if(taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setHide(!task.getHide());
            dBcontext.taskRepo.save(task);
            return task;
        }
        return null;
    }

    @Override
    public List<TaskDTOImpl> getAllTaskByImportant() {
        List<Task> tasks = dBcontext.taskRepo.findAll();
        List<TaskDTOImpl> importantTaskDTOS = new ArrayList<>();

        tasks.stream()
                .filter(Task::getImportant)  // Filter tasks with important = true
                .forEach(x -> {
                    TaskDTOImpl taskDTO = new TaskDTOImpl();
                    taskDTO.taskId = x.getTaskId();
                    taskDTO.hide = x.getHide();
                    taskDTO.complete = x.getComplete();
                    taskDTO.title = x.getTitle();
                    taskDTO.important = x.getImportant();
                    System.out.println(x.getPhancongs().size());

                    List<Tag> tags = new ArrayList<>();
                    List<User> users = new ArrayList<>();

                    x.getPhancongs().forEach(y -> {
                        Optional<Tag> tag = dBcontext.tagRepo.findById(y.getTagId());
                        Optional<User> user = dBcontext.userRepo.findById(y.getUserId());
                        tags.add(tag.get());
                        users.add(user.get());
                    });

                    taskDTO.tagNames =tags;
                    taskDTO.userAvatars = users;
                    importantTaskDTOS.add(taskDTO);
                });

        return importantTaskDTOS;
    }

    @Override
    public List<TaskDTOImpl> getAllTaskByComplete() {
        List<Task> tasks = dBcontext.taskRepo.findAll();
        List<TaskDTOImpl> importantTaskDTOS = new ArrayList<>();

        tasks.stream()
                .filter(Task::getComplete)  // Filter tasks with important = true
                .forEach(x -> {
                    TaskDTOImpl taskDTO = new TaskDTOImpl();
                    taskDTO.taskId = x.getTaskId();
                    taskDTO.hide = x.getHide();
                    taskDTO.complete = x.getComplete();
                    taskDTO.title = x.getTitle();
                    taskDTO.important = x.getImportant();
                    System.out.println(x.getPhancongs().size());

                    List<Tag> tags = new ArrayList<>();
                    List<User> users = new ArrayList<>();

                    x.getPhancongs().forEach(y -> {
                        Optional<Tag> tag = dBcontext.tagRepo.findById(y.getTagId());
                        Optional<User> user = dBcontext.userRepo.findById(y.getUserId());
                        tags.add(tag.get());
                        users.add(user.get());
                    });

                    taskDTO.tagNames =tags;
                    taskDTO.userAvatars = users;
                    importantTaskDTOS.add(taskDTO);
                });

        return importantTaskDTOS;

    }

    @Override
    public List<TaskDTOImpl> getAllTaskByHide() {
        List<Task> tasks = dBcontext.taskRepo.findAll();
        List<TaskDTOImpl> importantTaskDTOS = new ArrayList<>();

        tasks.stream()
                .filter(Task::getHide)  // Filter tasks with important = true
                .forEach(x -> {
                    TaskDTOImpl taskDTO = new TaskDTOImpl();
                    taskDTO.taskId = x.getTaskId();
                    taskDTO.hide = x.getHide();
                    taskDTO.complete = x.getComplete();
                    taskDTO.title = x.getTitle();
                    taskDTO.important = x.getImportant();
                    System.out.println(x.getPhancongs().size());

                    List<Tag> tags = new ArrayList<>();
                    List<User> users = new ArrayList<>();

                    x.getPhancongs().forEach(y -> {
                        Optional<Tag> tag = dBcontext.tagRepo.findById(y.getTagId());
                        Optional<User> user = dBcontext.userRepo.findById(y.getUserId());
                        tags.add(tag.get());
                        users.add(user.get());
                    });

                    taskDTO.tagNames =tags;
                    taskDTO.userAvatars = users;
                    importantTaskDTOS.add(taskDTO);
                });

        return importantTaskDTOS;
    }

    public TaskDTOImpl addTask(TaskDTOImpl taskDTO) {
        // Chuyển đổi TaskDTOImpl thành Task entity
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setComplete(taskDTO.getComplete());
        task.setImportant(taskDTO.getImportant());
        task.setHide(taskDTO.getHide());
        task.setUserAvatars(taskDTO.getUserAvatars());
        task.setTagNames(taskDTO.getTagNames());

        // Lưu task mới vào cơ sở dữ liệu
        taskRepository.save(task);

        // Trả về DTO của task đã được lưu
        return convertTaskToDTO(task);
    }
}
