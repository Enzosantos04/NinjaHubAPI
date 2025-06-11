package dev.enzo.ninjahubapi.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {
    public MissoesModel map(MissoesDTO missoesDTO){
        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(missoesDTO.getId());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());
        missoesModel.setNomeMissao(missoesDTO.getNomeMissao());
        return missoesModel;
    }
    public MissoesDTO map(MissoesModel missoesModel){
        MissoesDTO missoesDTO =  new MissoesDTO();
        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNomeMissao(missoesModel.getNomeMissao());
        missoesDTO.setDificuldade(missoesModel.getDificuldade());
        return missoesDTO;
    }
}


