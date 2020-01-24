package conferences.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import conferences.component.Conference;
import conferences.repository.ConferenceRepository;


@CrossOrigin(origins="*")
@RequestMapping(value= "/getconference") 
@RestController
public class ConferenceController {

	@Autowired
    private ConferenceRepository iconference;
 
    @GetMapping("/list")
    public Conference getConference() {
        return iconference.findAll().iterator().next();
    }
}
