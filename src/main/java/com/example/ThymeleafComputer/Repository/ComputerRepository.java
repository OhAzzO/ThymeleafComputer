package com.example.ThymeleafComputer.Repository;

import com.example.ThymeleafComputer.Entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, UUID> {
    
}
