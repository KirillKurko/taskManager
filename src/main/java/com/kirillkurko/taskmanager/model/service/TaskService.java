package com.kirillkurko.taskmanager.model.service;

import com.kirillkurko.taskmanager.model.entity.Task;

import java.util.List;

public interface TaskService {

    List<Task> findAll();

    void save(Task task);

    Task findById(int id);

    void deleteById(int id);
}
