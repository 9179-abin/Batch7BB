package com.cts.training.backendservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.training.backendservice.models.Delivery;

public interface DeliveryRepo extends JpaRepository<Delivery, Integer> {

}
