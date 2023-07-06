package pt.iade.api.controlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.iade.api.models.Exceptions.NotFoundException;
import pt.iade.api.models.Exceptions.Response;
import pt.iade.api.models.equipamentos;
import pt.iade.api.models.repositories.EquipamentosRepository;

import pt.iade.api.models.log_equipamento_del;
import pt.iade.api.models.repositories.Log_equipamento_delRepository;

import java.util.Optional;


@RestController
@RequestMapping(path = "/api/equipamentos")
public class EquipamentosController {

    private Logger logger = LoggerFactory.getLogger(EquipamentosController.class);
    @Autowired
    private EquipamentosRepository equipamentosRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<equipamentos> getEquipamentoss() {
        logger.info("Sending all equipamentos");
        return equipamentosRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public equipamentos getEquipamentos(@PathVariable int id) {
        logger.info("Sending equipamentos with id " + id);
        Optional<equipamentos> _equipamentos = equipamentosRepository.findById(id);
        if (!_equipamentos.isPresent())
            throw new NotFoundException("" + id, "Equipamentos", "id");
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
