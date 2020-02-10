package conferences.component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admins")
public class Admin {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "admin_id")
	private Long id;
	@Column(name = "username", unique=true) //unique sert à garantir que c'est unique not sure si ça marche
	@Size(min = 5, message = "*Your user name must have at least 5 characters")
	private String userName;
	@Column(name = "password")
	@Size(min = 5, message = "*Your password must have at least 5 characters")
	private String password;
	@Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
	private String email;
	
	@Enumerated(EnumType.STRING)
    private Role role;

	public Admin(String userName, String password, String email, Role role) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.role = role;
	}


}
