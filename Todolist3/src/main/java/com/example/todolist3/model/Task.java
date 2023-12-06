package com.example.todolist3.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taskid")
    private int taskId;

    @Column (name= "title")
    private String title;

    @Column(name = "duedate")
    @Temporal(TemporalType.DATE)
    private Date duedate;
    @Column(name = "description")
    private String description;
    @Column(name = "complete", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean complete = false;
    @Column(name = "important", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean important = false;
    @Column(name = "hide", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean hide = false;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "task")
    @JsonManagedReference
    private List<Phancong> phancongs;

    public Task() {
        // Set default values here
        this.complete = false;
        this.important = false;
        this.hide = false;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public Boolean getImportant() {
        return important;
    }

    public void setImportant(Boolean important) {
        this.important = important;
    }

    public Boolean getHide() {
        return hide;
    }

    public void setHide(Boolean hide) {
        this.hide = hide;
    }

    public List<Phancong> getPhancongs() {
        return phancongs;
    }

    public void setPhancongs(List<Phancong> phancongs) {
        this.phancongs = phancongs;
    }
}
