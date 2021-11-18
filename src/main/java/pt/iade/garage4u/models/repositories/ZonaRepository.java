package pt.iade.garage4u.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.iade.garage4u.models.Zona;

public interface ZonaRepository extends JpaRepository<Zona, Integer> {
}