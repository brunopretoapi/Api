package pt.iade.garage4u.controlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.iade.garage4u.models.Exceptions.Response;
import pt.iade.garage4u.models.Utilizador;
import pt.iade.garage4u.repository.QueryRepository;

import java.sql.Date;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/querys")
public class QuerysController {

    private final Logger logger = LoggerFactory.getLogger(QuerysController.class);

    @Autowired
    private QueryRepository queryRepository;

    @GetMapping(path = "/existe/{nome:[.-z]+}/{pass:[.-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getexit_userBypass_nome(@PathVariable("nome") String nome,@PathVariable("pass") String pass) {
        logger.info("Sending bio from route nome: ,pass:" + nome +pass);
        return queryRepository.Exite_utilizador(nome,pass);
        //return (Iterable<String>) new Response("{\"estado\":\"" + queryRepository.Exite_utilizador(nome,pass)+ "\"",null);
    }

    @GetMapping(path = "/utilizador_info/{nome:[.-z]+}/{pass:[.-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Utilizador> get_utilizador_info(@PathVariable("nome") String nome,@PathVariable("pass") String pass) {
        logger.info("Sending bio from route nome: ,pass:" + nome +pass);
        return queryRepository.utilizador_info(nome,pass);
    }

    @GetMapping(path = "/garagens_info/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> get_garagens_info(@PathVariable("id") int id) {
        logger.info("Sending bio from route id:" + id);
        return queryRepository.garagens_info(id);
    }

    @GetMapping(path = "/controlo_porta/{nome:[.-z]+}/{pass:[.-z]+}/{cod_dispositivo:[a-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> get_controlo_porta(@PathVariable("nome") String nome,@PathVariable("pass") String pass,@PathVariable("cod_dispositivo") String cod_dispositivo) {
        logger.info("Sending bio from route nome:,pass:,cod_dispositivo:" + nome +pass + cod_dispositivo);
        return queryRepository.controlo_porta(nome,pass,cod_dispositivo);
    }

    @GetMapping(path = "/controlo_lampada/{nome:[.-z]+}/{pass:[.-z]+}/{cod_dispositivo:[a-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> get_controlo_lampada(@PathVariable("nome") String nome,@PathVariable("pass") String pass,@PathVariable("cod_dispositivo") String cod_dispositivo) {
        logger.info("Sending bio from route nome:,pass:,cod_dispositivo:" + nome +pass + cod_dispositivo);
        return queryRepository.controlo_lampada(nome,pass,cod_dispositivo);
    }

    @GetMapping(path = "/controlo_tem_lampada/{cod_dispositivo:[a-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> get_controlo_tem_lampada(@PathVariable("cod_dispositivo") String cod_dispositivo) {
        logger.info("Sending bio from route nome:,pass:,cod_dispositivo:" + cod_dispositivo);
        return queryRepository.controlo_tem_lampada(cod_dispositivo);
    }

    @GetMapping(path = "/estado_portao/{cod_dispositivo:[a-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> get_estado_portao(@PathVariable("cod_dispositivo") String cod_dispositivo) {
        logger.info("Sending bio from route nome:,pass:,cod_dispositivo:" + cod_dispositivo);
        return queryRepository.estado_portao(cod_dispositivo);
    }

    @GetMapping(path = "/estado_luz/{cod_dispositivo:[a-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> get_estado_luz(@PathVariable("cod_dispositivo") String cod_dispositivo) {
        logger.info("Sending bio from route nome:,pass:,cod_dispositivo:" + cod_dispositivo);
        return queryRepository.estado_luz(cod_dispositivo);
    }




    /*

    @GetMapping(path = "/utilizador_reservas/{nome:[.-z]+}/{pass:[.-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getutilizador_reservas(@PathVariable("nome") String nome,@PathVariable("pass") String pass) {
        logger.info("Sending bio from route nome: ,pass:" + nome +pass);
        return queryRepository.utilizador_reserva(nome,pass);
    }

    @GetMapping(path = "/teste/{nome:[A-z]+}/{morada:[.-z]+}/{genero:[a-z]+}/{data:[--9]+}/{identificacao:[0-9]+}/{email:[.-z]+}/{pass:[.-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> get_teste(@PathVariable("nome") String nome,@PathVariable("morada") String morada,@PathVariable("genero") String genero,@PathVariable("data") Date data,@PathVariable("identificacao") int identificacao,@PathVariable("email") String email,@PathVariable("pass") String pass) {
        logger.info("Sending bio from route nome:,morada:,genero:,data:,identificacao:,email:,pass:" + nome + morada + genero + data + identificacao+email+pass);
        return queryRepository.teste(nome,morada,genero,data,identificacao,email,pass);
    }

    @GetMapping(path = "/cria_utilizador/{nome:[A-z]+}/{morada:[.-z]+}/{genero:[a-z]+}/{data:[--9]+}/{identificacao:[0-9]+}/{email:[.-z]+}/{pass:[.-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> get_cria_utilizador(@PathVariable("nome") String nome,@PathVariable("morada") String morada,@PathVariable("genero") String genero,@PathVariable("data") Date data,@PathVariable("identificacao") int identificacao,@PathVariable("email") String email,@PathVariable("pass") String pass) {
        logger.info("Sending bio from route nome:,morada:,genero:,data:,identificacao:,email:,pass:" + nome + morada + genero + data + identificacao+email+pass);
        return queryRepository.criar_utilizador (nome,morada,genero,data,identificacao,email,pass);
    }



    // terminar
   @GetMapping(path = "/cria_utilizador/nome:[A-z]+}/morada:[.-z]+}/genero:[A-Z]+}/data:[.-z]+}/identificacao:[0-9]+}/email:[.-z]+}/pass:[.-z]+}/num_card:[0-9]+}/cvv:[0-9]+}/nome_cartao:[A-z]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> get_cria_utilizador(@PathVariable("nome") String nome,@PathVariable("morada") String morada,@PathVariable("genero") Character genero,@PathVariable("data") String data,@PathVariable("identificacao") int identificacao,@PathVariable("email") String email,@PathVariable("pass") String pass,@PathVariable("num_card") int num_card,@PathVariable("cvv") int cvv,@PathVariable("nome_cartao") String nome_cartao) {
        logger.info("Sending bio from route nome:,morada:,genero:,data:,identificacao:,email:,pass:, num_card:, cvv: ,nome_cartao:" + nome+morada+genero+data+identificacao+email+pass+num_card+cvv+nome_cartao);
        return queryRepository.criar_utilizador(nome,morada,genero,data,identificacao,email,pass,num_card,cvv,nome_cartao);
    }

    @GetMapping(path = "/adicionar_garagens/{utilizador_email:[.-z]+}/{utilizador_pass:[.-z]+}/{garagem_localizacao:[0-z]+}/{garagem_zona:[a-z]+}/{garagem_zona_cod:[0-9]+}/{garagem_lampada:[0-1]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> get_Add_garagens(@PathVariable("utilizador_email") String utilizador_email,@PathVariable("utilizador_pass") String utilizador_pass,@PathVariable("garagem_localizacao") String garagem_localizacao,@PathVariable("garagem_zona") String garagem_zona,@PathVariable("garagem_zona_cod") int garagem_zona_cod,@PathVariable("garagem_lampada") boolean garagem_lampada) {
        logger.info("Sending bio from route utilizador_email:,utilizador_pass:,garagem_localizacao:,garagem_zona:,garagem_zona_cod:,garagem_lampada:" + utilizador_email+utilizador_pass+garagem_localizacao+garagem_zona+garagem_zona_cod+garagem_lampada);
        return queryRepository.add_garagens(utilizador_email,utilizador_pass,garagem_localizacao,garagem_zona,garagem_zona_cod,garagem_lampada);
    }
  
     */


    // banco

    @GetMapping(path = "/banco/confirma_trasacao/{utilizador:[A-z]+}/{num_card:[0-9]+}/{cvv:[0-9]+}/{quantidade_dinheiro:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getconfirma_trasacao(@PathVariable("utilizador") String utilizador,@PathVariable("num_card") int num_card,@PathVariable("cvv") int cvv,@PathVariable("quantidade_dinheiro") int quantidade_dinheiro) {
        logger.info("Sending bio from route utilizador: ,num_card:,cvv:,quantidade_dinheiro:" + utilizador +num_card+cvv+quantidade_dinheiro);
        return queryRepository.confirma_trasacao(utilizador ,num_card,cvv,quantidade_dinheiro);
    }

    @GetMapping(path = "/banco/depositar/{utilizador:[A-z]+}/{num_card:[0-9]+}/{cvv:[0-9]+}/{quantidade_dinheiro:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getdepositar(@PathVariable("utilizador") String utilizador,@PathVariable("num_card") int num_card,@PathVariable("cvv") int cvv,@PathVariable("quantidade_dinheiro") int quantidade_dinheiro) {
        logger.info("Sending bio from route utilizador: ,num_card:,cvv:,quantidade_dinheiro:" + utilizador +num_card+cvv+quantidade_dinheiro);
        return queryRepository.deposita(utilizador ,num_card,cvv,quantidade_dinheiro);
    }

    @GetMapping(path = "/banco/levantar/{utilizador:[A-z]+}/{num_card:[0-9]+}/{cvv:[0-9]+}/{quantidade_dinheiro:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<String> getlevantar(@PathVariable("utilizador") String utilizador,@PathVariable("num_card") int num_card,@PathVariable("cvv") int cvv,@PathVariable("quantidade_dinheiro") int quantidade_dinheiro) {
        logger.info("Sending bio from route utilizador: ,num_card:,cvv:,quantidade_dinheiro:" + utilizador +num_card+cvv+quantidade_dinheiro);
        return queryRepository.levanta(utilizador ,num_card,cvv,quantidade_dinheiro);
    }
}




