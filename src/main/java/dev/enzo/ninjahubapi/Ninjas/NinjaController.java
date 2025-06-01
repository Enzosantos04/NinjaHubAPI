package dev.enzo.ninjahubapi.Ninjas;

import org.springframework.web.bind.annotation.*;

//annotation que recebe requisicoes GET, POST, PUT e DELETE
@RestController
//annotation para mapear rotas e requisicoes HTTP
@RequestMapping


public class NinjaController {

    //annotation para que define uma rota GET - puxar informacoes
    //get pega as informacoes
    @GetMapping("/boasvindas") // passando uma rota para dentro da annotation
    public String boasVindas(){
        return "amor eu te amo";
    }

    //adicionar ninja
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja criado";
    }

    //mostrar ninja
    @GetMapping("/todos")
    public String mostrarNinjas(){
        return "Mostrar Ninja";
    }

    //mostrar ninja por id
    @GetMapping("/todosID")
    public String mostrarNinjasPorID(){
        return "Mostar Ninja por ID";
    }

    //atualizar ninja
    @PutMapping("/atualizarNinja")
    public String atualizarNinja(){
        return "atualizar ninja";
    }

    @DeleteMapping("/deletarID")
        public String deletarNinja(){
            return "ninja deletado por ID";
        }

    //mostrar todos os ninjas
    //atualizar dados dos ninjas
    //Deletar ninja

}
