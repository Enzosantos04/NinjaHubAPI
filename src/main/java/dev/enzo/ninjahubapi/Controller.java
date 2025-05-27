package dev.enzo.ninjahubapi;

import org.springframework.web.bind.annotation.*;

//annotation que recebe requisicoes GET, POST, PUT e DELETE
@RestController
//annotation para mapear rotas e requisicoes HTTP
@RequestMapping


public class Controller {

    //annotation para que define uma rota GET - puxar informacoes
    //get pega as informacoes
    @GetMapping("/boasVindas") // passando uma rota para dentro da annotation
    public String boasVindas(){
        return "amor eu te amo";
    }

}
