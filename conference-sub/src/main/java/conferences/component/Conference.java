package conferences.component;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import lombok.Data;

@Data
@Entity
@EnableAutoConfiguration
public class Conference {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private String name;
	private String category;
	private float earlyPrice;
	private float latePrice;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Periode earlyDate;
	@ManyToOne(cascade=CascadeType.ALL)
	private Periode lateDate;
	
	public Conference() {}
	
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
