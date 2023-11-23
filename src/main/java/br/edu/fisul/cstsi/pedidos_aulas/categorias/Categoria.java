package br.edu.fisul.cstsi.pedidos_aulas.categorias;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import br.edu.fisul.cstsi.pedidos_aulas.socios.Socio;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorias")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String desc_cat;

    @OneToMany(mappedBy = "categoria")
    private List<Socio> socio = new ArrayList<>();

}
