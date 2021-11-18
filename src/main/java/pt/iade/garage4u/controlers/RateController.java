package pt.iade.garage4u.controlers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

import pt.iade.garage4u.models.Exceptions.NotFoundException;
import pt.iade.garage4u.models.Exceptions.Response;
import pt.iade.garage4u.models.Rate;
import pt.iade.garage4u.models.repositories.RateRepository;

@RestController
@RequestMapping(path = "/api/rate")
public class RateController {

    private Logger logger = LoggerFactory.getLogger(RateController.class);
    @Autowired
    private RateRepository rateRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Rate> getRates() {
        logger.info("Sending all rates");
        return rateRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Rate getRate(@PathVariable int id) {
        logger.info("Sending rate with id " + id);
        Optional<Rate> _rate = rateRepository.findById(id);
        if (!_rate.isPresent())
            throw new NotFoundException("" + id, "Rate", "id");
        else
            return _rate.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Rate saveRate(@RequestBody Rate rate) {
        Rate savedRate = rateRepository.save(rate);
        logger.info("Saving rate with id " + savedRate.getRateId());   //Ir ao model e ver o nome do ID
        return savedRate;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteRate(@PathVariable int id) {
        logger.info("Deleting rate with id " + id);
        // No verification to see if it exists
        rateRepository.deleteById(id);
        return new Response("Deleted rate with id " + id, null);
    }
}
