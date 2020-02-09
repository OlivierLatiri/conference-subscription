package conferences.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import conferences.component.Demand;

public interface DemandRepository extends JpaRepository<Demand, Long> {

	Optional<Demand> findByNameAndLastName(String prenom, String nom);

}
