package ufrn.br.filmedatabaseapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ufrn.br.filmedatabaseapplication.domain.Filme;

@SpringBootApplication
public class FilmeDatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilmeDatabaseApplication.class, args);

        Filme f = new Filme();
    }

}
