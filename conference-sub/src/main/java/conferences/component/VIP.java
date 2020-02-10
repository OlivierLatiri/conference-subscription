package conferences.component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "vip")
public class VIP {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vip_id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Role role;
	
	public VIP(String name, String lastName, String email, Role role) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
	}
	

}
