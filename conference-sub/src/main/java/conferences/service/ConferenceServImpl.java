package conferences.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import conferences.component.Conference;
import conferences.repository.ConferenceDaoImpl;

@Service
public class ConferenceServImpl {

	@Autowired
    ConferenceDaoImpl confdao;
 
    public Conference getConference() {
        return confdao.getConferenceFromDb();
    }
}
