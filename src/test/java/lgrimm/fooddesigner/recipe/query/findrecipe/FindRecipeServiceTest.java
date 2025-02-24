package lgrimm.fooddesigner.recipe.query.findrecipe;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FindRecipeServiceTest {

	@Test
	void noSuchRecipe() {
		RecipeEntity emptyEntity = new RecipeEntity();
		RecipeRepository repository = Mockito.mock(RecipeRepository.class);
		when(repository.findById(6L))
				.thenReturn(Optional.empty());

		FindRecipeDTO notFoundRecipeDTO = new FindRecipeDTO(emptyEntity, "No such recipe was found.");
		FindRecipeMapper mapper = Mockito.mock(FindRecipeMapper.class);
		when(mapper.toFindRecipeDTO(emptyEntity, "No such recipe was found."))
				.thenReturn(notFoundRecipeDTO);

		FindRecipeService service = new FindRecipeService(repository, mapper);
		FindRecipeDTO actualRecipeDTO = service.findRecipe(6L);
		assertEquals(notFoundRecipeDTO, actualRecipeDTO);
	}

	@Test
	void foundRecipe() {
		RecipeEntity foundEntity = new RecipeEntity(
				1L,
				"name1",
				List.of(11L, 12L),
				List.of(13, 14),
				"notes1",
				"steps1",
				13,
				14);
		RecipeRepository repository = Mockito.mock(RecipeRepository.class);
		when(repository.findById(12L))
				.thenReturn(Optional.of(foundEntity));

		FindRecipeDTO foundRecipeDTO = new FindRecipeDTO(foundEntity, "");
		FindRecipeMapper mapper = Mockito.mock(FindRecipeMapper.class);
		when(mapper.toFindRecipeDTO(foundEntity, ""))
				.thenReturn(foundRecipeDTO);

		FindRecipeService service = new FindRecipeService(repository, mapper);
		FindRecipeDTO actualDTO = service.findRecipe(12L);
		assertEquals(foundRecipeDTO, actualDTO);
	}

	@Test
	void listRecipes() {
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
		String message = "message";

		List<RecipeEntity> recipeEntities = new ArrayList<>();
		recipeEntities.add(recipeEntity1);
		recipeEntities.add(recipeEntity2);
		RecipeRepository repository = Mockito.mock(RecipeRepository.class);
		when(repository.findAll())
				.thenReturn(recipeEntities);

		ListRecipesElement listRecipesElement1 = new ListRecipesElement(1L, "name1");
		ListRecipesElement listRecipesElement2 = new ListRecipesElement(2L, "name2");
		List<ListRecipesElement> listRecipesElements = new ArrayList<>();
		listRecipesElements.add(listRecipesElement1);
		listRecipesElements.add(listRecipesElement2);
		ListRecipesDTO listRecipesDTO = new ListRecipesDTO(listRecipesElements, message);
		FindRecipeMapper mapper = Mockito.mock(FindRecipeMapper.class);
		when(mapper.toListRecipesDTO(recipeEntities, message))
				.thenReturn(listRecipesDTO);

		FindRecipeService service = new FindRecipeService(repository, mapper);
		ListRecipesDTO actualListRecipesDTO1 = service.listRecipes(message);
		assertEquals(listRecipesElements, actualListRecipesDTO1.getRecipes());
		assertEquals(message, actualListRecipesDTO1.getMessage());
	}
}