package pt.iade.api.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.api.models.equipamentos;

public interface EquipamentosRepository extends CrudRepository<equipamentos, Integer> {
}