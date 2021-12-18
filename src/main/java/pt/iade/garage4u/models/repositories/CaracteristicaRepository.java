package pt.iade.garage4u.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.garage4u.models.Caracteristica;

public interface CaracteristicaRepository extends CrudRepository<Caracteristica, Integer> {
}