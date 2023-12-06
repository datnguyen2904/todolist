package com.example.todolist3.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "phancong")
public class Phancong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "taskid", updatable = false, insertable = false)
    private int taskId;
    @Column(name = "tagid", updatable = false, insertable = false)
    private int tagId;
    @Column(name = "userid", updatable = false, insertable = false)
    private int userId;

    @ManyToOne
    @JoinColumn(name = "taskid")
    @JsonBackReference
    private Task task;

    @ManyToOne
    @JoinColumn(name = "tagid")
    @JsonBackReference
    private Tag tag;

    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonBackReference
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
