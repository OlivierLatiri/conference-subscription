package conferences;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import conferences.component.Admin;
import conferences.component.Role;
import conferences.repository.AdminRepository;

@SpringBootTest
public class AdminRepositoryIntegrationTest {

    @Autowired
    private AdminRepository adminRepository;
 
    @Test
    public void testAdminRepository() {
    	Optional<Admin> adminFound = adminRepository.findByUserName("admin");
    	if(adminFound.get() != null) {
    		assertThat(adminFound.get().getRole()).isEqualTo(Role.SUPERADMIN);
    	}
    }
}
