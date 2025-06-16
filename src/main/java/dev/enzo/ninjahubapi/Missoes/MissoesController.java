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
    public ResponseEntity<?> atualizarMissoes(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada){
       if(missoesService.listarMissoesPorId(id) != null){
           MissoesDTO missoesDTO = missoesService.atualizarMissaoPorId(id,missaoAtualizada);
           return ResponseEntity.ok(missoesDTO);
       }else{
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A missao de ID " + id + " nao encontrado");
       }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> mostrarMissoes(){
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> mostrarMissoesPorId(@PathVariable Long id){
        if(missoesService.listarMissoesPorId(id) != null){
            MissoesDTO missoesDTO = missoesService.listarMissoesPorId(id);
            return ResponseEntity.status(HttpStatus.FOUND).body(missoesDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A missao de ID "+ " nao foi encontrada");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarId(@PathVariable Long id){
        if(missoesService.listarMissoesPorId(id) != null){
            missoesService.deletarMissoesPorId(id);
            return ResponseEntity.ok("A missao de ID " + id + " deletado com sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A missao de ID " + id + " nao foi encontrada ");
        }
    }



}