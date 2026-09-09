package com.internship.backend.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internship.backend.model.Deployment;
import com.internship.backend.repository.DeploymentRepository;

@RestController
@RequestMapping("/deployments")
@CrossOrigin("*")
public class DeploymentController {

    private final DeploymentRepository repository;

    public DeploymentController(DeploymentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Deployment> getAllDeployments() {
        return repository.findAll();
    }

    @PostMapping
    public Deployment createDeployment(@RequestBody Deployment deployment) {

        deployment.setDeploymentTime(LocalDateTime.now());

        return repository.save(deployment);
    }
}