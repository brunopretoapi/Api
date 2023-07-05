package pt.iade.api.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.api.models.Equipamentos;

public interface EquipamentosRepository extends CrudRepository<Equipamentos, Integer> {
}