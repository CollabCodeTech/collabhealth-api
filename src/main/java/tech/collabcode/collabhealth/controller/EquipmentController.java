package tech.collabcode.collabhealth.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import tech.collabcode.collabhealth.model.Equipment;
import tech.collabcode.collabhealth.repository.EquipmentRepository;
import tech.collabcode.collabhealth.specification.EquipmentSearchSpecification;

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

	@GetMapping
	public ResponseEntity<List<Equipment>> list(@RequestParam(required=false) Map<String, String> queryMap) {
		Specification<Equipment> equipmentSearch = new EquipmentSearchSpecification(queryMap).build();
		List<Equipment> allEquipments = this.equipmentRepository.findAll(equipmentSearch);
		return ResponseEntity.ok(allEquipments);
	}
}
