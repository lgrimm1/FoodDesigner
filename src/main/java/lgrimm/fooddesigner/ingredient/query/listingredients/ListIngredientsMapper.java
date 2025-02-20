package lgrimm.fooddesigner.ingredient.query.listingredients;

import lgrimm.fooddesigner.domain.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Component
public class ListIngredientsMapper {
	private ListIngredientsElement toListIngredientElement(IngredientEntity ingredientEntity) {
		if (ingredientEntity == null) {
			throw new IllegalArgumentException();
		}
		return new ListIngredientsElement(ingredientEntity.getId(), ingredientEntity.getName());
	}

	public ListIngredientsDTO toListIngredientsDTO(List<IngredientEntity> ingredientEntities) {
		if (ingredientEntities == null) {
			throw new IllegalArgumentException();
		}
		List<ListIngredientsElement> listIngredientsElements = ingredientEntities.stream()
				.map(this::toListIngredientElement)
				.collect(Collectors.toList());
		return new ListIngredientsDTO(listIngredientsElements, "", "");
	}
}
