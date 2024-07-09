package ufrn.br.filmedatabaseapplication.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ufrn.br.filmedatabaseapplication.domain.Usuario;
import ufrn.br.filmedatabaseapplication.repository.UsuarioRepository;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    UsuarioRepository repository;

    public UserService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> optional = repository.findUsuarioByUsername(username);
        if(optional.isPresent()) {
            return optional.get();
        }
        throw new UsernameNotFoundException("User not found");
    }
}
