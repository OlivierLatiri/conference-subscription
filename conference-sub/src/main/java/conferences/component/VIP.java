package conferences.component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
@Table(name = "vip")
public class VIP {
	
	private @Id @GeneratedValue Long id;
	private String name;
	private String lastName;
	private String email;
	private Role role;
	public VIP(String name, String lastName, String email, Role role) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
	}
	

}
