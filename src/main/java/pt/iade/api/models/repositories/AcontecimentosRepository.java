package pt.iade.api.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.api.models.acontecimentos;

public interface AcontecimentosRepository extends CrudRepository<acontecimentos, Integer> {
}