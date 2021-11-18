package pt.iade.garage4u.controlers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

import pt.iade.garage4u.models.Exceptions.NotFoundException;
import pt.iade.garage4u.models.Exceptions.Response;
import pt.iade.garage4u.models.Reserva;
import pt.iade.garage4u.models.repositories.ReservaRepository;

@RestController
@RequestMapping(path = "/api/reserva")
public class ReservaController {

    private Logger logger = LoggerFactory.getLogger(ReservaController.class);
    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Reserva> getReservas() {
        logger.info("Sending all reservas");
        return reservaRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reserva getReserva(@PathVariable int id) {
        logger.info("Sending reserva with id " + id);
        Optional<Reserva> _reserva = reservaRepository.findById(id);
        if (_reserva.isEmpty())
            throw new NotFoundException("" + id, "reserva", "id");
        else
            return _reserva.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reserva saveReserva(@RequestBody Reserva reserva) {
        Reserva savedReserva = reservaRepository.save(reserva);
        logger.info("Saving reserva with id " + savedReserva.getReservaID());   //Ir ao model e ver o nome do ID
        return savedReserva;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteReserva(@PathVariable int id) {
        logger.info("Deleting reserva with id " + id);
        // No verification to see if it exists
        reservaRepository.deleteById(id);
        return new Response("Deleted reserva with id " + id, null);
    }
}
