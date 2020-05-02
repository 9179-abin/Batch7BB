package com.cts.training.backendservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.training.backendservice.models.Users;

public interface UserRepo extends JpaRepository<Users, Integer> {

}
