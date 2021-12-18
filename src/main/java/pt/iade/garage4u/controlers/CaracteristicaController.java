package pt.iade.garage4u.controlers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.iade.garage4u.models.Caracteristica;
import pt.iade.garage4u.models.Exceptions.NotFoundException;
import pt.iade.garage4u.models.Exceptions.Response;
import pt.iade.garage4u.models.repositories.CaracteristicaRepository;


@RestController
@RequestMapping(path = "/api/caracteristica")

public class CaracteristicaController {
    private Logger logger = LoggerFactory.getLogger(CaracteristicaController.class);
    @Autowired
    private CaracteristicaRepository caracteristicaRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Caracteristica> getCaracteristica() {
        logger.info("Sending all estados");
        return caracteristicaRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Caracteristica getCaracteristica(@PathVariable int id) {
        logger.info("Sending estado with id " + id);
        Optional<Caracteristica> _caracteristica = caracteristicaRepository.findById(id);
        if (!_caracteristica.isPresent())
            throw new NotFoundException("" + id, "Caracteristica", "id");
        else
            return _caracteristica.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Caracteristica saveCaracteristica(@RequestBody Caracteristica caracteristica) {
        Caracteristica savedEstado = caracteristicaRepository.save(caracteristica);
        logger.info("Saving caracteristica with id " + savedEstado.getIdCaracteristica());
        return savedEstado;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteCaracteristica(@PathVariable int id) {
        logger.info("Deleting estado with id " + id);
        // No verification to see if it exists
        caracteristicaRepository.deleteById(id);
        return new Response("Deleted caracteristica with id " + id, null);
    }

}
