package lgrimm.fooddesigner.recipe.query.listrecipes;

import lgrimm.fooddesigner.domain.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Component
public class ListRecipesMapper {

	private ListRecipesElement toListRecipesElement(RecipeEntity recipeEntity) {
		if (recipeEntity == null) {
			throw new IllegalArgumentException();
		}
		return new ListRecipesElement(recipeEntity.getId(), recipeEntity.getName());
	}

	public ListRecipesDTO toListRecipesDTO(List<RecipeEntity> recipeEntities) {
		if (recipeEntities == null) {
			throw new IllegalArgumentException();
		}
		List<ListRecipesElement> listRecipesElements = recipeEntities.stream()
				.map(this::toListRecipesElement)
				.collect(Collectors.toList());
		return new ListRecipesDTO(listRecipesElements, "", "");
	}
}
