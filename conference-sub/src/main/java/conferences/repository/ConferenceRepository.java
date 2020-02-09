package conferences.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import conferences.component.Conference;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {
}
