package lgrimm.fooddesigner.recipe.query.searchrecipes;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SearchRecipesMapperTest {

	@Test
	void toSearchRecipesDTO() {
		RecipeEntity recipeEntity1 = new RecipeEntity(
				1L,
				"name1",
				List.of(11L, 12L),
				List.of(13, 14),
				"notes1",
				"steps1",
				13,
				14);
		RecipeEntity recipeEntity2 = new RecipeEntity(
				2L,
				"name2",
				List.of(21L, 22L),
				List.of(23, 24),
				"notes2",
				"steps2",
				23,
				24);
		List<RecipeEntity> recipeEntities = new ArrayList<>();
		recipeEntities.add(recipeEntity1);
		recipeEntities.add(recipeEntity2);
		String message = "message";

		SearchRecipesElement searchRecipesElement1 = new SearchRecipesElement(1L, "name1");
		SearchRecipesElement searchRecipesElement2 = new SearchRecipesElement(2L, "name2");
		List<SearchRecipesElement> searchRecipesElements = new ArrayList<>();
		searchRecipesElements.add(searchRecipesElement1);
		searchRecipesElements.add(searchRecipesElement2);

		SearchRecipesMapper mapper = new SearchRecipesMapper();

		assertThrows(IllegalArgumentException.class, () -> mapper.toSearchRecipesDTO(null, message));
		assertThrows(IllegalArgumentException.class, () -> mapper.toSearchRecipesDTO(recipeEntities, null));

		SearchRecipesDTO actualSearchRecipesDTO = mapper.toSearchRecipesDTO(recipeEntities, message);
		assertEquals(searchRecipesElements, actualSearchRecipesDTO.getRecipes());
		assertTrue(actualSearchRecipesDTO.getSearchText().isEmpty());
		assertEquals(message, actualSearchRecipesDTO.getMessage());
	}
}