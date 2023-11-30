package br.edu.fisul.cstsi.pedidos_aulas.socios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SocioRepository extends JpaRepository<Socio, Long> {

    @Query(value = "SELECT socio FROM Socio socio where socio.nome_socio like ?1")
    List<Socio> findSociosByNome_socio(String nome);

}
