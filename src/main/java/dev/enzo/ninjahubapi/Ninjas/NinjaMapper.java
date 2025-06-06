package dev.enzo.ninjahubapi.Ninjas;


import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {


    //mapeando meu ninjaModel e jogar os dados para o meu NinjaDTO
    //os Atributos (id,nome,email,imgURl,idade,missoes,rank)
    //mapeando de um model(entidade) para um DTO
    public NinjaModel map(NinjaDTO ninjaDTO){
    NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setImgUrl(ninjaDTO.getImgUrl());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setMissoes(ninjaDTO.getMissoes());
        ninjaModel.setRank(ninjaDTO.getRank());
        return ninjaModel;
    }


    //mapeando uma DTO para uma entidade
    public NinjaDTO map(NinjaModel ninjaModel){
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setImgUrl(ninjaModel.getImgUrl());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setMissoes(ninjaModel.getMissoes());
        ninjaDTO.setRank(ninjaModel.getRank());
        return ninjaDTO;
    }
}
