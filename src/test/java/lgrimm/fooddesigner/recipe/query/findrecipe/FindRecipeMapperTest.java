package lgrimm.fooddesigner.recipe.query.findrecipe;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FindRecipeMapperTest {

	@Test
	void toFindRecipeDTO() {
		RecipeEntity entity = new RecipeEntity(
				1L,
				"name1",
				List.of(11L, 12L),
				List.of(13, 14),
				"notes1",
				"steps1",
				13,
				14);
		String message = "message";
		FindRecipeMapper mapper = new FindRecipeMapper();

		assertThrows(IllegalArgumentException.class, () -> mapper.toFindRecipeDTO(null, message));
		assertThrows(IllegalArgumentException.class, () -> mapper.toFindRecipeDTO(entity, null));

		FindRecipeDTO findRecipeDTO = mapper.toFindRecipeDTO(entity, message);
		assertEquals(entity, findRecipeDTO.getRecipe());
		assertEquals(message, findRecipeDTO.getMessage());
	}

	@Test
	void toListRecipesDTO() {
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

		ListRecipesElement listRecipesElement1 = new ListRecipesElement(1L, "name1");
		ListRecipesElement listRecipesElement2 = new ListRecipesElement(2L, "name2");
		List<ListRecipesElement> listRecipesElements = new ArrayList<>();
		listRecipesElements.add(listRecipesElement1);
		listRecipesElements.add(listRecipesElement2);

		FindRecipeMapper mapper = new FindRecipeMapper();

		assertThrows(IllegalArgumentException.class, () -> mapper.toListRecipesDTO(null, message));
		assertThrows(IllegalArgumentException.class, () -> mapper.toListRecipesDTO(recipeEntities, null));

		ListRecipesDTO actualListRecipesDTO = mapper.toListRecipesDTO(recipeEntities, message);
		assertEquals(listRecipesElements, actualListRecipesDTO.getRecipes());
		assertEquals(message, actualListRecipesDTO.getMessage());
	}
}
