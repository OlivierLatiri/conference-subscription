package conferences.component;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Periode {
	
	private @Id @GeneratedValue Long id;
	private Date begin;
	private Date end;
	
	public Periode() {}
	
	public Periode(Date begin, Date end) {
		this.begin = begin;
		this.end = end;
	}
	
	public boolean contains(Date date) {
		if(date.compareTo(begin) >= 0 && date.compareTo(end) <= 0) {
			return true;
		}
		return false;
	}
}
