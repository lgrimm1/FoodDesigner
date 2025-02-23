package lgrimm.fooddesigner.recipe.query.searchrecipes;

import lgrimm.fooddesigner.domain.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Component
public class SearchRecipesMapper {

	private SearchRecipesElement toSearchRecipesElement(RecipeEntity recipeEntity) {
		if (recipeEntity == null) {
			throw new IllegalArgumentException();
		}
		return new SearchRecipesElement(recipeEntity.getId(), recipeEntity.getName());
	}

	public SearchRecipesDTO toSearchRecipesDTO(List<RecipeEntity> recipeEntities, String message) {
		if (recipeEntities == null || message == null) {
			throw new IllegalArgumentException();
		}
		List<SearchRecipesElement> searchRecipesElements = recipeEntities.stream()
				.map(this::toSearchRecipesElement)
				.collect(Collectors.toList());
		return new SearchRecipesDTO(searchRecipesElements, "", message);
	}
}
