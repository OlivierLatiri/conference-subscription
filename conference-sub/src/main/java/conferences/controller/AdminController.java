package conferences.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import conferences.component.Admin;
import conferences.repository.AdminRepository;

@CrossOrigin(origins="*")
@RequestMapping(value= "/admin") 
@RestController
public class AdminController {

    private AdminRepository adminRepository; 
	
	@Autowired
	public AdminController(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}
	
    @GetMapping("/login")
    public ResponseEntity<Admin> loginAdmin(String username, String password) {
        Optional<Admin> admin = adminRepository.findByUserName(username);
        if(admin.isPresent() && admin.get().getPassword().equals(password)) {
        	// j'ai choisi de retourner un object Admin, mais on peut
        	// très bien le changer en String, et retourné "login succes" comme phrase
        	// https://www.baeldung.com/spring-response-entity : lien internet où je me suis inspiré
        	return new ResponseEntity<>(admin.get(), HttpStatus.OK);    	
        }else {
        	return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/add")
    public ResponseEntity<HttpEntity> addAdmin(@Valid Admin admin) {
    	Optional<Admin> optAdmin = adminRepository.findByUserName(admin.getUserName());
    	if(optAdmin.isPresent()) return new ResponseEntity<>(HttpEntity.EMPTY, HttpStatus.ALREADY_REPORTED);
    	adminRepository.save(admin);
    	return new ResponseEntity<>(HttpEntity.EMPTY, HttpStatus.OK);
    }
}
