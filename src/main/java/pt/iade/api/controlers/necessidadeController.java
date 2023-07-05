package pt.iade.api.controlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.iade.api.models.Exceptions.NotFoundException;
import pt.iade.api.models.Exceptions.Response;
import pt.iade.api.models.necessidade;
import pt.iade.api.models.repositories.NecessidadeRepository;

import java.util.Optional;


@RestController
@RequestMapping(path = "/api/necessidade")
public class necessidadeController {

    private Logger logger = LoggerFactory.getLogger(necessidadeController.class);
    @Autowired
    private NecessidadeRepository necessidadeRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<necessidade> getNecessidades() {
        logger.info("Sending all necessidade");
        return necessidadeRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public necessidade getNecessidade(@PathVariable int id) {
        logger.info("Sending necessidade with id " + id);
        Optional<necessidade> _necessidade = necessidadeRepository.findById(id);
        if (!_necessidade.isPresent())
            throw new NotFoundException("" + id, "Necessidade", "id");
        else
            return _necessidade.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public necessidade saveNecessidade(@RequestBody necessidade necessidade) {
        pt.iade.api.models.necessidade savedNecessidade = necessidadeRepository.save(necessidade);
        logger.info("Saving necessidade with id " + savedNecessidade.getId());
        return savedNecessidade;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteNecessidade(@PathVariable int id) {
        logger.info("Deleting necessidade with id " + id);
        // No verification to see if it exists
        necessidadeRepository.deleteById(id);
        return new Response("Deleted necessidade with id " + id, null);
    }
}
