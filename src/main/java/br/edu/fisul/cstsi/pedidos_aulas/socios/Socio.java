package br.edu.fisul.cstsi.pedidos_aulas.socios;

import br.edu.fisul.cstsi.pedidos_aulas.categorias.Categoria;
import br.edu.fisul.cstsi.pedidos_aulas.dependentes.Dependente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import br.edu.fisul.cstsi.pedidos_aulas.mensalidades.Mensalidade;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "socios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Socio {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cartao_socio;
    private String nome_socio;
    private String end_socio;
    private String tel_socio;
    private String email_socio;

    @OneToMany(mappedBy = "socio", fetch = FetchType.EAGER)
    private List<Dependente> dependentes = new ArrayList<>();

    @OneToMany(mappedBy = "socio", fetch = FetchType.LAZY)
    private List<Mensalidade> mensalidades = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria categoria;

    public Socio(Long id, Long cartao_socio, String nome_socio, String end_socio, String tel_socio, String email_socio) {
        this.id = id;
        this.cartao_socio = cartao_socio;
        this.nome_socio = nome_socio;
        this.end_socio = end_socio;
        this.tel_socio = tel_socio;
        this.email_socio = email_socio;
    }

    @Override
    public String toString() {
        return "\n Socio{" +
                "id=" + id +
                ", cartao_socio=" + cartao_socio +
                ", nome_socio='" + nome_socio + '\'' +
                ", end_socio='" + end_socio + '\'' +
                ", tel_socio='" + tel_socio + '\'' +
                ", email_socio='" + email_socio + '\'' +
                ", dependentes=" + dependentes +
                ", categoria=" + categoria +
                '}';
    }
}

