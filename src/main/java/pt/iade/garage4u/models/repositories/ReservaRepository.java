package pt.iade.garage4u.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.garage4u.models.Reserva;

public interface ReservaRepository extends CrudRepository<Reserva, Integer> {
}