package pt.iade.garage4u.controlers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

import pt.iade.garage4u.models.Exceptions.NotFoundException;
import pt.iade.garage4u.models.Exceptions.Response;
import pt.iade.garage4u.models.Garagens;
import pt.iade.garage4u.models.repositories.GaragensRepository;

@RestController
@RequestMapping(path = "/api/garagens")
public class GaragensController {
    private Logger logger = LoggerFactory.getLogger(GaragensController.class);
    @Autowired
    private GaragensRepository garagensRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Garagens> getGaragens() {
        logger.info("Sending all garagens");
        return garagensRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Garagens getGaragens(@PathVariable int id) {
        logger.info("Sending garagens with id " + id);
        Optional<Garagens> _garagens = garagensRepository.findById(id);
        if (!_garagens.isPresent())
            throw new NotFoundException("" + id, "Garagens", "id");
        else
            return _garagens.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Garagens saveGaragens(@RequestBody Garagens garagens) {
        Garagens savedGaragens = garagensRepository.save(garagens);
        logger.info("Saving garagens with id " + savedGaragens.getGaragensId());
        return savedGaragens;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteGaragens(@PathVariable int id) {
        logger.info("Deleting garagens with id " + id);
        // No verification to see if it exists
        garagensRepository.deleteById(id);
        return new Response("Deleted garagens with id " + id, null);
    }

}
