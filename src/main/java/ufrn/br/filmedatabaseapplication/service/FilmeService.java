package ufrn.br.filmedatabaseapplication.service;

import org.springframework.stereotype.Service;
import ufrn.br.filmedatabaseapplication.domain.Filme;
import ufrn.br.filmedatabaseapplication.repository.FilmeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    private final FilmeRepository repository;
    public FilmeService(FilmeRepository repository) {
        this.repository = repository;
    }

    public Optional<Filme> findById(Long id){
        return repository.findById(id);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Filme update(Filme f){
       return repository.saveAndFlush(f);
    }

    public Filme create(Filme f){
        f.regrasDeNegocioParaCadastro();
        return repository.save(f);
    }

    public List<Filme> findAll(){
        return repository.findAll();
    }
}
