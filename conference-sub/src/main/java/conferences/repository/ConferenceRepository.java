package conferences.repository;

import org.springframework.data.repository.CrudRepository;

import conferences.component.Admin;
import conferences.component.Conference;

public interface ConferenceRepository extends CrudRepository<Conference, Long> {
}
