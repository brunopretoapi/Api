package pt.iade.api.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.api.models.Marca;

public interface MarcaRepository extends CrudRepository<Marca, Integer> {
}