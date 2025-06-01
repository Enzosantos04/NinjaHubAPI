package dev.enzo.ninjahubapi.Missoes;


import org.springframework.web.bind.annotation.*;


@RestController //recebe as requisicoes HTTPP
@RequestMapping("missoes")// mapeia as rotas das requisicoes, nesse caso o paramentro vai ser
//para acessar /missoes primeiro para depois acessar /missoes/criar.
public class MissoesController {

    //adicionar missao
    @PostMapping("/criar")
    public String criarMissoes(){
        return "criar missoes";
    }

    @PutMapping("/atualizar")
    public String atualizarMissoes(){
        return "atualizar missoes";
    }

    @GetMapping("/todas")
    public String mostrarMissoes(){
        return "todas as missoes";
    }

    @GetMapping("/todasID")
    public String mostrarMissoesID(){
        return "Mostrar missoes por id";
    }

    @DeleteMapping("/deletarID")
    public String deletarID(){
        return "deletar por ID";
    }



}