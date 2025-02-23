package lgrimm.fooddesigner.recipe.query.searchrecipes;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class SearchRecipesServiceTest {

	@Test
	void searchRecipesNullArgument() {
		SearchRecipesMapper mapper = Mockito.mock(SearchRecipesMapper.class);
		RecipeRepository repository = Mockito.mock(RecipeRepository.class);
		SearchRecipesService service = new SearchRecipesService(repository, mapper);

		assertThrows(IllegalArgumentException.class, () -> service.searchRecipes(null));
	}

	@Test
	void searchRecipesBlankArgument() {
		String text = "  ";

		SearchRecipesMapper mapper = Mockito.mock(SearchRecipesMapper.class);
		RecipeRepository repository = Mockito.mock(RecipeRepository.class);
		SearchRecipesService service = new SearchRecipesService(repository, mapper);

		SearchRecipesDTO searchRecipesDTO = service.searchRecipes(text);
		assertEquals("No text were given.", searchRecipesDTO.getMessage());
		assertTrue(searchRecipesDTO.getRecipes().isEmpty());
		assertTrue(searchRecipesDTO.getSearchText().isEmpty());
	}

	@Test
	void searchRecipesNoMatch() {
		RecipeRepository repository = Mockito.mock(RecipeRepository.class);
		when(repository.findAllByName("name"))
				.thenReturn(new ArrayList<RecipeEntity>());

		SearchRecipesDTO searchRecipesDTO = new SearchRecipesDTO(new ArrayList<SearchRecipesElement>(), "", "Found 0 occurrence(s).");
		SearchRecipesMapper mapper = Mockito.mock(SearchRecipesMapper.class);
		when(mapper.toSearchRecipesDTO(new ArrayList<RecipeEntity>(), "Found 0 occurrence(s)."))
				.thenReturn(searchRecipesDTO);

		SearchRecipesService service = new SearchRecipesService(repository, mapper);
		SearchRecipesDTO actualSearchRecipesDTO = service.searchRecipes("name");
		assertEquals(new ArrayList<SearchRecipesElement>(), actualSearchRecipesDTO.getRecipes());
		assertEquals("Found 0 occurrence(s).", actualSearchRecipesDTO.getMessage());
		assertTrue(actualSearchRecipesDTO.getSearchText().isEmpty());
	}

	@Test
	void searchRecipesOneWord() {
		RecipeEntity recipeEntity1 = new RecipeEntity(1L, "name", List.of(11L, 12L), List.of(13, 14), "notes1", "step1", 15, 16);
		RecipeEntity recipeEntity2 = new RecipeEntity(2L, "name", List.of(21L, 22L), List.of(23, 24), "notes2", "step2", 25, 26);
		List<RecipeEntity> recipeEntities = new ArrayList<>();
		recipeEntities.add(recipeEntity1);
		recipeEntities.add(recipeEntity2);
		RecipeRepository repository = Mockito.mock(RecipeRepository.class);
		when(repository.findAllByName("name"))
				.thenReturn(recipeEntities);
		when(repository.findAllById(new HashSet<>(List.of(1L, 2L))))
				.thenReturn(recipeEntities);

		SearchRecipesElement searchRecipesElement1 = new SearchRecipesElement(1L, "name");
		SearchRecipesElement searchRecipesElement2 = new SearchRecipesElement(2L, "name");
		List<SearchRecipesElement> searchRecipesElements = new ArrayList<>();
		searchRecipesElements.add(searchRecipesElement1);
		searchRecipesElements.add(searchRecipesElement2);
		SearchRecipesDTO searchRecipesDTO = new SearchRecipesDTO(searchRecipesElements, "", "Found 2 occurrence(s).");
		SearchRecipesMapper mapper = Mockito.mock(SearchRecipesMapper.class);
		when(mapper.toSearchRecipesDTO(recipeEntities, "Found 2 occurrence(s)."))
				.thenReturn(searchRecipesDTO);

		SearchRecipesService service = new SearchRecipesService(repository, mapper);
		SearchRecipesDTO actualSearchRecipesDTO = service.searchRecipes("name");
		assertEquals(searchRecipesDTO.getRecipes(), actualSearchRecipesDTO.getRecipes());
		assertEquals("Found 2 occurrence(s).", actualSearchRecipesDTO.getMessage());
		assertTrue(actualSearchRecipesDTO.getSearchText().isEmpty());
	}

	@Test
	void searchRecipesMoreWordsWithMoreSpacesBetween() {
		RecipeEntity recipeEntity1 = new RecipeEntity(1L, "name", List.of(11L, 12L), List.of(13, 14), "notes1", "step1", 15, 16);
		RecipeEntity recipeEntity2 = new RecipeEntity(2L, "name", List.of(21L, 22L), List.of(23, 24), "notes2", "step2", 25, 26);
		RecipeEntity recipeEntity3 = new RecipeEntity(3L, "xyz", List.of(31L, 32L), List.of(33, 34), "notes3", "step3", 35, 36);
		RecipeEntity recipeEntity4 = new RecipeEntity(4L, "name   xyz", List.of(41L, 42L), List.of(43, 44), "notes4", "step4", 45, 46);
		List<RecipeEntity> recipeEntities = new ArrayList<>();
		recipeEntities.add(recipeEntity1);
		recipeEntities.add(recipeEntity2);
		recipeEntities.add(recipeEntity3);
		recipeEntities.add(recipeEntity4);
		RecipeRepository repository = Mockito.mock(RecipeRepository.class);
		when(repository.findAllByName("name   xyz"))
				.thenReturn(recipeEntities.subList(3, 4));
		when(repository.findAllByName("name"))
				.thenReturn(recipeEntities.subList(0, 2));
		when(repository.findAllByName("xyz"))
				.thenReturn(recipeEntities.subList(2, 3));
		when(repository.findAllById(new HashSet<>(Set.of(4L, 1L, 2L, 3L))))
				.thenReturn(recipeEntities);

		SearchRecipesElement searchRecipesElement1 = new SearchRecipesElement(4L, "name   xyz");
		SearchRecipesElement searchRecipesElement2 = new SearchRecipesElement(1L, "name");
		SearchRecipesElement searchRecipesElement3 = new SearchRecipesElement(2L, "name");
		SearchRecipesElement searchRecipesElement4 = new SearchRecipesElement(3L, "xyz");
		List<SearchRecipesElement> searchRecipesElements = new ArrayList<>();
		searchRecipesElements.add(searchRecipesElement1);
		searchRecipesElements.add(searchRecipesElement2);
		searchRecipesElements.add(searchRecipesElement3);
		searchRecipesElements.add(searchRecipesElement4);
		SearchRecipesDTO searchRecipesDTO = new SearchRecipesDTO(searchRecipesElements, "", "Found 4 occurrence(s).");
		SearchRecipesMapper mapper = Mockito.mock(SearchRecipesMapper.class);
		when(mapper.toSearchRecipesDTO(recipeEntities, "Found 4 occurrence(s)."))
				.thenReturn(searchRecipesDTO);

		SearchRecipesService service = new SearchRecipesService(repository, mapper);
		SearchRecipesDTO actualSearchRecipesDTO = service.searchRecipes("name   xyz");
		assertEquals(searchRecipesDTO.getRecipes(), actualSearchRecipesDTO.getRecipes());
		assertEquals("Found 4 occurrence(s).", actualSearchRecipesDTO.getMessage());
		assertTrue(actualSearchRecipesDTO.getSearchText().isEmpty());
	}

	@Test
	void listRecipes() {
		RecipeEntity recipeEntity1 = new RecipeEntity(1L, "name1", List.of(11L, 12L), List.of(13, 14), "notes1", "step1", 15, 16);
		RecipeEntity recipeEntity2 = new RecipeEntity(2L, "name2", List.of(21L, 22L), List.of(23, 24), "notes2", "step2", 25, 26);
		List<RecipeEntity> recipeEntities = new ArrayList<>();
		recipeEntities.add(recipeEntity1);
		recipeEntities.add(recipeEntity2);
		RecipeRepository repository = Mockito.mock(RecipeRepository.class);
		when(repository.findAll())
				.thenReturn(recipeEntities);

		SearchRecipesElement searchRecipesElement1 = new SearchRecipesElement(1L, "name1");
		SearchRecipesElement searchRecipesElement2 = new SearchRecipesElement(2L, "name2");
		List<SearchRecipesElement> searchRecipesElements = new ArrayList<>();
		searchRecipesElements.add(searchRecipesElement1);
		searchRecipesElements.add(searchRecipesElement2);
		SearchRecipesDTO searchRecipesDTO = new SearchRecipesDTO(searchRecipesElements, "", "Something went wrong, returned full list.");
		SearchRecipesMapper mapper = Mockito.mock(SearchRecipesMapper.class);
		when(mapper.toSearchRecipesDTO(recipeEntities, "Something went wrong, returned full list."))
				.thenReturn(searchRecipesDTO);

		SearchRecipesService service = new SearchRecipesService(repository, mapper);
		SearchRecipesDTO actualSearchRecipesDTO = service.listRecipes();
		assertEquals(searchRecipesDTO.getRecipes(), actualSearchRecipesDTO.getRecipes());
		assertEquals("Something went wrong, returned full list.", actualSearchRecipesDTO.getMessage());
		assertTrue(actualSearchRecipesDTO.getSearchText().isEmpty());
	}
}