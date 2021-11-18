package pt.iade.garage4u.controlers;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

import pt.iade.garage4u.models.Exceptions.NotFoundException;
import pt.iade.garage4u.models.Exceptions.Response;
import pt.iade.garage4u.models.Estado_reserva;
import pt.iade.garage4u.models.repositories.Estado_reservaRepository;

@RestController
@RequestMapping(path = "/api/estado_reserva")
public class Estado_reservaController {

    private Logger logger = LoggerFactory.getLogger(Estado_reservaController.class);
    @Autowired
    private Estado_reservaRepository estado_reservaRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Estado_reserva> getEstado_reservas() {
        logger.info("Sending all Estado_reservas");
        return estado_reservaRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Estado_reserva getEstado_reserva(@PathVariable int id) {
        logger.info("Sending estado_reserva with id " + id);
        Optional<Estado_reserva> _estado_reserva = estado_reservaRepository.findById(id);
        if (_estado_reserva.isEmpty())
            throw new NotFoundException("" + id, "Estado_reserva", "id");
        else
            return _estado_reserva.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Estado_reserva saveEstado_reserva(@RequestBody Estado_reserva estado_reserva) {
        Estado_reserva savedEstado_reserva = estado_reservaRepository.save(estado_reserva);
        logger.info("Saving estado_reserva with id " + savedEstado_reserva.getEstadoReservaId());   //Ir ao model e ver o nome do ID
        return savedEstado_reserva;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteEstado_reserva(@PathVariable int id) {
        logger.info("Deleting estado_reserva with id " + id);
        // No verification to see if it exists
        estado_reservaRepository.deleteById(id);
        return new Response("Deleted estado_reserva with id " + id, null);
    }
}
