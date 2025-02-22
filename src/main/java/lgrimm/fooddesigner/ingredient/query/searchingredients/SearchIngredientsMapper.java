package lgrimm.fooddesigner.ingredient.query.searchingredients;

import lgrimm.fooddesigner.domain.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Component
public class SearchIngredientsMapper {
	private SearchIngredientsElement toSearchIngredientsElement(IngredientEntity ingredientEntity) {
		if (ingredientEntity == null) {
			throw new IllegalArgumentException();
		}
		return new SearchIngredientsElement(ingredientEntity.getId(), ingredientEntity.getName());
	}

	public SearchIngredientsDTO toSearchIngredientsDTO(List<IngredientEntity> ingredientEntities, String message) {
		if (ingredientEntities == null || message == null) {
			throw new IllegalArgumentException();
		}
		List<SearchIngredientsElement> searchIngredientsElements = ingredientEntities.stream()
				.map(this::toSearchIngredientsElement)
				.collect(Collectors.toList());
		return new SearchIngredientsDTO(searchIngredientsElements, "", message);
	}
}
