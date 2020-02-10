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
	
	@Column(name = "early_price")
	private float earlyPrice;
	
	@Column(name = "late_price")
	private float latePrice;	
	
	@Column(name = "begin_er")
	private Date beginER;
	@Column(name = "end_er")
	private Date endER;
	@Column(name = "begin_lr")
	private Date beginLR;
	@Column(name = "end_lr")
	private Date endLR;
	
	public Conference(String name, String category, float earlyPrice, float latePrice, Date beginER, Date endER, Date beginLR, Date endLR) {
		this.name = name;
		this.category = category;
		this.earlyPrice = earlyPrice;
		this.latePrice = latePrice;
		this.beginER = beginER;
		this.endER = endER;
		this.beginLR = beginLR;
	}
	
	public float pricePeriod(Date d) throws Exception {
		if(beginER.compareTo(d)*d.compareTo(endER) >= 0) {
			return earlyPrice;
		}
		else if(beginLR.compareTo(d)*d.compareTo(endLR) >= 0) {
			return latePrice;
		}
		throw new Exception();
	}
	
	
	
}
