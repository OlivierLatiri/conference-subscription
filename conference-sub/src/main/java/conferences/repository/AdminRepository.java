package conferences.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import conferences.component.Admin;

public interface AdminRepository extends CrudRepository<Admin, Long> {

	Optional<Admin> findByLogin(String login);


	Optional<Admin> findByNameAndLastName(String name, String lastName);
	
}
