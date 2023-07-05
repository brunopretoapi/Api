package pt.iade.api.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.api.models.necessidade;

public interface NecessidadeRepository extends CrudRepository<necessidade, Integer> {
}