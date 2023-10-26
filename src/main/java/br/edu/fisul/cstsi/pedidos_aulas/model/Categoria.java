package br.edu.fisul.cstsi.pedidos_aulas.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String desc_cat;
    @OneToMany
    private List<Socio> socio = new ArrayList<>();
}
