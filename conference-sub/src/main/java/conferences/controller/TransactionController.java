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

import conferences.component.Transaction;
import conferences.repository.TransactionRepository;

@CrossOrigin(origins="*")
@RequestMapping(value= "/transaction") 
@RestController
public class TransactionController {

	@Autowired
    private TransactionRepository itransaction;
 
    @GetMapping("/list")
    public ResponseEntity<Iterable<Transaction>> getTransactions() {
        return new ResponseEntity<>(itransaction.findAll(), HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<HttpEntity> addTransaction(Transaction t){
    	Optional<Transaction> s = itransaction.findByNameAndLastName(t.getName(), t.getLastName());
    	if(s.isPresent()) return new ResponseEntity<>(HttpEntity.EMPTY, HttpStatus.ALREADY_REPORTED);
    	
    	itransaction.save(t);
    	return new ResponseEntity<>(HttpEntity.EMPTY, HttpStatus.OK);
    }
}
