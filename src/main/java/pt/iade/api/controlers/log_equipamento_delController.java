package pt.iade.api.controlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.iade.api.models.Exceptions.NotFoundException;
import pt.iade.api.models.Exceptions.Response;
import pt.iade.api.models.log_equipamento_del;
import pt.iade.api.models.repositories.Log_equipamento_delRepository;

import java.util.Optional;


@RestController
@RequestMapping(path = "/api/log_equipamento_del")
public class log_equipamento_delController {

    private Logger logger = LoggerFactory.getLogger(log_equipamento_delController.class);
    @Autowired
    private Log_equipamento_delRepository Log_equipamento_delRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<log_equipamento_del> getlog_equipamento_del() {
        logger.info("Sending all equipamentos");
        return Log_equipamento_delRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public log_equipamento_del getEquipamentos(@PathVariable int id) {
        logger.info("Sending equipamentos with id " + id);
        Optional<log_equipamento_del> _log_equipamento_del = Log_equipamento_delRepository.findById(id);
        if (!_log_equipamento_del.isPresent())
            throw new NotFoundException("" + id, "Equipamentos", "id");
        else
            return _log_equipamento_del.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public log_equipamento_del savelog_equipamento_del(@RequestBody log_equipamento_del log_equipamento_del) {
        pt.iade.api.models.equipamentos savedlog_equipamento_del = Log_equipamento_delRepository.save(log_equipamento_del);
        logger.info("Saving log_equipamento_del with id " + savedlog_equipamento_del.getId());
        return savedlog_equipamento_del;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deletelog_equipamento_del(@PathVariable int id) {
        logger.info("Deleting log_equipamento_del with id " + id);
        // No verification to see if it exists
        Log_equipamento_delRepository.deleteById(id);
        return new Response("Deleted log_equipamento_del with id " + id, null);
    }
}
