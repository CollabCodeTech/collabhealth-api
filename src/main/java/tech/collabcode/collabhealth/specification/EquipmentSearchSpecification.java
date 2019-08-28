package tech.collabcode.collabhealth.specification;

import java.util.ArrayList;
import java.util.Map;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import lombok.AllArgsConstructor;
import tech.collabcode.collabhealth.model.Equipment;

@AllArgsConstructor
public class EquipmentSearchSpecification {

	private Map<String, String> parameters;
	
	public Specification<Equipment> build(){
		return (root, criteriaQuery, criteriaBuilder) -> {
			ArrayList<Predicate> predicates = new ArrayList<>();
			for(String parameterName : parameters.keySet()) {
				predicates.add(criteriaBuilder.equal(root.get(parameterName), parameters.get(parameterName)));
			}
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
	}
}
