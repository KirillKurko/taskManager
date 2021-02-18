package com.kirillkurko.taskmanager.model.service.implementation;

import com.kirillkurko.taskmanager.model.entity.TaskStatus;
import com.kirillkurko.taskmanager.model.repository.TaskStatusRepository;
import com.kirillkurko.taskmanager.model.service.TaskStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class TaskStatusServiceImplementation implements TaskStatusService {

    private final TaskStatusRepository taskStatusRepository;

    @Autowired public TaskStatusServiceImplementation(TaskStatusRepository taskStatusRepository) {
        this.taskStatusRepository = taskStatusRepository;
    }

    @Override
    @Transactional
    public TaskStatus findById(int id) {
        Optional<TaskStatus> status = taskStatusRepository.findById(id);
        if (status.isPresent()) {
            return status.get();
        }
        else {
            throw new RuntimeException("Status with id = " + id + " not found");
        }
    }
}
