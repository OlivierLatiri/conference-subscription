package conferences.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import conferences.component.VIP;

public interface VIPRepository extends JpaRepository<VIP, Long> {

}
