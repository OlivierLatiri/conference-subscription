package conferences.component;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

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
@Table(name = "conferences")
public class Conference {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "conference_id")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "category")
	private String category;
	@Column(name = "earlyprice")
	private float earlyPrice;
	@Column(name = "lateprice")
	private float latePrice;	
	@Column(name = "earlydate")
	@ManyToOne(cascade=CascadeType.ALL)
	private Periode earlyDate;
	@Column(name = "latedate")
	@ManyToOne(cascade=CascadeType.ALL)
	private Periode lateDate;
	
	public Conference(String name, String category, float earlyPrice, float latePrice, Periode earlyDate, Periode latePeriode) {
		this.name = name;
		this.category = category;
		this.earlyPrice = earlyPrice;
		this.latePrice = latePrice;
		this.earlyDate = earlyDate;
		this.lateDate = latePeriode;
	}
	
	public float pricePeriod(Date d) throws Exception {
		if(earlyDate.contains(d)) {
			return earlyPrice;
		}
		else if(lateDate.contains(d)) {
			return latePrice;
		}
		throw new Exception();
	}
	
	
	
}
