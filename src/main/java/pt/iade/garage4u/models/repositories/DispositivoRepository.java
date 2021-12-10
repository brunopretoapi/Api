package pt.iade.garage4u.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.garage4u.models.Dispositivo;

public interface DispositivoRepository extends CrudRepository<Dispositivo, Integer> {
}