package dev.enzo.ninjahubapi.Ninjas;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service // annotation para indicar uma camada de service
public class NinjaService {

    //cria uma instacia do repository
    //injetando como dependencia
    private NinjaRepository ninjaRepository;
    private  NinjaMapper ninjaMapper;


    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //listar todos os meus ninjas
    //metodo do tipo List passando ninjaModel
    public List<NinjaDTO> listarNinjas(){
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream().map(ninjaMapper::map).collect(Collectors.toList());
    }

    //listar ninjas por id
    public NinjaDTO listarNinjasPorId(Long id) {
        //usando optional pq o ninja pode existir ou nao.
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        //orElse() significa vai me mandar um ninja ou retorna null
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
    }
    //Inserir ninja no banco de dados
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
        ninjaModel = ninjaRepository.save(ninjaModel);
        return ninjaMapper.map(ninjaModel);


    }

    //deletar Ninja.
    // tem q ser metodo void pois nao 'e necessario retornar nada para o usuario.
    //sendo assim, nao 'e necessario usar return ou passar NinjaModel
    public void  deletarNinjaPorId(Long id){
         ninjaRepository.deleteById(id);
    }

        //Atualizar Ninja
        //necessario passar como paramentro o id e o model
        public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO){
          Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
          if(ninjaExistente.isPresent()){
              NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
              ninjaAtualizado.setId(id);
              NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
              return ninjaMapper.map(ninjaSalvo);
          }
          return null;
        }





}
