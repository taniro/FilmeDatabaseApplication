package ufrn.br.filmedatabaseapplication.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ufrn.br.filmedatabaseapplication.domain.Filme;

public interface FilmeRepository extends JpaRepository<Filme, String> {


}
