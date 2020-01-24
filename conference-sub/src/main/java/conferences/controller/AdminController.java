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

	@Autowired
    private AdminRepository iadmin;
 
    @GetMapping("/login")
    public ResponseEntity<HttpEntity> loginAdmin(String login, String password) {
        Optional<Admin> admin = iadmin.findByLogin(login);
        if(admin.isPresent()) return new ResponseEntity<>(HttpEntity.EMPTY, HttpStatus.OK);
        return new ResponseEntity<>(HttpEntity.EMPTY, HttpStatus.NOT_FOUND);
    }
    
    @PostMapping("/add")
    public ResponseEntity<HttpEntity> addAdmin(@Valid Admin admin) {
    	Optional<Admin> optAdmin = iadmin.findByNameAndLastName(admin.getName(),admin.getLastName());
    	if(optAdmin.isPresent()) return new ResponseEntity<>(HttpEntity.EMPTY, HttpStatus.ALREADY_REPORTED);
    	iadmin.save(admin);
    	return new ResponseEntity<>(HttpEntity.EMPTY, HttpStatus.OK);
    }
}
