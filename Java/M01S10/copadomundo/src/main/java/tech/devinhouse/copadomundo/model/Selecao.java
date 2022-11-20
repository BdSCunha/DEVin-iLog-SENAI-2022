package tech.devinhouse.copadomundo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "selecoes")
public class Selecao {
    @Id
    @Column(name = "sigla", nullable = false)
    private String sigla;

    private String nome;

    private String grupo;

    private LocalDateTime dataCadastro;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private List<Jogador> jogadores;
}
