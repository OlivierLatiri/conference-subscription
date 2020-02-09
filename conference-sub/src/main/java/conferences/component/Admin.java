package conferences.component;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

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
	@Column(name = "username")
	@Length(min = 5, message = "*Your user name must have at least 5 characters")
	private String userName;
	@Column(name = "password")
	@Length(min = 5, message = "*Your password must have at least 5 characters")
	private String password;
	@Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
	private String email;
	@Column(name = "role")
    private Role role;

	public Admin(String userName, String password, String email, Role role) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.role = role;
	}


}
