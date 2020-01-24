package conferences.repository;

import org.springframework.data.repository.CrudRepository;

import conferences.component.Conference;

public interface VIPRepository extends CrudRepository<Conference, Long> {

}
