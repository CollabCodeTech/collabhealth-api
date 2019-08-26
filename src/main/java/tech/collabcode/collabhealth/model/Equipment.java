package tech.collabcode.collabhealth.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Equipment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String criticalness;
	private String brand;
	private String model;
	private String tag;
	private String serialNumber;
	private String owner;
	private String area;
	private String sector;
	private LocalDate preventiveMaintenenceDate;
	private LocalDate calibrationDate;
	private LocalDate electricalSafetyTestDate;
	private LocalDate validationDate;
}