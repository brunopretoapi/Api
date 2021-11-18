package pt.iade.garage4u.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.garage4u.models.Garagens;

public interface GaragensRepository extends CrudRepository<Garagens, Integer> {
}