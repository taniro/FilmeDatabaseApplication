package ufrn.br.filmedatabaseapplication.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "filme_tbl")
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Size(min = 2, max = 50, message = "Houve um erro no cadastro do campo título.")
    @NotBlank
    String titulo;

    @DecimalMin(value = "1900")
    Integer anoLancamento;
    String genero;
    String resumo;
    Float nota;

    public void regrasDeNegocioParaCadastro(){
        titulo.toUpperCase();
    }
}
