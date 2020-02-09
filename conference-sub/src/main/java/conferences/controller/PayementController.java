package conferences.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import conferences.repository.PayementRepository;

@CrossOrigin(origins="*")
@RequestMapping(value= "/transaction") 
@RestController
public class PayementController {

	@Autowired
    private PayementRepository payementRepository;
	// TO DO
}
