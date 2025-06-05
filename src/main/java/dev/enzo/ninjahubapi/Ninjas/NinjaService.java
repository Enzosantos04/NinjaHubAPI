package dev.enzo.ninjahubapi.Ninjas;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // annotation para indicar uma camada de service
public class NinjaService {

    //cria uma instacia do repository
    //injetando como dependencia
    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }


    //listar todos os meus ninjas
    //metodo do tipo List passando ninjaModel
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    //listar ninjas por id
    public NinjaModel listarNinjasPorId(Long id){
        //usando optional pq o ninja pode existir ou nao.
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        //orElse() significa vai me mandar um ninja ou retorna null
        return ninjaPorId.orElse(null);
    }

    //Inserir ninja no banco de dados
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);

    }

    //deletar Ninja.
    // tem q ser metodo void pois nao 'e necessario retornar nada para o usuario.
    //sendo assim, nao 'e necessario usar return ou passar NinjaModel
    public void  deletarNinjaPorId(Long id){
         ninjaRepository.deleteById(id);
    }

        //Atualizar Ninja
        //necessario passar como paramentro o id e o model
        public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado){
            if(ninjaRepository.existsById(id)){
                ninjaAtualizado.setId(id);
                return ninjaRepository.save(ninjaAtualizado);
            }
            return null;
        }





}
