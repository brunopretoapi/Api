package pt.iade.api.controlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.iade.api.models.Exceptions.NotFoundException;
import pt.iade.api.models.Exceptions.Response;
import pt.iade.api.models.tipo_acontecimento;
import pt.iade.api.models.repositories.Tipo_acontecimentoRepository;

import java.util.Optional;


@RestController
@RequestMapping(path = "/api/tipo_acontecimento")
public class tipo_acontecimentoController {

    private Logger logger = LoggerFactory.getLogger(tipo_acontecimentoController.class);
    @Autowired
    private Tipo_acontecimentoRepository tipo_acontecimentoRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<tipo_acontecimento> getTipo_acontecimentos() {
        logger.info("Sending all tipo_acontecimento");
        return tipo_acontecimentoRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public tipo_acontecimento getTipo_acontecimento(@PathVariable int id) {
        logger.info("Sending tipo_acontecimento with id " + id);
        Optional<tipo_acontecimento> _tipo_acontecimento = tipo_acontecimentoRepository.findById(id);
        if (!_tipo_acontecimento.isPresent())
            throw new NotFoundException("" + id, "Tipo_acontecimento", "id");
        else
            return _tipo_acontecimento.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public tipo_acontecimento saveTipo_acontecimento(@RequestBody tipo_acontecimento tipo_acontecimento) {
        pt.iade.api.models.tipo_acontecimento savedTipo_acontecimento = tipo_acontecimentoRepository.save(tipo_acontecimento);
        logger.info("Saving tipo_acontecimento with id " + savedTipo_acontecimento.getId());
        return savedTipo_acontecimento;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteTipo_acontecimento(@PathVariable int id) {
        logger.info("Deleting tipo_acontecimento with id " + id);
        // No verification to see if it exists
        tipo_acontecimentoRepository.deleteById(id);
        return new Response("Deleted tipo_acontecimento with id " + id, null);
    }
}
