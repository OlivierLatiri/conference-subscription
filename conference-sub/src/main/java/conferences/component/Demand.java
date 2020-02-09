package conferences.component;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import conferences.component.Admin.AdminBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "demands")
public class Demand {
	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "demand_id")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "lastname")
	private String lastName;
	@Column(name = "conference")
	private String conference;
	@Column(name = "email")
	private String mail;
	
	
	public Demand(String name, String lastName, String conference, String mail) {
		this.name = name;
		this.lastName = lastName;
		this.conference = conference;
		this.mail = mail;
	}

}
