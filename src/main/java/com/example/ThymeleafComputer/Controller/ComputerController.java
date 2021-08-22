package com.example.ThymeleafComputer.Controller;


import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ComputerController {


    @GetMapping("/computers/")
    public String Index() {
        return "redirect:computerList";
    }

    @GetMapping("/computers/computerList")
    public String getComputers(final Model model) {

        model.addAttribute("message", "Welcome to SaveYourSpecs, please put your details below.");

        return "computers/computerList";
    }
}
