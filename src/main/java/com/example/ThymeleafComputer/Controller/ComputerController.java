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

    @GetMapping("/computers/add")
    public String add() {
        return "computers/add";
    }

    @GetMapping("/computers/view")
    public String view() {
        return "computers/view";
    }

    @GetMapping("/computers/edit")
    public String edit() {
        return "computers/edit";
    }

    @GetMapping("/computers/remove")
    public String remove() {
        return "computers/remove";
    }
}
