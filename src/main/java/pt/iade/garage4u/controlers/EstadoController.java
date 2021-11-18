package pt.iade.garage4u.controlers;



import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

import pt.iade.garage4u.models.Exceptions.NotFoundException;
import pt.iade.garage4u.models.Exceptions.Response;
import pt.iade.garage4u.models.Estado;
import pt.iade.garage4u.models.repositories.EstadoRepository;

@RestController
@RequestMapping(path = "/api/estado")
public class EstadoController {

    private Logger logger = LoggerFactory.getLogger(EstadoController.class);
    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Estado> getEstados() {
        logger.info("Sending all estados");
        return estadoRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Estado getEstado(@PathVariable int id) {
        logger.info("Sending estado with id " + id);
        Optional<Estado> _estado = estadoRepository.findById(id);
        if (!_estado.isPresent())
            throw new NotFoundException("" + id, "Estado", "id");
        else
            return _estado.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Estado saveEstado(@RequestBody Estado estado) {
        Estado savedEstado = estadoRepository.save(estado);
        logger.info("Saving estado with id " + savedEstado.getEstadoId());
        return savedEstado;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteEstado(@PathVariable int id) {
        logger.info("Deleting estado with id " + id);
        // No verification to see if it exists
        estadoRepository.deleteById(id);
        return new Response("Deleted estado with id " + id, null);
    }
}
