package pt.iade.api.controlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.iade.api.models.Exceptions.NotFoundException;
import pt.iade.api.models.Exceptions.Response;
import pt.iade.api.models.tipo;
import pt.iade.api.models.repositories.TipoRepository;

import java.util.Optional;


@RestController
@RequestMapping(path = "/api/tipo")
public class TipoController {

    private Logger logger = LoggerFactory.getLogger(TipoController.class);
    @Autowired
    private TipoRepository tipoRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<tipo> getTipos() {
        logger.info("Sending all tipo");
        return tipoRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public tipo getTipo(@PathVariable int id) {
        logger.info("Sending tipo with id " + id);
        Optional<tipo> _tipo = tipoRepository.findById(id);
        if (!_tipo.isPresent())
            throw new NotFoundException("" + id, "Tipo", "id");
        else
            return _tipo.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public tipo saveTipo(@RequestBody tipo tipo) {
        pt.iade.api.models.tipo savedTipo = tipoRepository.save(tipo);
        logger.info("Saving tipo with id " + savedTipo.getId());
        return savedTipo;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteTipo(@PathVariable int id) {
        logger.info("Deleting tipo with id " + id);
        // No verification to see if it exists
        tipoRepository.deleteById(id);
        return new Response("Deleted tipo with id " + id, null);
    }
}
