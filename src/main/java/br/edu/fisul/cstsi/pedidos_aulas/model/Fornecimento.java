package br.edu.fisul.cstsi.pedidos_aulas.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Fornecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private BigDecimal valor;
    @OneToOne
    private Produto produto;
    @OneToOne
    private Fornecedor fornecedor;

}
