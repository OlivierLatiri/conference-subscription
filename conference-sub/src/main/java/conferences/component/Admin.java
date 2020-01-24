package conferences.component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class Admin {

	private @Id @GeneratedValue Long id;
	@NotBlank
	private String name;
	@NotBlank
	private String lastName;
	@NotBlank
	private String login;
	@NotBlank
	private String password;
	@NotBlank
	private String email;
	
	public Admin() {}
	
	public Admin(String name, String lastName, String login, String password, String email) {
		this.name = name;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.email = email;
	}
	
	
}
