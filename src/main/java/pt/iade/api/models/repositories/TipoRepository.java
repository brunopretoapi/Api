package pt.iade.api.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.api.models.tipo;

public interface TipoRepository extends CrudRepository<tipo, Integer> {
}