package ufrn.br.filmedatabaseapplication.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "filme_tbl")
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String titulo;
    Integer anoLancamento;
    String genero;
    String resumo;
    Float nota;

    public void regrasDeNegocioParaCadastro(){
        titulo.toUpperCase();
    }
}
