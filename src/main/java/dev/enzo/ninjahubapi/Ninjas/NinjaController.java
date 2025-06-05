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
    public NinjaModel criarNinja(@RequestBody NinjaModel ninjaModel){
        return ninjaService.criarNinja(ninjaModel);
    }

    //mostrar ninja
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    //mostrar ninja por id
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjaPorId(@PathVariable Long id){
        return ninjaService.listarNinjasPorId(id);
    }

    //atualizar ninja
    @PutMapping("/atualizarNinja/{id}")
    public NinjaModel atualizarNinja(@PathVariable Long id, @RequestBody NinjaModel ninjaAtualizado){
       return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    //Deletar Ninja por id
    @DeleteMapping("/deletar/{id}")
        public void deletarNinja(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
        }


}
