package com.app.delivery.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.delivery.api.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}
