package tech.collabcode.collabhealth.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import tech.collabcode.collabhealth.model.Equipment;
import tech.collabcode.collabhealth.repository.EquipmentRepository;

@RestController
@RequestMapping("/api/equipments")
public class EquipmentController {
	@Autowired
	private EquipmentRepository equipmentRepository;

	@PostMapping
	public ResponseEntity<Equipment> create(@RequestBody Equipment equipment, UriComponentsBuilder uriBuilder) {
		Equipment savedEquipment = this.equipmentRepository.save(equipment);
		
		URI path = uriBuilder.path("/api/equipments/{id}").buildAndExpand(savedEquipment.getId()).toUri();
		return ResponseEntity.created(path).body(savedEquipment);
	}
}
