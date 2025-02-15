package lgrimm.fooddesigner.subingredient.query.listsubingredients;

import java.util.*;
import java.util.stream.*;

import lgrimm.fooddesigner.domain.*;
import org.springframework.stereotype.*;

@Component
public class ListSubIngredientsMapper {

	private ListSubIngredientsElement toListSubIngredientElement(SubIngredientEntity subIngredientEntity) {
		if (subIngredientEntity == null) {
			throw new IllegalArgumentException();
		}
		return new ListSubIngredientsElement(subIngredientEntity.getId(), subIngredientEntity.getName());
	}

	public ListSubIngredientsDTO toListSubIngredientsDTO(List<SubIngredientEntity> subIngredientEntities) {
		if (subIngredientEntities == null) {
			throw new IllegalArgumentException();
		}
		List<ListSubIngredientsElement> listSubIngredientsElements = subIngredientEntities.stream()
				.map(this::toListSubIngredientElement)
				.collect(Collectors.toList());
		return new ListSubIngredientsDTO(listSubIngredientsElements, "", "");
	}
}
