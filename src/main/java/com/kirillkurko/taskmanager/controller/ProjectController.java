package com.kirillkurko.taskmanager.controller;

import com.kirillkurko.taskmanager.model.entity.Project;
import com.kirillkurko.taskmanager.model.entity.Task;
import com.kirillkurko.taskmanager.model.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    public List<Project> getProjects() {
        return projectService.findAll();
    }

    @GetMapping("/projects/{projectId}")
    public Project getProject(@PathVariable int projectId) {
        Project project = new Project();
        try {
            project = projectService.findById(projectId);
        }
        catch (RuntimeException exception) {
            exception.printStackTrace();
        }
        return project;
    }

    @PostMapping("/projects")
    public Project addProject(@RequestBody Project project) {
        project.setId(0);
        projectService.save(project);
        return project;
    }

    @PutMapping("/projects")
    public Project updateProject(@RequestBody Project project) {
        projectService.save(project);
        return project;
    }

    @DeleteMapping("/projects/{projectId}")
    public String deleteProject(@PathVariable int projectId) {
        try {
            projectService.findById(projectId);
            projectService.deleteById(projectId);
            return "Deleted project id - " + projectId;
        }
        catch (RuntimeException exception) {
            exception.printStackTrace();
        }
        return "Project with id - " + projectId + " not found";
    }

    @PutMapping("/projects/{projectId}")
    public void addTask(@PathVariable int projectId, @RequestBody Task task) {
        try {
            Project project = projectService.findById(projectId);
            project.addTask(task);
            projectService.save(project);
        }
        catch (RuntimeException exception) {
            exception.printStackTrace();
        }
    }
}
