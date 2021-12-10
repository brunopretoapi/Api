package pt.iade.garage4u.controlers;



import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.iade.garage4u.models.Dispositivo;
import pt.iade.garage4u.models.Exceptions.NotFoundException;
import pt.iade.garage4u.models.Exceptions.Response;
import pt.iade.garage4u.models.repositories.DispositivoRepository;



@RestController
@RequestMapping(path = "/api/dispositivo")
public class DispositivoController {


    private Logger logger = LoggerFactory.getLogger(DispositivoController.class);
    @Autowired
    private DispositivoRepository dispositivoRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Dispositivo> getDispositivo() {
        logger.info("Sending all estados");
        return dispositivoRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Dispositivo getDispositivo(@PathVariable int id) {
        logger.info("Sending estado with id " + id);
        Optional<Dispositivo> _dispositivo = dispositivoRepository.findById(id);
        if (!_dispositivo.isPresent())
            throw new NotFoundException("" + id, "Dispositivo", "id");
        else
            return _dispositivo.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Dispositivo saveDispositivo(@RequestBody Dispositivo dispositivo) {
        Dispositivo savedEstado = dispositivoRepository.save(dispositivo);
        logger.info("Saving dispositivo with id " + savedEstado.getIdDispositivo());
        return savedEstado;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteDispositivo(@PathVariable int id) {
        logger.info("Deleting estado with id " + id);
        // No verification to see if it exists
        dispositivoRepository.deleteById(id);
        return new Response("Deleted dispositivo with id " + id, null);
    }
}
