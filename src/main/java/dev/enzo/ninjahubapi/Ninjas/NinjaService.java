package dev.enzo.ninjahubapi.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // annotation para indicar uma camada de service
public class NinjaService {

    //cria uma instacia do repository
    //injetando como dependencia
    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }
    //listar todos os meus ninjas


    // metodo do tipo List, recebendo NinjaModel
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }



}
