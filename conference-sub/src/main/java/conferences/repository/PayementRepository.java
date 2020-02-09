package conferences.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import conferences.component.Payement;

public interface PayementRepository extends JpaRepository<Payement, Long> {

}
