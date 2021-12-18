package pt.iade.garage4u.controlers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

import pt.iade.garage4u.models.Exceptions.NotFoundException;
import pt.iade.garage4u.models.Exceptions.Response;
import pt.iade.garage4u.models.Caracteristicas;
import pt.iade.garage4u.models.repositories.CaracteristicasRepository;


@RestController
@RequestMapping(path = "/api/caracteristicas")
public class CaracteristicasController {

    private Logger logger = LoggerFactory.getLogger(CaracteristicasController.class);
    @Autowired
    private CaracteristicasRepository caracteristicasRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Caracteristicas> getCaracteristicass() {
        logger.info("Sending all caracteristicas");
        return caracteristicasRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Caracteristicas getCaracteristicas(@PathVariable int id) {
        logger.info("Sending caracteristicas with id " + id);
        Optional<Caracteristicas> _caracteristicas = caracteristicasRepository.findById(id);
        if (!_caracteristicas.isPresent())
            throw new NotFoundException("" + id, "Caracteristicas", "id");
        else
            return _caracteristicas.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Caracteristicas saveCaracteristicas(@RequestBody Caracteristicas caracteristicas) {
        Caracteristicas savedCaracteristicas = caracteristicasRepository.save(caracteristicas);
        logger.info("Saving caracteristicas with id " + savedCaracteristicas.getCaracteristicasId());
        return savedCaracteristicas;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteCaracteristicas(@PathVariable int id) {
        logger.info("Deleting caracteristicas with id " + id);
        // No verification to see if it exists
        caracteristicasRepository.deleteById(id);
        return new Response("Deleted caracteristicas with id " + id, null);
    }




}