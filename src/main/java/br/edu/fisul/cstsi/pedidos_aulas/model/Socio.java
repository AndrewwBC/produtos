package br.edu.fisul.cstsi.pedidos_aulas.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "socios")
public class Socio {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cartao_socio;
    private String nome_socio;
    private String end_socio;
    private String tel_socio;
    private String email_socio;
    // pq deve ter um constructor vazio??
    @OneToMany(mappedBy = "socio")
    private List<Dependente> dependentes = new ArrayList<>();
    @OneToMany(mappedBy = "socio")
    private List<Mensalidade> mensalidades = new ArrayList<>();
    @ManyToOne
    private Categoria categoria;

    public Socio() {

    }
    public Socio(Long id, Long cartao_socio, String nome_socio, String end_socio, String tel_socio, String email_socio) {
        this.id = id;
        this.cartao_socio = cartao_socio;
        this.nome_socio = nome_socio;
        this.end_socio = end_socio;
        this.tel_socio = tel_socio;
        this.email_socio = email_socio;
    }

    public String consSocio(){
        return this.nome_socio;
    }

}

