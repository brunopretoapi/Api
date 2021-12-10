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

    @GetMapping(path = "/exite/{nome:[.-z]+}/{pass:[0-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getexit_userBypass_nome(@PathVariable("nome") String nome,@PathVariable("pass") String pass) {
        logger.info("Sending bio from route nome: ,pass:" + nome +pass);
        return queryRepository.Exite_utilizador(nome,pass);
    }

    @GetMapping(path = "/banco/depositar/{utilizador:[A-z]+}/{num_card:[0-9]+}/{cvv:[0-9]+}/{quantidade_dinheiro:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getdepositar(@PathVariable("utilizador") String utilizador,@PathVariable("num_card") int num_card,@PathVariable("cvv") int cvv,@PathVariable("quantidade_dinheiro") int quantidade_dinheiro) {
        logger.info("Sending bio from route utilizador: ,num_card:,cvv:,quantidade_dinheiro:" + utilizador +num_card+cvv+quantidade_dinheiro);
        return queryRepository.deposita(utilizador ,num_card,cvv,quantidade_dinheiro);
    }

    @GetMapping(path = "/banco/levantar/{utilizador:[A-z]+}/{num_card:[0-9]+}/{cvv:[0-9]+}/{quantidade_dinheiro:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getlevantar(@PathVariable("utilizador") String utilizador,@PathVariable("num_card") int num_card,@PathVariable("cvv") int cvv,@PathVariable("quantidade_dinheiro") int quantidade_dinheiro) {
        logger.info("Sending bio from route utilizador: ,num_card:,cvv:,quantidade_dinheiro:" + utilizador +num_card+cvv+quantidade_dinheiro);
        return queryRepository.levanta(utilizador ,num_card,cvv,quantidade_dinheiro);
    }







}



