package ufrn.br.filmedatabaseapplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.CacheControl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ufrn.br.filmedatabaseapplication.domain.Filme;
import ufrn.br.filmedatabaseapplication.domain.Usuario;
import ufrn.br.filmedatabaseapplication.repository.UsuarioRepository;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class FilmeDatabaseApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(FilmeDatabaseApplication.class, args);

        Filme f = new Filme();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Register resource handler for images
        registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/")
                .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());

    }

    @Bean
    CommandLineRunner commandLineRunner(UsuarioRepository usuarioRepository, PasswordEncoder encoder) {
        return args -> {

            usuarioRepository.deleteAll();

            List<Usuario> users = Arrays.asList(
                    new Usuario(0l, "joao", encoder.encode("joao"), "joao@mail.com", true),
                    new Usuario(0l, "maria", encoder.encode("maria"), "maria@mail.com", false),
                    new Usuario(0l, "pedro", encoder.encode("pedro"), "pedro@mail.com", false)

            );
            usuarioRepository.saveAll(users);
        };
    }
}
