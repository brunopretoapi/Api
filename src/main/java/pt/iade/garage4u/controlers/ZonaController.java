package pt.iade.garage4u.controlers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

import pt.iade.garage4u.models.Exceptions.NotFoundException;
import pt.iade.garage4u.models.Exceptions.Response;
import pt.iade.garage4u.models.Zona;
import pt.iade.garage4u.models.repositories.ZonaRepository;

@RestController
@RequestMapping(path = "/api/zona")
public class ZonaController {

    private Logger logger = LoggerFactory.getLogger(ZonaController.class);
    @Autowired
    private ZonaRepository zonaRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Zona> getZonas() {
        logger.info("Sending all zonas");
        return zonaRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Zona getZona(@PathVariable int id) {
        logger.info("Sending zona with id " + id);
        Optional<Zona> _zona = zonaRepository.findById(id);
        if (!_zona.isPresent())
            throw new NotFoundException("" + id, "Zona", "id");
        else
            return _zona.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Zona saveZona(@RequestBody Zona zona) {
        Zona savedZona = zonaRepository.save(zona);
        logger.info("Saving zona with id " + savedZona.getIdZona());   //Ir ao model e ver o nome do ID
        return savedZona;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteZona(@PathVariable int id) {
        logger.info("Deleting zona with id " + id);
        // No verification to see if it exists
        zonaRepository.deleteById(id);
        return new Response("Deleted zona with id " + id, null);
    }

}
