package com.kirillkurko.taskmanager.controller;

import com.kirillkurko.taskmanager.model.entity.Task;
import com.kirillkurko.taskmanager.model.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskService.findAll();
    }

    @GetMapping("/tasks/{taskId}")
    public Task getTask(@PathVariable int taskId) {
        Task task = new Task();
        try {
            task = taskService.findById(taskId);
        }
        catch (RuntimeException exception) {
            exception.printStackTrace();;
        }
        return task;
    }

    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task task) {
        task.setId(0);
        taskService.save(task);
        return task;
    }

    @PutMapping("/tasks")
    public Task updateTask(@RequestBody Task task) {
        taskService.save(task);
        return task;
    }

    @DeleteMapping("/tasks/{taskId}")
    public String deleteTask(@PathVariable int taskId) {
        try {
            taskService.findById(taskId);
            taskService.deleteById(taskId);
            return "Deleted task id - " + taskId;
        }
        catch (RuntimeException exception) {
            exception.printStackTrace();
        }
        return "Task with id - " + taskId + " not found";
    }
}
