package pt.iade.api.controlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.iade.api.repository.QueryRepository;

@RestController
@RequestMapping(path = "/api/query")
public class QuerysController {

    private final Logger logger = LoggerFactory.getLogger(QuerysController.class);

    @Autowired
    private QueryRepository queryRepository;


    @GetMapping(path = "/marca/{marca:[.-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getequipamentoBymarca(@PathVariable String marca) {
        logger.info("Sending bio from equipamento marca" + marca);
        return queryRepository.equipamentobymarca(marca);
    }
    @GetMapping(path = "/tipo/{tipo:[.-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getequipamentoBytipo(@PathVariable("tipo") String tipo) {
        logger.info("Sending bio from equipamento tipo" + tipo);
        return queryRepository.equipamentobytipo(tipo);
    }
    @GetMapping(path = "/nome/{nome:[.-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getequipamentoBynome(@PathVariable("nome") String nome) {
        logger.info("Sending bio from equipamento nome" + nome);
        return queryRepository.equipamentobynome(nome);
    }



    @GetMapping(path = "/ABC/marca/{marca:[.-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getequipamentoBymarcaORDENADO(@PathVariable("marca") String marca) {
        logger.info("Sending bio from equipamento marca ORDENADO" + marca);
        return queryRepository.equipamentobymarcaORD(marca);
    }
    @GetMapping(path = "/ABC/tipo/{tipo:[.-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getequipamentoBytipoORDENADO(@PathVariable("tipo") String tipo) {
        logger.info("Sending bio from equipamento tipo ORDENADO" + tipo);
        return queryRepository.equipamentobytipoORD(tipo);
    }
    @GetMapping(path = "/ABC/nome/{nome:[.-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getequipamentoBynomeORDENADO(@PathVariable("nome") String nome) {
        logger.info("Sending bio from equipamento nome ORDENADO" + nome);
        return queryRepository.equipamentobynomeORD(nome);
    }



    //by id

    @GetMapping(path = "/marca/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getequipamentoBymarcaid(@PathVariable("id") int id) {
        logger.info("Sending bio from equipamento marca" + id);
        return queryRepository.equipamentobymarcaid(id);
    }
    @GetMapping(path = "/tipo/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getequipamentoBytipoid(@PathVariable("id") int id) {
        logger.info("Sending bio from equipamento tipo" + id);
        return queryRepository.equipamentobytipoid(id);
    }



    @GetMapping(path = "/ABC/marca/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getequipamentoBymarcaidORDENADO(@PathVariable("id") int id) {
        logger.info("Sending bio from equipamento marca ORDENADO" + id);
        return queryRepository.equipamentobymarcaidORD(id);
    }
    @GetMapping(path = "/ABC/tipo/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getequipamentoBytipoidORDENADO(@PathVariable("id") int id) {
        logger.info("Sending bio from equipamento tipo ORDENADO" + id);
        return queryRepository.equipamentobytipoidORD(id);
    }
    @GetMapping(path = "/ABC/nome/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getequipamentoByidORDENADO(@PathVariable("id") int id) {
        logger.info("Sending bio from equipamento id ORDENADO" + id);
        return queryRepository.equipamentobyidORD(id);
    }







}