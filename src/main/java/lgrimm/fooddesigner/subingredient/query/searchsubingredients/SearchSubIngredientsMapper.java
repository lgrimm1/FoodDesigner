package lgrimm.fooddesigner.subingredient.query.searchsubingredients;

import lgrimm.fooddesigner.domain.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Component
public class SearchSubIngredientsMapper {
	private SearchSubIngredientsElement toSearchSubIngredientsElement(SubIngredientEntity subIngredientEntity) {
		if (subIngredientEntity == null) {
			throw new IllegalArgumentException();
		}
		return new SearchSubIngredientsElement(subIngredientEntity.getId(), subIngredientEntity.getName());
	}

	public SearchSubIngredientsDTO toSearchSubIngredientsDTO(List<SubIngredientEntity> subIngredientEntities, String message) {
		if (subIngredientEntities == null || message == null) {
			throw new IllegalArgumentException();
		}
		List<SearchSubIngredientsElement> subIngredientsElements = subIngredientEntities.stream()
				.map(this::toSearchSubIngredientsElement)
				.collect(Collectors.toList());
		return new SearchSubIngredientsDTO(subIngredientsElements, "", message);
	}
}
