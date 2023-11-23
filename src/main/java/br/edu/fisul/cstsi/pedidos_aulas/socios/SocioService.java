package br.edu.fisul.cstsi.pedidos_aulas.socios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class SocioService {

    @Autowired
    private SocioRepository rep;

    public Socio getSocioById(Long id){
        Optional<Socio> socio = rep.findById(id);
        if(socio.isPresent()){
            return socio.get();
        }
        return null;
    }

    public List<Socio> listSocios(){
        return rep.findAll();
    }

    public Socio insertSocio(Socio socio){
        Assert.isNull(socio.getId(),"Não foi possível inserir o registro");
        return rep.save(socio);
    }


    public String getNameById(Long id) {
        Optional<Socio> optional = rep.findById(id);

        return optional.map(Socio::getNome_socio).orElse(null);
    }

    public void deleteSocio(Socio socio) {
        rep.delete(socio);
    }

}
