package com.example.ThymeleafComputer.Controller;

import com.example.ThymeleafComputer.Entity.Computers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class ComputerController {

    @GetMapping
    String getComputer(Model model){
        model.addAttribute("something", "Hello World");
        model.addAttribute("computers", Arrays.asList(
                new Computers(1, "Test first PC", "Test First PARTS", 100.00),
                new Computers(2,"Test Second PC", "Test secondParts", 200.00),
                new Computers(3,"Test Third PC", "Test thirdParts", 200.00)
        ));
        return "computers";
    }
}
