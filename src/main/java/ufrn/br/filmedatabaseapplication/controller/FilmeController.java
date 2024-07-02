package ufrn.br.filmedatabaseapplication.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ufrn.br.filmedatabaseapplication.domain.Filme;
import ufrn.br.filmedatabaseapplication.repository.FilmeRepository;
import ufrn.br.filmedatabaseapplication.service.FilmeService;

import java.util.Optional;

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

    @GetMapping("/cadastroPage")
    public String getCadastroPage(Model model){
        Filme f = new Filme();
        model.addAttribute("filme", f);
        return "cadastroPage";
    }

    @PostMapping("/processCadastroPage")
    public String processCadastroPage(@ModelAttribute @Valid Filme f, Errors errors, RedirectAttributes redirectAttributes){

        if(errors.hasErrors()){
            return "cadastroPage";
        }

        service.create(f);
        redirectAttributes.addAttribute("msg", "Cadastro realizado com sucesso");
        return "redirect:/";
    }

    @PostMapping("/processEditPage")
    public String processEditPage(@ModelAttribute Filme f){

        Optional<Filme> filme = service.findById(f.getId());
        if (filme.isPresent()){
            service.update(f);
        }
        return "redirect:/";
    }

    @GetMapping("/processDelete/{id}")
    public String processDelete(@PathVariable String id){
        service.delete(id);
        return "redirect:/";
    }

    @GetMapping("/editPage/{id}")
    public ModelAndView getEditPage(@PathVariable String id){

        Optional<Filme> filme = service.findById(id);
        if (filme.isPresent()){
            ModelAndView mv = new ModelAndView("editPage");
            mv.addObject("filme", filme.get());
            return mv;
        }else{
            return new ModelAndView("redirect:/");
        }
    }
}








