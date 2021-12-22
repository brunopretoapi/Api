package pt.iade.garage4u.repository;

import org.springframework.data.jpa.repository.Modifying;
import pt.iade.garage4u.models.Utilizador;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;


public interface QueryRepository extends CrudRepository<Utilizador, Integer> {

    @Query(value = "select utilizador_existe(:nome,:pass)", nativeQuery = true)
    Iterable<String> Exite_utilizador(String nome, String pass);

    @Query(value = "select depositar(:utilizador, :num_card, :cvv, :quantidade_dinheiro)", nativeQuery = true)
    Iterable<String> deposita(String utilizador, int num_card, int cvv, int quantidade_dinheiro);

    @Query(value = "select levantar(:utilizador, :num_card, :cvv, :quantidade_dinheiro)", nativeQuery = true)
    Iterable<String> levanta(String utilizador, int num_card, int cvv, int quantidade_dinheiro);

    // terminar
    @Query(value = "select utilizador_reservas(:nome,:pass)", nativeQuery = true)
    Iterable<String> utilizador_reserva(String nome, String pass);

    @Query(value = "select * from utilizador where utilizador_email = :nome and utilizador_pass = :pass", nativeQuery = true)
    Iterable<Utilizador> utilizador_info(String nome, String pass);

    @Query(value = "select * from garagens where garagens_id = :id", nativeQuery = true)
    Iterable<String> garagens_info(int id);

    @Query(value = "select criar_garagens(:utilizador_email,:utilizador_pass,:garagem_localizacao,:garagem_zona,:garagem_zona_cod,:garagem_lampada)", nativeQuery = true)
    Iterable<String> add_garagens(String utilizador_email,String utilizador_pass,String garagem_localizacao,String garagem_zona,int garagem_zona_cod,boolean garagem_lampada);

    @Query(value = "select utilizador_name from utilizador where utilizador_name = :nome and utilizador_morada = :morada and utilizador_gender = :genero and utilizador_bdate = :data and utilizador_identificacao_id = :identificacao and utilizador_email = :email and utilizador_pass =:pass", nativeQuery = true)
    Iterable<String> teste(String nome, String morada, String genero, Date data ,int identificacao,String email, String pass);

    @Modifying
    @Query(value = " select cria_utilizador(:nome,:morada,:genero,:data,:identificacao,:email,:pass", nativeQuery = true)
    Iterable<String> criar_utilizador(String nome, String morada, String genero, Date data ,int identificacao,String email, String pass);

}