package pt.iade.garage4u.controlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.iade.garage4u.models.Utilizador;
import pt.iade.garage4u.repository.QueryRepository;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/querys")
public class QuerysController {

    private final Logger logger = LoggerFactory.getLogger(QuerysController.class);

    @Autowired
    private QueryRepository queryRepository;

    @GetMapping(path = "/teste/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Utilizador> getteste(@PathVariable int id) {
        logger.info("Sending bio from route id:" + id);
        return queryRepository.findByUtilizadorId(id);
    }

    @GetMapping(path = "/teste3/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getteste1(@PathVariable int id) {
        logger.info("Sending bio from route id:" + id);
        return queryRepository.teste3(id);
    }



    @GetMapping(path = "/teste2/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Utilizador> getexit_userBypass_nome2() {
        logger.info("Sending bio from route nome::");
        return queryRepository.teste2();
    }

    @GetMapping(path = "/exite/{nome:[0-z]+}/{pass:[0-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getexit_userBypass_nome(@PathVariable("nome") String nome,@PathVariable("pass") String pass) {
        logger.info("Sending bio from route nome: ,pass:" + nome +pass);
        return queryRepository.Exite_utilizador(nome,pass);
    }

}



