package ufrn.br.filmedatabaseapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufrn.br.filmedatabaseapplication.domain.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findUsuarioByUsername(String username);
}
