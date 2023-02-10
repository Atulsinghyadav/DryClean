package com.cg.dryclean.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="addresses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Addresses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
//	@Column(name = "door_no")
	private String doorNo;
//	@Column(name = "street")
	private String street;	
//	@Column(name = "area")
	private String area;	
//	@Column(name = "city")
	private String city;	
//	@Column(name = "state")
	private String state;
	
//	@Column(name = "pincode")
	private Integer pincode;
	
}
