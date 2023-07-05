package pt.iade.api.controlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.iade.api.models.Exceptions.NotFoundException;
import pt.iade.api.models.Exceptions.Response;
import pt.iade.api.models.marca;
import pt.iade.api.models.repositories.MarcaRepository;

import java.util.Optional;


@RestController
@RequestMapping(path = "/api/marca")
public class MarcaController {

    private Logger logger = LoggerFactory.getLogger(MarcaController.class);
    @Autowired
    private MarcaRepository marcaRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<marca> getMarcas() {
        logger.info("Sending all marca");
        return marcaRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public marca getMarca(@PathVariable int id) {
        logger.info("Sending marca with id " + id);
        Optional<marca> _marca = marcaRepository.findById(id);
        if (!_marca.isPresent())
            throw new NotFoundException("" + id, "Marca", "id");
        else
            return _marca.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public marca saveMarca(@RequestBody marca marca) {
        pt.iade.api.models.marca savedMarca = marcaRepository.save(marca);
        logger.info("Saving marca with id " + savedMarca.getId());
        return savedMarca;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteMarca(@PathVariable int id) {
        logger.info("Deleting marca with id " + id);
        // No verification to see if it exists
        marcaRepository.deleteById(id);
        return new Response("Deleted marca with id " + id, null);
    }
}
