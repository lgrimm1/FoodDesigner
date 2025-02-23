package lgrimm.fooddesigner.ingredient.query.findingredient;

import lgrimm.fooddesigner.domain.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Component
public class FindIngredientMapper {
	public FindIngredientDTO toFindIngredientDTO(IngredientEntity ingredientEntity, String message) {
		if (ingredientEntity == null || message == null) {
			throw new IllegalArgumentException();
		}
		return new FindIngredientDTO(ingredientEntity, message);
	}

	private ListIngredientsElement toListIngredientsElement(IngredientEntity ingredientEntity) {
		if (ingredientEntity == null) {
			throw new IllegalArgumentException();
		}
		return new ListIngredientsElement(ingredientEntity.getId(), ingredientEntity.getName());
	}

	public ListIngredientsDTO toListIngredientsDTO(List<IngredientEntity> ingredientEntities, String message) {
		if (ingredientEntities == null || message == null) {
			throw new IllegalArgumentException();
		}
		List<ListIngredientsElement> listRecipesElements = ingredientEntities.stream()
				.map(this::toListIngredientsElement)
				.collect(Collectors.toList());
		return new ListIngredientsDTO(listRecipesElements, message);
	}
}
