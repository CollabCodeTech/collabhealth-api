package tech.collabcode.collabhealth.repository;

import org.springframework.data.repository.Repository;

import tech.collabcode.collabhealth.model.Equipment;

public interface EquipmentRepository extends Repository<Equipment, Long> {

	Equipment save(Equipment e);
}
