package conferences.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import conferences.component.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

	Optional<Transaction> findByNameAndLastName(String prenom, String nom);

}
