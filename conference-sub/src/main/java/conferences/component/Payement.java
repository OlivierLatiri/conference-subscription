package conferences.component;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payements")
public class Payement {

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
	@Column(name = "status")
	private Status status;
	@Column(name = "expiring_date")
	private Date expiring_date;


	public Payement(String name, String lastName, String conference, String mail, Status status, Date expiring_date) {
		this.name = name;
		this.lastName = lastName;
		this.conference = conference;
		this.mail = mail;
		this.status = status;
		this.expiring_date = expiring_date;
	}

}
