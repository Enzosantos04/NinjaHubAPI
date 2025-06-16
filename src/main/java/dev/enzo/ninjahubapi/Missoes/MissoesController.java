package dev.enzo.ninjahubapi.Missoes;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController //recebe as requisicoes HTTPP
@RequestMapping("missoes")// mapeia as rotas das requisicoes, nesse caso o paramentro vai ser
//para acessar /missoes primeiro para depois acessar /missoes/criar.
public class MissoesController {
    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //adicionar missao
    @PostMapping("/criar")
    public ResponseEntity<String> criarMissoes(@RequestBody MissoesDTO missoesDTO){
        MissoesDTO missaoDTO = missoesService.criarMissoes(missoesDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja Criado com sucesso " + missaoDTO.getNomeMissao() + " (ID) " + missaoDTO.getId());

    }

    @PutMapping("/atualizarMissao/{id}")
    public MissoesDTO atualizarMissoes(@PathVariable Long id, @RequestBody MissoesDTO missaoAtulizada){
        return missoesService.atualizarMissaoPorId(id, missaoAtulizada);
    }

    @GetMapping("/listar")
    public List<MissoesDTO> mostrarMissoes(){
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesDTO mostrarMissoesPorId(@PathVariable Long id){
        return missoesService.listarMissoesPorId(id);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarId(@PathVariable Long id){
        missoesService.deletarMissoesPorId(id);
    }



}