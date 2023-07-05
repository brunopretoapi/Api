package pt.iade.api.controlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.iade.api.models.Exceptions.NotFoundException;
import pt.iade.api.models.Exceptions.Response;
import pt.iade.api.models.equipamento_acontecimentos;
import pt.iade.api.models.repositories.Equipamento_acontecimentosRepository;

import java.util.Optional;


@RestController
@RequestMapping(path = "/api/equipamento_acontecimentos")
public class equipamento_acontecimentosController {

    private Logger logger = LoggerFactory.getLogger(equipamento_acontecimentosController.class);
    @Autowired
    private Equipamento_acontecimentosRepository equipamento_acontecimentosRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<equipamento_acontecimentos> getEquipamento_acontecimentoss() {
        logger.info("Sending all equipamento_acontecimentos");
        return equipamento_acontecimentosRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public equipamento_acontecimentos getEquipamento_acontecimentos(@PathVariable int id) {
        logger.info("Sending equipamento_acontecimentos with id " + id);
        Optional<equipamento_acontecimentos> _equipamento_acontecimentos = equipamento_acontecimentosRepository.findById(id);
        if (!_equipamento_acontecimentos.isPresent())
            throw new NotFoundException("" + id, "Equipamento_acontecimentos", "id");
        else
            return _equipamento_acontecimentos.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public equipamento_acontecimentos saveEquipamento_acontecimentos(@RequestBody equipamento_acontecimentos equipamento_acontecimentos) {
        pt.iade.api.models.equipamento_acontecimentos savedEquipamento_acontecimentos = equipamento_acontecimentosRepository.save(equipamento_acontecimentos);
        logger.info("Saving equipamento_acontecimentos with id " + savedEquipamento_acontecimentos.getId());
        return savedEquipamento_acontecimentos;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteEquipamento_acontecimentos(@PathVariable int id) {
        logger.info("Deleting equipamento_acontecimentos with id " + id);
        // No verification to see if it exists
        equipamento_acontecimentosRepository.deleteById(id);
        return new Response("Deleted equipamento_acontecimentos with id " + id, null);
    }
}
