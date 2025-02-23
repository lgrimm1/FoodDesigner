package lgrimm.fooddesigner.subingredient.query.findsubingredient;

import lgrimm.fooddesigner.domain.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Component
public class FindSubIngredientMapper {
	public FindSubIngredientDTO toFindSubIngredientDTO(SubIngredientEntity subIngredientEntity, String message) {
		if (subIngredientEntity == null || message == null) {
			throw new IllegalArgumentException();
		}
		return new FindSubIngredientDTO(subIngredientEntity, message);
	}

	private ListSubIngredientsElement toListSubIngredientsElement(SubIngredientEntity subIngredientEntity) {
		if (subIngredientEntity == null) {
			throw new IllegalArgumentException();
		}
		return new ListSubIngredientsElement(subIngredientEntity.getId(), subIngredientEntity.getName());
	}

	public ListSubIngredientsDTO toListSubIngredientsDTO(List<SubIngredientEntity> subIngredientEntities, String message) {
		if (subIngredientEntities == null || message == null) {
			throw new IllegalArgumentException();
		}
		List<ListSubIngredientsElement> listRecipesElements = subIngredientEntities.stream()
				.map(this::toListSubIngredientsElement)
				.collect(Collectors.toList());
		return new ListSubIngredientsDTO(listRecipesElements, message);
	}
}
