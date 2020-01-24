package conferences.component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class VIP {
	
	private @Id @GeneratedValue Long id;
	private String name;
	private String lastName;
	private Status status;
	public VIP(Long id, String name, String lastName, Status status) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.status = status;
	}
	
	public VIP() {}

}
