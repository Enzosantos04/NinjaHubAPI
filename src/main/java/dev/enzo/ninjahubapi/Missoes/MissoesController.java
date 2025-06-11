package dev.enzo.ninjahubapi.Missoes;


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
    public MissoesDTO criarMissoes(@RequestBody MissoesDTO missoesDTO){
        return missoesService.criarMissoes(missoesDTO);

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