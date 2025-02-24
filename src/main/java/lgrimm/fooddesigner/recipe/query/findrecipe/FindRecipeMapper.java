package lgrimm.fooddesigner.recipe.query.findrecipe;

import lgrimm.fooddesigner.domain.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Component
public class FindRecipeMapper {
	public FindRecipeDTO toFindRecipeDTO(RecipeEntity recipeEntity, String message) {
		if (recipeEntity == null || message == null) {
			throw new IllegalArgumentException();
		}
		return new FindRecipeDTO(recipeEntity, message);
	}

	private ListRecipesElement toListRecipesElement(RecipeEntity recipeEntity) {
		if (recipeEntity == null) {
			throw new IllegalArgumentException();
		}
		return new ListRecipesElement(recipeEntity.getId(), recipeEntity.getName());
	}

	public ListRecipesDTO toListRecipesDTO(List<RecipeEntity> recipeEntities, String message) {
		if (recipeEntities == null || message == null) {
			throw new IllegalArgumentException();
		}
		List<ListRecipesElement> listRecipesElements = recipeEntities.stream()
				.map(this::toListRecipesElement)
				.collect(Collectors.toList());
		return new ListRecipesDTO(listRecipesElements, message);
	}
}
