package com.example.ThymeleafComputer.Controller;


import com.example.ThymeleafComputer.Entity.Computer;
import com.example.ThymeleafComputer.Service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ComputerController {

    static final int DEFAULT_PAGE_SIZE = 2;

    private final ComputerService computerService;

    @Autowired
    public ComputerController(final ComputerService computerService) {
        this.computerService = computerService;
    }

    @GetMapping("/computers/")
    public String Index() {
        return "redirect:computerList";
    }

    @GetMapping("/computers/computerList")
    public String getComputers(final Model model,
                               @RequestParam(value = "page", defaultValue = "0") final int pageNumber,
                               @RequestParam(value = "size", defaultValue = DEFAULT_PAGE_SIZE + "") final int pageSize) {

        final Page<Computer> page = computerService.getComputers(pageNumber,pageSize);

        final int currentPageNumber = page.getNumber();
        final int previousPageNumber = page.hasPrevious() ? currentPageNumber - 1 : -1;
        final int nextPageNumber = page.hasNext() ? currentPageNumber + 1 : -1;

        model.addAttribute("computer", page.getContent());
        model.addAttribute("previousPageNumber", previousPageNumber);
        model.addAttribute("nextPageNumber", nextPageNumber);
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
