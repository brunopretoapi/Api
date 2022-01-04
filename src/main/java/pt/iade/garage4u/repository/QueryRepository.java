package pt.iade.garage4u.repository;

import org.springframework.stereotype.Repository;
import pt.iade.garage4u.models.Caracteristicas;
import pt.iade.garage4u.models.Utilizador;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;


public interface QueryRepository extends CrudRepository<Utilizador, Integer> {

    @Query(value = "select utilizador_existe(:email,:pass)", nativeQuery = true)
    Iterable<String> Exite_utilizador(String email, String pass);

    @Query(value = "select depositar(:utilizador, :num_card, :cvv, :quantidade_dinheiro)", nativeQuery = true)
    Iterable<String> deposita(String utilizador, int num_card, int cvv, int quantidade_dinheiro);

    @Query(value = "select levantar(:utilizador, :num_card, :cvv, :quantidade_dinheiro)", nativeQuery = true)
    Iterable<String> levanta(String utilizador, int num_card, int cvv, int quantidade_dinheiro);

    @Query(value = "select confirma_trasacao(:utilizador, :num_card, :cvv, :quantidade_dinheiro)", nativeQuery = true)
    Iterable<String> confirma_trasacao(String utilizador, int num_card, int cvv, int quantidade_dinheiro);

    @Query(value = "select * from utilizador where utilizador_email = :email and utilizador_pass = :pass", nativeQuery = true)
    Iterable<Utilizador> utilizador_info(String email, String pass);

    @Query(value = " select dispositivo_porta(:email,:pass,:cod_dip)", nativeQuery = true)
    Iterable<String> controlo_porta(String email, String pass, String cod_dip);

    @Query(value = " select dispositivo_lampada(:email,:pass,:cod_dip)", nativeQuery = true)
    Iterable<String> controlo_lampada(String email, String pass, String cod_dip);

    @Query(value = " select dispositivo_tem_lampada(:cod_dip)", nativeQuery = true)
    Iterable<String> controlo_tem_lampada(String cod_dip);

    @Query(value = "select dispositivo.estado_portao from dispositivo Where rkay=:cod_dip", nativeQuery = true)
    Iterable<String> estado_portao(String cod_dip);

    @Query(value = "select dispositivo.estado_luz from dispositivo Where rkay=:cod_dip", nativeQuery = true)
    Iterable<String> estado_luz(String cod_dip);

    @Query(value = "select utilizador_confirma_trasacao(:email,:pass, :quantidade_dinheiro)", nativeQuery = true)
    Iterable<String> utilizador_confirma_trasacao(String email, String pass, int quantidade_dinheiro);

    @Query(value = "select utilizador_levantar(:email,:pass, :quantidade_dinheiro)", nativeQuery = true)
    Iterable<String> utilizador_levantar(String email, String pass, int quantidade_dinheiro);

    @Query(value = "select utilizador_depositar(:email,:pass, :quantidade_dinheiro)", nativeQuery = true)
    Iterable<String> utilizador_depositar(String email, String pass, int quantidade_dinheiro);

    @Query(value = "select utilizador_update_cartao(:email,:pass,:num_card, :cvv,:nome_cartao)", nativeQuery = true)
    Iterable<String> utilizador_update_cartao(String email, String pass,int num_card, int cvv,String nome_cartao);

    @Query(value = "select utilizador_update_dados(:email,:pass,:nome,:morada,:data,:identificacao)", nativeQuery = true)
    Iterable<String> utilizador_update_dados(String email, String pass,String nome, String morada, Date data ,int identificacao);

    @Query(value = "select utilizador_tipo_de_pag_perf_cartao(:email,:pass)", nativeQuery = true)
    Iterable<String> utilizador_tipo_de_pag_perf_cartao(String email, String pass);











    @Query(value = "select reservar(:email,:pass,:data_entrada,:data_saida,:id_garagem)", nativeQuery = true)
    Iterable<String> reserva(String email, String pass,Date data_entrada,Date data_saida,int id_garagem);





    @Query(value = "select res_gar.garagens_id from reserva inner join utilizador on id_utilizador = utilizador_id left join res_gar on reserva.reservas_id = res_gar.reservas_id where utilizador_email = :nome and utilizador_pass =:pass)", nativeQuery = true)
    Iterable<String> utilizador_reserva(String nome, String pass);

    @Query(value = "select criar_garagens(:utilizador_email,:utilizador_pass,:garagem_localizacao,:garagem_zona,:garagem_zona_cod,:garagem_lampada)", nativeQuery = true)
    Iterable<String> add_garagens(String utilizador_email,String utilizador_pass,String garagem_localizacao,String garagem_zona,int garagem_zona_cod,boolean garagem_lampada);

    @Query(value = "select utilizador_name from utilizador where utilizador_name = :nome and utilizador_morada = :morada and utilizador_gender = :genero and utilizador_bdate = :data and utilizador_identificacao_id = :identificacao and utilizador_email = :email and utilizador_pass =:pass", nativeQuery = true)
    Iterable<String> teste(String nome, String morada, String genero, Date data ,int identificacao,String email, String pass);

    @Query(value = " call cria_utilizador(:nome,:morada,:genero,:data,:identificacao,:email,:pass,null)", nativeQuery = true)
    Iterable<String> criar_utilizador(String nome, String morada, String genero, String data ,int identificacao,String email, String pass);

    @Query(value = "select localizacao_rua,hora_de_entrda,hora_saida,rkay from reserva inner join utilizador on id_utilizador = utilizador_id left join res_gar on reserva.reservas_id = res_gar.reservas_id inner join dispositivo on res_gar.garagens_id = dispositivo.id_garagem inner join garagens on res_gar.garagens_id = garagens.garagens_id where utilizador_email = :email and utilizador_pass = :pass", nativeQuery = true)
    Iterable<String> Reserva_garagens(String email, String pass);

    @Query(value = "select g.garagens_id,g.localizacao_geo,g.localizacao_rua,zona.nome_zona,estado.estado,rate_garagem_id(g.garagens_id),string_agg(tipo_caracteristica, ', ') from caracteristicas inner join caracteristica c on c.caracteristica_id = caracteristicas.caracteristica_id inner join garagens g on g.garagens_id = caracteristicas.garagens_id inner join zona on g.id_zona = zona.id_zona inner join estado on g.id_estado= estado.id_estado where g.garagens_id = :id group by g.garagens_id, localizacao_geo, localizacao_rua, nome_zona, estado, g.garagens_id, rate_garagem_id(g.garagens_id)", nativeQuery = true)
    Iterable<String> garagens_info(int id);




}