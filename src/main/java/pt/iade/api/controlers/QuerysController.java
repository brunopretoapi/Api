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


    @GetMapping(path = "/nome/marca/{marca:[.-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getequipamentoBymarca(@PathVariable String marca) {
        logger.info("Sending bio from equipamento marca" + marca);
        return queryRepository.equipamentobymarca(marca);
    }
    @GetMapping(path = "/nome/tipo/{tipo:[.-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getequipamentoBytipo(@PathVariable("tipo") String tipo) {
        logger.info("Sending bio from equipamento tipo" + tipo);
        return queryRepository.equipamentobytipo(tipo);
    }
    @GetMapping(path = "/nome/nome/{nome:[.-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getequipamentoBynome(@PathVariable("nome") String nome) {
        logger.info("Sending bio from equipamento nome" + nome);
        return queryRepository.equipamentobynome(nome);
    }



    @GetMapping(path = "/nome/ABC/marca/{marca:[.-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getequipamentoBymarcaORDENADO(@PathVariable("marca") String marca) {
        logger.info("Sending bio from equipamento marca ORDENADO" + marca);
        return queryRepository.equipamentobymarcaORD(marca);
    }
    @GetMapping(path = "/nome/ABC/tipo/{tipo:[.-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getequipamentoBytipoORDENADO(@PathVariable("tipo") String tipo) {
        logger.info("Sending bio from equipamento tipo ORDENADO" + tipo);
        return queryRepository.equipamentobytipoORD(tipo);
    }
    @GetMapping(path = "/nome/ABC/nome/{nome:[.-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getequipamentoBynomeORDENADO(@PathVariable("nome") String nome) {
        logger.info("Sending bio from equipamento nome ORDENADO" + nome);
        return queryRepository.equipamentobynomeORD(nome);
    }



    //by id

    @GetMapping(path = "/id/marca/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getequipamentoBymarcaid(@PathVariable("id") int id) {
        logger.info("Sending bio from equipamento marca" + id);
        return queryRepository.equipamentobymarcaid(id);
    }
    @GetMapping(path = "/id/tipo/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getequipamentoBytipoid(@PathVariable("id") int id) {
        logger.info("Sending bio from equipamento tipo" + id);
        return queryRepository.equipamentobytipoid(id);
    }



    @GetMapping(path = "/id/ABC/marca/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getequipamentoBymarcaidORDENADO(@PathVariable("id") int id) {
        logger.info("Sending bio from equipamento marca ORDENADO" + id);
        return queryRepository.equipamentobymarcaidORD(id);
    }
    @GetMapping(path = "/id/ABC/tipo/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getequipamentoBytipoidORDENADO(@PathVariable("id") int id) {
        logger.info("Sending bio from equipamento tipo ORDENADO" + id);
        return queryRepository.equipamentobytipoidORD(id);
    }
    @GetMapping(path = "/id/ABC/nome/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getequipamentoByidORDENADO(@PathVariable("id") int id) {
        logger.info("Sending bio from equipamento id ORDENADO" + id);
        return queryRepository.equipamentobyidORD(id);
    }





    @GetMapping(path = "/nome/acontecimento/{tipo_acontecimento:[.-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getaacontecimento(@PathVariable("tipo_acontecimento") String tipo_acontecimento) {
        logger.info("Sending bio from tipo_acontecimento " + tipo_acontecimento);
        return queryRepository.acontecimento(tipo_acontecimento);
    }

    @GetMapping(path = "/nome/criar_acontecimento/{id_equipamento:[0-9]+}/{nessecidade_falta:[.-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getaacontecimento(@PathVariable("id_equipamento") int id_equipamento,@PathVariable("nessecidade_falta") String nessecidade_falta) {
        logger.info("Sending bio from equipamento id " + id_equipamento + "nessecidade_falta" + nessecidade_falta);
        return queryRepository.criar_acontecimento_com_necessidade(id_equipamento,nessecidade_falta);
    }



}
