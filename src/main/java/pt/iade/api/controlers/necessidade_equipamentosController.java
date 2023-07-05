package pt.iade.api.controlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.iade.api.models.Exceptions.NotFoundException;
import pt.iade.api.models.Exceptions.Response;
import pt.iade.api.models.equipamentos;
import pt.iade.api.models.repositories.Necessidade_equipamentosRepository;

import java.util.Optional;


@RestController
@RequestMapping(path = "/api/necessidade_equipamentos")
public class necessidade_equipamentosController {

    private Logger logger = LoggerFactory.getLogger(necessidade_equipamentosController.class);
    @Autowired
    private Necessidade_equipamentosRepository necessidade_equipamentosRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Necessidade_equipamentos> getNecessidade_equipamentos() {
        logger.info("Sending all necessidade_equipamentos");
        return necessidade_equipamentosRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public equipamentos getNecessidade_equipamentos(@PathVariable int id) {
        logger.info("Sending necessidade_equipamentos with id " + id);
        Optional<equipamentos> _necessidade_equipamentos = necessidade_equipamentosRepository.findById(id);
        if (!_equipamentos.isPresent())
            throw new NotFoundException("" + id, "Necessidade_equipamentos", "id");
        else
            return _equipamentos.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public equipamentos saveEquipamentos(@RequestBody equipamentos equipamentos) {
        pt.iade.api.models.equipamentos savedEquipamentos = equipamentosRepository.save(equipamentos);
        logger.info("Saving equipamentos with id " + savedEquipamentos.getId());
        return savedEquipamentos;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteEquipamentos(@PathVariable int id) {
        logger.info("Deleting equipamentos with id " + id);
        // No verification to see if it exists
        equipamentosRepository.deleteById(id);
        return new Response("Deleted equipamentos with id " + id, null);
    }
}
