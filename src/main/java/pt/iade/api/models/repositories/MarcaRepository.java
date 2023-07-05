package pt.iade.api.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.api.models.marca;

public interface MarcaRepository extends CrudRepository<marca, Integer> {
}