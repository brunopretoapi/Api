package pt.iade.garage4u.controlers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

import pt.iade.garage4u.models.Exceptions.NotFoundException;
import pt.iade.garage4u.models.Exceptions.Response;
import pt.iade.garage4u.models.Res_gar;
import pt.iade.garage4u.models.repositories.Res_garRepository;


@RestController
@RequestMapping(path = "/api/res_gar")
public class Res_garController {

    private Logger logger = LoggerFactory.getLogger(Res_garController.class);
    @Autowired
    private Res_garRepository res_garRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Res_gar> getRes_gars() {
        logger.info("Sending all res_gar");
        return res_garRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Res_gar getRes_gar(@PathVariable int id) {
        logger.info("Sending res_gar with id " + id);
        Optional<Res_gar> _res_gar = res_garRepository.findById(id);
        if (!_res_gar.isPresent())
            throw new NotFoundException("" + id, "Res_gar", "id");
        else
            return _res_gar.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Res_gar saveRes_gar(@RequestBody Res_gar res_gar) {
        Res_gar savedRes_gar = res_garRepository.save(res_gar);
        logger.info("Saving res_gar with id " + savedRes_gar.getRes_garId());
        return savedRes_gar;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteRes_gar(@PathVariable int id) {
        logger.info("Deleting res_gar with id " + id);
        // No verification to see if it exists
        res_garRepository.deleteById(id);
        return new Response("Deleted res_gar with id " + id, null);
    }




}
