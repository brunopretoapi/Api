package pt.iade.garage4u.repository;

import pt.iade.garage4u.models.Utilizador;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface QueryRepository extends CrudRepository<Utilizador, Integer> {

    String QueryAvgAllRoutes = "select rt_name as rtName, re_rt_id as id, avg(re_rate) as rtAvg\n" +
            "from route_evaluations inner join routes on re_rt_id = rt_id\n" +
            "group by rt_name, re_rt_id order by rtAvg desc";

    // show the routes from the most popular to the least
    // The popularity of a route is calculated by the amount of favorites
    @Query(value = "select utilizador_existe(:nome,:pass)", nativeQuery = true)
    Iterable<String> Exite_utilizador(String nome, String pass);

    Optional<Utilizador> findByUtilizadorId(int id);

    @Query(value = "select * from utilizador where utilizador_id = :id", nativeQuery = true)
    Iterable<Utilizador> teste(int id);

    @Query(value = "select * from utilizador", nativeQuery = true)
    Iterable<Utilizador> teste2();

    @Query(value = "select utilizador_nome from utilizador where utilizador_id = :id", nativeQuery = true)
    Iterable<String> teste3(int id);

    /*@Query(value = "select rt_bio from routes where rt_id = :id", nativeQuery = true)
    Iterable<String> findRtBioById(int id);

    Iterable<Route> findByRtNameContainingAndRtDistBetween(String name, double min, double max);

    @Query(value = QueryAvgAllRoutes, nativeQuery = true)
    Iterable<RouteView> avgAllRoutes();*/
}