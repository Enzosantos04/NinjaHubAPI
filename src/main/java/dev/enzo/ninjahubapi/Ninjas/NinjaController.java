package dev.enzo.ninjahubapi.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja Criado com sucesso " + ninjaDTO.getNome() + " (ID) " + ninjaDTO.getId());
    }

    //mostrar ninja
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>>listarNinjas(){
       List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //mostrar ninja por id
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjaPorId(@PathVariable Long id){
        if (ninjaService.listarNinjasPorId(id) != null){
            NinjaDTO ninjaDTO = ninjaService.listarNinjasPorId(id);
            return ResponseEntity.status(HttpStatus.FOUND).body(ninjaDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja de ID " + id + " nao encontrado.");

        }

    }

    //atualizar ninja
    @PutMapping("/atualizarNinja/{id}")
    public ResponseEntity<?> atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        if(ninjaService.listarNinjasPorId(id) != null){
            NinjaDTO ninjaDTO = ninjaService.atualizarNinja(id, ninjaAtualizado);
            return ResponseEntity.ok(ninjaDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja de ID " + id + " nao encontrado.");
        }

    }

    //Deletar Ninja por id
    @DeleteMapping("/deletar/{id}")
        public ResponseEntity<String> deletarNinja(@PathVariable Long id){
        if(ninjaService.listarNinjasPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja de ID " + id + " deletado com Sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O Ninja de ID " + id + " nao encontrado.");
        }
        }


}
