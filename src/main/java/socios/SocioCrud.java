package socios;

import categorias.CategoriaCrud;
import dependentes.DependenteCrud;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mensalidades.MensalidadeCrud;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "socios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocioCrud {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cartao_socio;
    private String nome_socio;
    private String end_socio;
    private String tel_socio;
    private String email_socio;

    @OneToMany(mappedBy = "socio")
    private List<DependenteCrud> dependentes = new ArrayList<>();

    @OneToMany(mappedBy = "socio")
    private List<MensalidadeCrud> mensalidades = new ArrayList<>();

    @ManyToOne
    private CategoriaCrud categoria;

    public SocioCrud(Long id, Long cartao_socio, String nome_socio, String end_socio, String tel_socio, String email_socio) {
        this.id = id;
        this.cartao_socio = cartao_socio;
        this.nome_socio = nome_socio;
        this.end_socio = end_socio;
        this.tel_socio = tel_socio;
        this.email_socio = email_socio;
    }

}

