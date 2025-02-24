package lgrimm.fooddesigner.ingredient.query.searchingredients;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class SearchIngredientsServiceTest {

	IngredientEntity entity1;
	IngredientEntity entity2;
	IngredientEntity entity3;
	IngredientEntity entity4;
	IngredientEntity entity5;
	IngredientEntity entity6;

	@BeforeEach
	void setFields() {
		entity1 = new IngredientEntity(
				1L,
				"name",
				List.of(1L, 2L),
				"extraAllergens1",
				12.3D,
				11,
				12,
				31.1D,
				41.4D,
				51.5D,
				61.6D,
				71.7D,
				81.8D,
				91.9D,
				3L,
				"productName1",
				"productManufacturer1",
				"productDescription1",
				4,
				101.1D,
				111.1D);
		entity2 = new IngredientEntity(
				2L,
				"name",
				List.of(2L, 2L),
				"extraAllergens2",
				22.3D,
				22,
				22,
				32.2D,
				42.4D,
				52.5D,
				62.6D,
				72.7D,
				82.8D,
				92.9D,
				3L,
				"productName2",
				"productManufacturer2",
				"productDescription2",
				4,
				102.2D,
				112.2D);
		entity3 = new IngredientEntity(
				3L,
				"xyz",
				List.of(3L, 3L),
				"extraAllergens3",
				12.3D,
				11,
				12,
				31.1D,
				41.4D,
				51.5D,
				61.6D,
				71.7D,
				81.8D,
				91.9D,
				3L,
				"productName1",
				"productManufacturer1",
				"productDescription1",
				4,
				101.1D,
				111.1D);
		entity4 = new IngredientEntity(
				4L,
				"name   xyz",
				List.of(2L, 2L),
				"extraAllergens4",
				22.3D,
				22,
				22,
				32.2D,
				42.4D,
				52.5D,
				62.6D,
				72.7D,
				82.8D,
				92.9D,
				3L,
				"productName2",
				"productManufacturer2",
				"productDescription2",
				4,
				102.2D,
				112.2D);
		entity5 = new IngredientEntity(
				1L,
				"name1",
				List.of(1L, 2L),
				"extraAllergens1",
				12.3D,
				11,
				12,
				31.1D,
				41.4D,
				51.5D,
				61.6D,
				71.7D,
				81.8D,
				91.9D,
				3L,
				"productName1",
				"productManufacturer1",
				"productDescription1",
				4,
				101.1D,
				111.1D);
		entity6 = new IngredientEntity(
				2L,
				"name2",
				List.of(2L, 2L),
				"extraAllergens2",
				22.3D,
				22,
				22,
				32.2D,
				42.4D,
				52.5D,
				62.6D,
				72.7D,
				82.8D,
				92.9D,
				3L,
				"productName2",
				"productManufacturer2",
				"productDescription2",
				4,
				102.2D,
				112.2D);
	}

	@Test
	void searchIngredientsNullArgument() {
		SearchIngredientsMapper mapper = Mockito.mock(SearchIngredientsMapper.class);
		IngredientRepository repository = Mockito.mock(IngredientRepository.class);
		SearchIngredientsService service = new SearchIngredientsService(repository, mapper);

		assertThrows(IllegalArgumentException.class, () -> service.searchIngredients(null));
	}

	@Test
	void searchIngredientsBlankArgument() {
		String text = "  ";

		SearchIngredientsMapper mapper = Mockito.mock(SearchIngredientsMapper.class);
		IngredientRepository repository = Mockito.mock(IngredientRepository.class);
		SearchIngredientsService service = new SearchIngredientsService(repository, mapper);

		SearchIngredientsDTO searchIngredientsDTO = service.searchIngredients(text);
		assertEquals("No text were given.", searchIngredientsDTO.getMessage());
		assertTrue(searchIngredientsDTO.getIngredients().isEmpty());
		assertTrue(searchIngredientsDTO.getSearchText().isEmpty());
	}

	@Test
	void searchIngredientsNoMatch() {
		IngredientRepository repository = Mockito.mock(IngredientRepository.class);
		when(repository.findAllByName("name"))
				.thenReturn(new ArrayList<>());

		SearchIngredientsDTO searchIngredientsDTO = new SearchIngredientsDTO(new ArrayList<>(), "", "Found 0 occurrence(s).");
		SearchIngredientsMapper mapper = Mockito.mock(SearchIngredientsMapper.class);
		when(mapper.toSearchIngredientsDTO(new ArrayList<>(), "Found 0 occurrence(s)."))
				.thenReturn(searchIngredientsDTO);

		SearchIngredientsService service = new SearchIngredientsService(repository, mapper);
		SearchIngredientsDTO actualSearchIngredientsDTO = service.searchIngredients("name");
		assertEquals(new ArrayList<SearchIngredientsElement>(), actualSearchIngredientsDTO.getIngredients());
		assertEquals("Found 0 occurrence(s).", actualSearchIngredientsDTO.getMessage());
		assertTrue(actualSearchIngredientsDTO.getSearchText().isEmpty());
	}

	@Test
	void searchIngredientsOneWord() {
		List<IngredientEntity> ingredientEntities = new ArrayList<>();
		ingredientEntities.add(entity1);
		ingredientEntities.add(entity2);
		IngredientRepository repository = Mockito.mock(IngredientRepository.class);
		when(repository.findAllByName("name"))
				.thenReturn(ingredientEntities);
		when(repository.findAllById(new HashSet<>(List.of(1L, 2L))))
				.thenReturn(ingredientEntities);

		SearchIngredientsElement searchIngredientsElement1 = new SearchIngredientsElement(1L, "name");
		SearchIngredientsElement searchIngredientsElement2 = new SearchIngredientsElement(2L, "name");
		List<SearchIngredientsElement> searchIngredientsElements = new ArrayList<>();
		searchIngredientsElements.add(searchIngredientsElement1);
		searchIngredientsElements.add(searchIngredientsElement2);
		SearchIngredientsDTO searchIngredientsDTO = new SearchIngredientsDTO(searchIngredientsElements, "", "Found 2 occurrence(s).");
		SearchIngredientsMapper mapper = Mockito.mock(SearchIngredientsMapper.class);
		when(mapper.toSearchIngredientsDTO(ingredientEntities, "Found 2 occurrence(s)."))
				.thenReturn(searchIngredientsDTO);

		SearchIngredientsService service = new SearchIngredientsService(repository, mapper);
		SearchIngredientsDTO actualSearchIngredientsDTO = service.searchIngredients("name");
		assertEquals(searchIngredientsDTO.getIngredients(), actualSearchIngredientsDTO.getIngredients());
		assertEquals("Found 2 occurrence(s).", actualSearchIngredientsDTO.getMessage());
		assertTrue(actualSearchIngredientsDTO.getSearchText().isEmpty());
	}

	@Test
	void searchIngredientsMoreWordsWithMoreSpacesBetween() {
		List<IngredientEntity> ingredientEntities = new ArrayList<>();
		ingredientEntities.add(entity1);
		ingredientEntities.add(entity2);
		ingredientEntities.add(entity3);
		ingredientEntities.add(entity4);
		IngredientRepository repository = Mockito.mock(IngredientRepository.class);
		when(repository.findAllByName("name   xyz"))
				.thenReturn(ingredientEntities.subList(3, 4));
		when(repository.findAllByName("name"))
				.thenReturn(ingredientEntities.subList(0, 2));
		when(repository.findAllByName("xyz"))
				.thenReturn(ingredientEntities.subList(2, 3));
		when(repository.findAllById(new HashSet<>(Set.of(4L, 1L, 2L, 3L))))
				.thenReturn(ingredientEntities);

		SearchIngredientsElement searchIngredientsElement1 = new SearchIngredientsElement(4L, "name   xyz");
		SearchIngredientsElement searchIngredientsElement2 = new SearchIngredientsElement(1L, "name");
		SearchIngredientsElement searchIngredientsElement3 = new SearchIngredientsElement(2L, "name");
		SearchIngredientsElement searchIngredientsElement4 = new SearchIngredientsElement(3L, "xyz");
		List<SearchIngredientsElement> searchIngredientsElements = new ArrayList<>();
		searchIngredientsElements.add(searchIngredientsElement1);
		searchIngredientsElements.add(searchIngredientsElement2);
		searchIngredientsElements.add(searchIngredientsElement3);
		searchIngredientsElements.add(searchIngredientsElement4);
		SearchIngredientsDTO searchIngredientsDTO = new SearchIngredientsDTO(searchIngredientsElements, "", "Found 4 occurrence(s).");
		SearchIngredientsMapper mapper = Mockito.mock(SearchIngredientsMapper.class);
		when(mapper.toSearchIngredientsDTO(ingredientEntities, "Found 4 occurrence(s)."))
				.thenReturn(searchIngredientsDTO);

		SearchIngredientsService service = new SearchIngredientsService(repository, mapper);
		SearchIngredientsDTO actualSearchIngredientsDTO = service.searchIngredients("name   xyz");
		assertEquals(searchIngredientsDTO.getIngredients(), actualSearchIngredientsDTO.getIngredients());
		assertEquals("Found 4 occurrence(s).", actualSearchIngredientsDTO.getMessage());
		assertTrue(actualSearchIngredientsDTO.getSearchText().isEmpty());
	}

	@Test
	void listIngredients() {
		List<IngredientEntity> ingredientEntities = new ArrayList<>();
		ingredientEntities.add(entity5);
		ingredientEntities.add(entity6);
		IngredientRepository repository = Mockito.mock(IngredientRepository.class);
		when(repository.findAll())
				.thenReturn(ingredientEntities);

		SearchIngredientsElement searchIngredientsElement1 = new SearchIngredientsElement(1L, "name1");
		SearchIngredientsElement searchIngredientsElement2 = new SearchIngredientsElement(2L, "name2");
		List<SearchIngredientsElement> searchIngredientsElements = new ArrayList<>();
		searchIngredientsElements.add(searchIngredientsElement1);
		searchIngredientsElements.add(searchIngredientsElement2);
		SearchIngredientsDTO searchIngredientsDTO = new SearchIngredientsDTO(searchIngredientsElements, "", "Something went wrong, returned full list.");
		SearchIngredientsMapper mapper = Mockito.mock(SearchIngredientsMapper.class);
		when(mapper.toSearchIngredientsDTO(ingredientEntities, "Something went wrong, returned full list."))
				.thenReturn(searchIngredientsDTO);

		SearchIngredientsService service = new SearchIngredientsService(repository, mapper);
		SearchIngredientsDTO actualSearchIngredientsDTO = service.listIngredients();
		assertEquals(searchIngredientsDTO.getIngredients(), actualSearchIngredientsDTO.getIngredients());
		assertEquals("Something went wrong, returned full list.", actualSearchIngredientsDTO.getMessage());
		assertTrue(actualSearchIngredientsDTO.getSearchText().isEmpty());
	}
}