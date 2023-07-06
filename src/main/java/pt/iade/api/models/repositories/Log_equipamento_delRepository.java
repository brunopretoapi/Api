package pt.iade.api.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.api.models.equipamentos;
import pt.iade.api.models.log_equipamento_del;

import java.util.Optional;

public interface Log_equipamento_delRepository extends CrudRepository<log_equipamento_del, Integer> {
}