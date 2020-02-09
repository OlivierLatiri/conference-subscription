package conferences.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import conferences.repository.VIPRepository;


@CrossOrigin(origins="*")
@RequestMapping(value= "/transaction") 
@RestController
public class VIPController {
	
	@Autowired
    private VIPRepository vipRepository;
	//TO DO
}
