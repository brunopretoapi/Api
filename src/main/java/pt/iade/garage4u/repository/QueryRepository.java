package pt.iade.garage4u.repository;

import pt.iade.garage4u.models.Utilizador;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface QueryRepository extends CrudRepository<Utilizador, Integer> {

    @Query(value = "select utilizador_existe(:nome,:pass)", nativeQuery = true)
    Iterable<String> Exite_utilizador(String nome, String pass);

    @Query(value = "select depositar(:utilizador, :num_card, :cvv, :quantidade_dinheiro)", nativeQuery = true)
    Iterable<String> deposita(String utilizador, int num_card, int cvv, int quantidade_dinheiro);

    @Query(value = "select levantar(:utilizador, :num_card, :cvv, :quantidade_dinheiro)", nativeQuery = true)
    Iterable<String> levanta(String utilizador, int num_card, int cvv, int quantidade_dinheiro);


}