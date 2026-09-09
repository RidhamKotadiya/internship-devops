package com.internship.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internship.backend.model.Deployment;

public interface DeploymentRepository
        extends JpaRepository<Deployment, Long> {
}