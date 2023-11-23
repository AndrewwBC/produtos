package br.edu.fisul.cstsi.pedidos_aulas.socios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SocioRepository extends JpaRepository<Socio, Long> {

}
