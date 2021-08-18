package com.example.ThymeleafComputer.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ComputerController {

    @GetMapping
    String getComputer(Model model){
        model.addAttribute("something", "Hello World");
        return "computer";
    }
}
