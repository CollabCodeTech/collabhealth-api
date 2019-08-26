package tech.collabcode.collabhealth.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Equipment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private final String name;
	private final String criticalness;
	private final String brand;
	private final String model;
	private final String tag;
	private final String serialNumber;
	private final String owner;
	private final String area;
	private final String sector;
	private LocalDate preventiveMaintenenceDate;
	private LocalDate calibrationDate;
	private LocalDate electricalSafetyTestDate;
	private LocalDate validationDate;
}