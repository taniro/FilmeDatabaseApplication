package ufrn.br.filmedatabaseapplication.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ufrn.br.filmedatabaseapplication.domain.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
