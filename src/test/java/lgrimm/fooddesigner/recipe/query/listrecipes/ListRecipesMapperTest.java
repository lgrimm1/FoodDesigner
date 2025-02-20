package lgrimm.fooddesigner.recipe.query.listrecipes;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ListRecipesMapperTest {

	@Test
	void toListRecipesDTO() {
		RecipeEntity recipeEntity1 = new RecipeEntity(
				1L,
				"name1",
				List.of(11L, 12L),
				List.of(13, 14),
				"notes1",
				"steps1",
				15,
				16);
		RecipeEntity recipeEntity2 = new RecipeEntity(
				2L,
				"name2",
				List.of(21L, 22L),
				List.of(23, 24),
				"notes2",
				"steps2",
				25,
				26);
		List<RecipeEntity> recipeEntities = new ArrayList<>();
		recipeEntities.add(recipeEntity1);
		recipeEntities.add(recipeEntity2);

		ListRecipesElement listRecipesElement1 = new ListRecipesElement(1L, "name1");
		ListRecipesElement listRecipesElement2 = new ListRecipesElement(2L, "name2");
		List<ListRecipesElement> listRecipesElements = new ArrayList<>();
		listRecipesElements.add(listRecipesElement1);
		listRecipesElements.add(listRecipesElement2);

		ListRecipesMapper mapper = new ListRecipesMapper();

		assertThrows(IllegalArgumentException.class, () -> mapper.toListRecipesDTO(null));

		ListRecipesDTO actualListRecipesDTO = mapper.toListRecipesDTO(recipeEntities);
		assertEquals(listRecipesElements, actualListRecipesDTO.getRecipes());
		assertTrue(actualListRecipesDTO.getSearchText().isEmpty());
		assertTrue(actualListRecipesDTO.getMessage().isEmpty());
	}
}