package conferences.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import conferences.component.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	Optional<Transaction> findByNameAndLastName(String prenom, String nom);

}
