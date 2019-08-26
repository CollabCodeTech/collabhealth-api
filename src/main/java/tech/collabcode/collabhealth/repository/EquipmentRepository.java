package tech.collabcode.collabhealth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import tech.collabcode.collabhealth.model.Equipment;

public interface EquipmentRepository extends Repository<Equipment, Long>, JpaSpecificationExecutor<Equipment> {
	Equipment save(Equipment e);

	@Query("select e from Equipment e")
	List<Equipment> findAll();
}
