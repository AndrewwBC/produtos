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

    public List<Socio> getSocioByName(String nome) {
        List<Socio> optional = rep.findSociosByNome_socio(nome + "%");

        if(!optional.isEmpty()) {
            return optional;
        }
        return null;
    }

    public void deleteSocio(Socio socio) {
        rep.delete(socio);
    }


    public Socio update(Socio socio) {
        Assert.notNull(socio.getId(),"Não foi possível atualizar o registro");

        Optional<Socio> optional = rep.findById(socio.getId());

       if(optional.isPresent()) {
            Socio db = optional.get();

            db.setNome_socio(socio.getNome_socio());
            db.setCartao_socio(socio.getCartao_socio());
            db.setEmail_socio(socio.getEmail_socio());
            db.setTel_socio(socio.getTel_socio());
            db.setEnd_socio(socio.getEnd_socio());
            rep.save(db);
            return db;
       } else {
            return null;
       }
    }

}
