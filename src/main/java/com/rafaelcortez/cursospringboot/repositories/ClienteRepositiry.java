package com.rafaelcortez.cursospringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafaelcortez.cursospringboot.domain.Cliente;

@Repository
public interface ClienteRepositiry extends JpaRepository<Cliente, Integer> {

}
