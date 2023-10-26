package br.edu.fisul.cstsi.pedidos_aulas.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Fornecedor")
@Table(name = "fornecedores")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToMany(mappedBy = "fornecedores")
    private List<Produto> produtos;
}
