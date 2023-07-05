package pt.iade.api.controlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.iade.api.models.Exceptions.NotFoundException;
import pt.iade.api.models.Exceptions.Response;
import pt.iade.api.models.acontecimentos;
import pt.iade.api.models.repositories.AcontecimentosRepository;

import java.util.Optional;


@RestController
@RequestMapping(path = "/api/acontecimentos")
public class acontecimentosController {

    private Logger logger = LoggerFactory.getLogger(acontecimentosController.class);
    @Autowired
    private AcontecimentosRepository acontecimentosRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<acontecimentos> getAcontecimentoss() {
        logger.info("Sending all acontecimentos");
        return acontecimentosRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public acontecimentos getAcontecimentos(@PathVariable int id) {
        logger.info("Sending acontecimentos with id " + id);
        Optional<acontecimentos> _acontecimentos = acontecimentosRepository.findById(id);
        if (!_acontecimentos.isPresent())
            throw new NotFoundException("" + id, "Acontecimentos", "id");
        else
            return _acontecimentos.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public acontecimentos saveAcontecimentos(@RequestBody acontecimentos acontecimentos) {
        pt.iade.api.models.acontecimentos savedAcontecimentos = acontecimentosRepository.save(acontecimentos);
        logger.info("Saving acontecimentos with id " + savedAcontecimentos.getId());
        return savedAcontecimentos;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteAcontecimentos(@PathVariable int id) {
        logger.info("Deleting acontecimentos with id " + id);
        // No verification to see if it exists
        acontecimentosRepository.deleteById(id);
        return new Response("Deleted acontecimentos with id " + id, null);
    }
}
