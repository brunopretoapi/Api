package pt.iade.garage4u.controlers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

import pt.iade.garage4u.models.Exceptions.NotFoundException;
import pt.iade.garage4u.models.Exceptions.Response;
import pt.iade.garage4u.models.Utilizador;
import pt.iade.garage4u.models.repositories.UtilizadorRepository;


@RestController
@RequestMapping(path = "/api/utilizador")
public class UtilizadorController {

    private Logger logger = LoggerFactory.getLogger(UtilizadorController.class);
    @Autowired
    private UtilizadorRepository utilizadorRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Utilizador> getUtilizadors() {
        logger.info("Sending all utilizador");
        return utilizadorRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Utilizador getUtilizador(@PathVariable int id) {
        logger.info("Sending utilizador with id " + id);
        Optional<Utilizador> _utilizador = utilizadorRepository.findById(id);
        if (!_utilizador.isPresent())
            throw new NotFoundException("" + id, "Utilizador", "id");
        else
            return _utilizador.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Utilizador saveUtilizador(@RequestBody Utilizador utilizador) {
        Utilizador savedUtilizador = utilizadorRepository.save(utilizador);
        logger.info("Saving utilizador with id " + savedUtilizador.getUtilizadorId());
        return savedUtilizador;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteUtilizador(@PathVariable int id) {
        logger.info("Deleting utilizador with id " + id);
        // No verification to see if it exists
        utilizadorRepository.deleteById(id);
        return new Response("Deleted utilizador with id " + id, null);
    }
}
