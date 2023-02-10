package com.cg.dryclean.entity;
import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Services {
	
	@Id
	@GeneratedValue(strategy = (GenerationType.IDENTITY))
	private Integer id;
	private String type;
	private BigDecimal charges;
	
}
