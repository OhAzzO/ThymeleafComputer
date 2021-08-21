package com.example.ThymeleafComputer.Service;

import com.example.ThymeleafComputer.Entity.Computer;
import com.example.ThymeleafComputer.Repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ComputerService {

    private final ComputerRepository computerRepository;

    //configure repository
    @Autowired
    public ComputerService(final ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }
    // list of computers displayed with page layout
    public Page<Computer> getComputers(final int pageNumber, final int size) {
        return computerRepository.findAll(PageRequest.of(pageNumber,size));
    }
    // get single computer (using Option in case no computers are there)
    public Optional<Computer> getComputer(final UUID computerId) {
        return computerRepository.findById(computerId);
    }

    public Computer save(final Computer computer) {
        return computerRepository.save(computer);
    }

    public void delete(final UUID computerId) {
        computerRepository.deleteById(computerId);
    }
}
