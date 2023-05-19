package com.app.delivery.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.delivery.api.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}
