package dev.enzo.ninjahubapi.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

//annotation que recebe requisicoes GET, POST, PUT e DELETE
@RestController
//annotation para mapear rotas e requisicoes HTTP
@RequestMapping("/ninjas") // nesse caso o paramentro vai ser
//para acessar /ninjas primeiro para depois acessar /ninjas/criar.

public class NinjaController {
private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    //annotation para que define uma rota GET - puxar informacoes
    //get pega as informacoes
    @GetMapping("/boasvindas") // passando uma rota para dentro da annotation
    public String boasVindas(){
        return "boas vindas";
    }

    //adicionar ninja
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja criado";
    }

    //mostrar ninja
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    //mostrar ninja por id
    @GetMapping("/listarID")
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
