package br.edu.fisul.cstsi.pedidos_aulas.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String desc_cat;
    @OneToMany(mappedBy = "categoria")
    private List<Socio> socio = new ArrayList<>();
}
