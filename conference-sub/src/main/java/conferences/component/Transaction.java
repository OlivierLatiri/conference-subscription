package conferences.component;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Transaction {
	
	
	
	
	private @Id @GeneratedValue Long id;
	private String nom;
	private String prenom;
	private Date date;
	private Etat etat;
	private String mail;
	private Status status;
	
	public Transaction() {}
	
	public Transaction(String nom, String prenom, Date date, Etat etat, String mail, Status status) {
		this.nom = nom;
		this.prenom = prenom;
		this.date = date;
		this.etat = etat;
		this.mail = mail;
		this.status = status;
	}

}
