package pt.iade.garage4u.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.iade.garage4u.models.Rate;

public interface RateRepository extends JpaRepository<Rate, Integer> {
}