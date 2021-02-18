package com.kirillkurko.taskmanager.model.service;

import com.kirillkurko.taskmanager.model.entity.TaskStatus;

public interface TaskStatusService {

    TaskStatus findById(int id);
}
