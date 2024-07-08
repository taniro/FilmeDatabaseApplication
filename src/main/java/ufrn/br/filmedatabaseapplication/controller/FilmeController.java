package ufrn.br.filmedatabaseapplication.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ufrn.br.filmedatabaseapplication.domain.Filme;
import ufrn.br.filmedatabaseapplication.service.FileStorageService;
import ufrn.br.filmedatabaseapplication.service.FilmeService;

import java.util.Optional;

@Controller
public class FilmeController {

    private final FilmeService service;
    private final FileStorageService fileStorageService;

    public FilmeController(FilmeService service, FileStorageService fileStorageService) {
        this.service = service;
        this.fileStorageService = fileStorageService;
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
    public ModelAndView processCadastroPage(@ModelAttribute @Valid Filme f, Errors errors, @RequestParam("file") MultipartFile file){

        if(errors.hasErrors()){
            return new ModelAndView("cadastroPage");
        }

        f.setImageUrl(file.getOriginalFilename());
        fileStorageService.save(file);

        service.create(f);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("msg", "Cadastro realizado com sucesso");
        modelAndView.addObject("filmes", service.findAll());
        return modelAndView;
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








