package com.rogeriogregorio.human_resources_worker.controllers;

import com.rogeriogregorio.human_resources_worker.entities.Worker;
import com.rogeriogregorio.human_resources_worker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

    private final Environment environment;
    private final WorkerRepository workerRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkerController.class);

    @Autowired
    public WorkerController(Environment environment, WorkerRepository workerRepository) {
        this.environment = environment;
        this.workerRepository = workerRepository;
    }

    @GetMapping
    public ResponseEntity<List<Worker>> getAll() {
        List<Worker> workerList = workerRepository.findAll();
        return ResponseEntity.ok(workerList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> getById(@PathVariable Long id) {
        String port = environment.getProperty("local.server.port");
        LOGGER.info("PORT = {}", port);
        Worker worker = workerRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(worker);
    }
}
