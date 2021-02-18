package com.kirillkurko.taskmanager.model.service;

import com.kirillkurko.taskmanager.model.entity.Project;

import java.util.List;

public interface ProjectService {

    List<Project> findAll();

    void save(Project project);

    Project findById(int id);

    void deleteById(int id);
}
