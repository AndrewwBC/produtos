package br.edu.fisul.cstsi.pedidos_aulas.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ManyToAny;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Produto")
@Table(name = "produtos")
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer estoque;
    private BigDecimal valor;
    @ManyToMany
    private List<Fornecedor> fornecedores = new ArrayList<>();
}
