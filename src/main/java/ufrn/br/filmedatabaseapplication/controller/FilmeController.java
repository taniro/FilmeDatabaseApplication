package ufrn.br.filmedatabaseapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ufrn.br.filmedatabaseapplication.repository.FilmeRepository;
import ufrn.br.filmedatabaseapplication.service.FilmeService;

@Controller
public class FilmeController {

    private final FilmeService service;
    public FilmeController(FilmeService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String listAll(Model model){
        model.addAttribute("filmes", service.findAll());
        return "index";
    }
}
