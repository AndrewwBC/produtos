package br.edu.fisul.cstsi.pedidos_aulas.mensalidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import br.edu.fisul.cstsi.pedidos_aulas.socios.Socio;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "mensalidades")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mensalidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data_mens;
    private BigDecimal valor_mens;
    private LocalDate data_pgto_mens;
    private BigDecimal juros_mens;
    private BigDecimal valor_pago;
    private  Boolean quit_mens;


    @ManyToOne
    private Socio socio;

    public BigDecimal consMens(){
        return this.valor_mens;
    }
    public BigDecimal calcJuros(){
        return this.juros_mens;
    }
    public void quitarMens(Boolean quitar) {
        this.quit_mens = true;
    }
}
