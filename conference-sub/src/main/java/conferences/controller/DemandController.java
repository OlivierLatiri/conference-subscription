package conferences.controller;

import java.util.Optional;

import javax.swing.text.StyledEditorKit.ItalicAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import conferences.component.Demand;
import conferences.repository.DemandRepository;

@CrossOrigin(origins="*")
@RequestMapping(value= "/transaction") 
@RestController
public class DemandController {

	@Autowired
    private DemandRepository demandRepository;
 
    @GetMapping("/list")
    public ResponseEntity<Iterable<Demand>> getDemands() {
        return new ResponseEntity<>(demandRepository.findAll(), HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<HttpEntity> addNewDemand(Demand t){
    	Optional<Demand> s = demandRepository.findByNameAndLastName(t.getName(), t.getLastName());
    	if(s.isPresent()) return new ResponseEntity<>(HttpEntity.EMPTY, HttpStatus.ALREADY_REPORTED);
    	
    	demandRepository.save(t);
    	return new ResponseEntity<>(HttpEntity.EMPTY, HttpStatus.OK);
    }
}
