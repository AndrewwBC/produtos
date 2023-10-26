package br.edu.fisul.cstsi.pedidos_aulas.model;


import jakarta.persistence.*;

@Entity
public class Dependente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cartao_dep;
    private String nome_dep;
    private String parentesco;
    private String email_dep;
    @ManyToOne
    private Socio socio;
    public Dependente() {}

    public Dependente(Long id, Long cartao_dep, String nome_dep, String parentesco, String email_dep) {
        this.id = id;
        this.cartao_dep = cartao_dep;
        this.nome_dep = nome_dep;
        this.parentesco = parentesco;
        this.email_dep = email_dep;
    }




}
