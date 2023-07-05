package pt.iade.api.controlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.iade.api.models.Exceptions.NotFoundException;
import pt.iade.api.models.Exceptions.Response;
import pt.iade.api.models.necessidade_equipamentos;
import pt.iade.api.models.repositories.Necessidade_equipamentosRepository;

import java.util.Optional;


@RestController
@RequestMapping(path = "/api/necessidade_equipamentos")
public class necessidade_equipamentosController {

    private Logger logger = LoggerFactory.getLogger(necessidade_equipamentosController.class);
    @Autowired
    private Necessidade_equipamentosRepository necessidade_equipamentosRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<necessidade_equipamentos> getNecessidade_equipamentoss() {
        logger.info("Sending all necessidade_equipamentos");
        return necessidade_equipamentosRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public necessidade_equipamentos getNecessidade_equipamentos(@PathVariable int id) {
        logger.info("Sending necessidade_equipamentos with id " + id);
        Optional<necessidade_equipamentos> _necessidade_equipamentos = necessidade_equipamentosRepository.findById(id);
        if (!_necessidade_equipamentos.isPresent())
            throw new NotFoundException("" + id, "Necessidade_equipamentos", "id");
        else
            return _necessidade_equipamentos.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public necessidade_equipamentos saveNecessidade_equipamentos(@RequestBody necessidade_equipamentos necessidade_equipamentos) {
        pt.iade.api.models.necessidade_equipamentos savedNecessidade_equipamentos = necessidade_equipamentosRepository.save(necessidade_equipamentos);
        logger.info("Saving necessidade_equipamentos with id " + savedNecessidade_equipamentos.getId());
        return savedNecessidade_equipamentos;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteNecessidade_equipamentos(@PathVariable int id) {
        logger.info("Deleting necessidade_equipamentos with id " + id);
        // No verification to see if it exists
        necessidade_equipamentosRepository.deleteById(id);
        return new Response("Deleted necessidade_equipamentos with id " + id, null);
    }
}
