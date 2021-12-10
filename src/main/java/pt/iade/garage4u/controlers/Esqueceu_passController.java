package pt.iade.garage4u.controlers;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

import pt.iade.garage4u.models.Esqueceu_pass;
import pt.iade.garage4u.models.Exceptions.NotFoundException;
import pt.iade.garage4u.models.Exceptions.Response;
import pt.iade.garage4u.models.repositories.Esqueceu_passRepository;


@RestController
@RequestMapping(path = "/api/esqueceu_pass")
public class Esqueceu_passController {


    private Logger logger = LoggerFactory.getLogger(Esqueceu_passController.class);
    @Autowired
    private Esqueceu_passRepository esqueceu_passRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Esqueceu_pass> getEsqueceu_pass() {
        logger.info("Sending all Estado_reservas");
        return esqueceu_passRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Esqueceu_pass getEsqueceu_pass(@PathVariable int id) {
        logger.info("Sending esqueceu_pass with id " + id);
        Optional<Esqueceu_pass> _esqueceu_pass = esqueceu_passRepository.findById(id);
        if (!_esqueceu_pass.isPresent())
            throw new NotFoundException("" + id, "Esqueceu_pass", "id");
        else
            return _esqueceu_pass.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Esqueceu_pass saveEsqueceu_pass(@RequestBody Esqueceu_pass esqueceu_pass) {
        Esqueceu_pass savedEsqueceu_pass = esqueceu_passRepository.save(esqueceu_pass);
        logger.info("Saving esqueceu_pass with id " + savedEsqueceu_pass.getIdEsqueceu());   //Ir ao model e ver o nome do ID
        return savedEsqueceu_pass;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteEsqueceu_pass(@PathVariable int id) {
        logger.info("Deleting esqueceu_pass with id " + id);
        // No verification to see if it exists
        esqueceu_passRepository.deleteById(id);
        return new Response("Deleted esqueceu_pass with id " + id, null);
    }
}
