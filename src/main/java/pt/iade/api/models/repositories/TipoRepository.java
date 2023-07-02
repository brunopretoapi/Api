package pt.iade.api.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.api.models.Tipo;

public interface TipoRepository extends CrudRepository<Tipo, Integer> {
}