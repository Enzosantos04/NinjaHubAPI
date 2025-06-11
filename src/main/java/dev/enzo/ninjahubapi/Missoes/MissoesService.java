package dev.enzo.ninjahubapi.Missoes;


import dev.enzo.ninjahubapi.Ninjas.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {
    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;

    }

    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream().map(missoesMapper::map).collect(Collectors.toList());

    }

    public MissoesDTO listarMissoesPorId(Long id){
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.map(missoesMapper::map).orElse(null);
    }

    public MissoesDTO criarMissoes(MissoesDTO missoesDTO){
        MissoesModel missoesModel = missoesMapper.map(missoesDTO);
        missoesModel = missoesRepository.save(missoesModel);
        return missoesMapper.map(missoesModel);
    }

    public void deletarMissoesPorId(Long id){
        missoesRepository.deleteById(id);
    }

    public MissoesDTO atualizarMissaoPorId(Long id, MissoesDTO missoesDTO){
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
        if(missaoExistente.isPresent()){
            MissoesModel missaoAtualizada = missoesMapper.map(missoesDTO);
            missaoAtualizada.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missaoAtualizada);
            return missoesMapper.map(missaoSalva);
        }
        return null;
    }
}
