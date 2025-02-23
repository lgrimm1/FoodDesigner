package lgrimm.fooddesigner.subingredient.query.searchsubingredients;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class SearchSubIngredientsServiceTest {

	@Test
	void searchSubIngredientsNullArgument() {
		SearchSubIngredientsMapper mapper = Mockito.mock(SearchSubIngredientsMapper.class);
		SubIngredientRepository repository = Mockito.mock(SubIngredientRepository.class);
		SearchSubIngredientsService service = new SearchSubIngredientsService(repository, mapper);

		assertThrows(IllegalArgumentException.class, () -> service.searchSubIngredients(null));
	}

	@Test
	void searchSubIngredientsBlankArgument() {
		String text = "  ";

		SearchSubIngredientsMapper mapper = Mockito.mock(SearchSubIngredientsMapper.class);
		SubIngredientRepository repository = Mockito.mock(SubIngredientRepository.class);
		SearchSubIngredientsService service = new SearchSubIngredientsService(repository, mapper);

		SearchSubIngredientsDTO searchSubIngredientsDTO = service.searchSubIngredients(text);
		assertEquals("No text were given.", searchSubIngredientsDTO.getMessage());
		assertTrue(searchSubIngredientsDTO.getSubIngredients().isEmpty());
		assertTrue(searchSubIngredientsDTO.getSearchText().isEmpty());
	}

	@Test
	void searchSubIngredientsNoMatch() {
		SubIngredientRepository repository = Mockito.mock(SubIngredientRepository.class);
		when(repository.findAllByName("name"))
				.thenReturn(new ArrayList<SubIngredientEntity>());

		SearchSubIngredientsDTO searchSubIngredientsDTO = new SearchSubIngredientsDTO(new ArrayList<SearchSubIngredientsElement>(), "", "Found 0 occurrence(s).");
		SearchSubIngredientsMapper mapper = Mockito.mock(SearchSubIngredientsMapper.class);
		when(mapper.toSearchSubIngredientsDTO(new ArrayList<SubIngredientEntity>(), "Found 0 occurrence(s)."))
				.thenReturn(searchSubIngredientsDTO);

		SearchSubIngredientsService service = new SearchSubIngredientsService(repository, mapper);
		SearchSubIngredientsDTO actualSearchSubIngredientsDTO = service.searchSubIngredients("name");
		assertEquals(new ArrayList<SearchSubIngredientsElement>(), actualSearchSubIngredientsDTO.getSubIngredients());
		assertEquals("Found 0 occurrence(s).", actualSearchSubIngredientsDTO.getMessage());
		assertTrue(actualSearchSubIngredientsDTO.getSearchText().isEmpty());
	}

	@Test
	void searchSubIngredientsOneWord() {
		SubIngredientEntity subIngredientEntity1 = new SubIngredientEntity(1L, "name", "allergen1");
		SubIngredientEntity subIngredientEntity2 = new SubIngredientEntity(2L, "name", "allergen2");
		List<SubIngredientEntity> subIngredientEntities = new ArrayList<>();
		subIngredientEntities.add(subIngredientEntity1);
		subIngredientEntities.add(subIngredientEntity2);
		SubIngredientRepository repository = Mockito.mock(SubIngredientRepository.class);
		when(repository.findAllByName("name"))
				.thenReturn(subIngredientEntities);
		when(repository.findAllById(new HashSet<>(List.of(1L, 2L))))
				.thenReturn(subIngredientEntities);

		SearchSubIngredientsElement searchSubIngredientsElement1 = new SearchSubIngredientsElement(1L, "name");
		SearchSubIngredientsElement searchSubIngredientsElement2 = new SearchSubIngredientsElement(2L, "name");
		List<SearchSubIngredientsElement> searchSubIngredientsElements = new ArrayList<>();
		searchSubIngredientsElements.add(searchSubIngredientsElement1);
		searchSubIngredientsElements.add(searchSubIngredientsElement2);
		SearchSubIngredientsDTO searchSubIngredientsDTO = new SearchSubIngredientsDTO(searchSubIngredientsElements, "", "Found 2 occurrence(s).");
		SearchSubIngredientsMapper mapper = Mockito.mock(SearchSubIngredientsMapper.class);
		when(mapper.toSearchSubIngredientsDTO(subIngredientEntities, "Found 2 occurrence(s)."))
				.thenReturn(searchSubIngredientsDTO);

		SearchSubIngredientsService service = new SearchSubIngredientsService(repository, mapper);
		SearchSubIngredientsDTO actualSearchSubIngredientsDTO = service.searchSubIngredients("name");
		assertEquals(searchSubIngredientsDTO.getSubIngredients(), actualSearchSubIngredientsDTO.getSubIngredients());
		assertEquals("Found 2 occurrence(s).", actualSearchSubIngredientsDTO.getMessage());
		assertTrue(actualSearchSubIngredientsDTO.getSearchText().isEmpty());
	}

	@Test
	void searchSubIngredientsMoreWordsWithMoreSpacesBetween() {
		SubIngredientEntity subIngredientEntity1 = new SubIngredientEntity(1L, "name", "allergen1");
		SubIngredientEntity subIngredientEntity2 = new SubIngredientEntity(2L, "name", "allergen2");
		SubIngredientEntity subIngredientEntity3 = new SubIngredientEntity(3L, "xyz", "allergen3");
		SubIngredientEntity subIngredientEntity4 = new SubIngredientEntity(4L, "name   xyz", "allergen4");
		List<SubIngredientEntity> subIngredientEntities = new ArrayList<>();
		subIngredientEntities.add(subIngredientEntity1);
		subIngredientEntities.add(subIngredientEntity2);
		subIngredientEntities.add(subIngredientEntity3);
		subIngredientEntities.add(subIngredientEntity4);
		SubIngredientRepository repository = Mockito.mock(SubIngredientRepository.class);
		when(repository.findAllByName("name   xyz"))
				.thenReturn(subIngredientEntities.subList(3, 4));
		when(repository.findAllByName("name"))
				.thenReturn(subIngredientEntities.subList(0, 2));
		when(repository.findAllByName("xyz"))
				.thenReturn(subIngredientEntities.subList(2, 3));
		when(repository.findAllById(new HashSet<>(Set.of(4L, 1L, 2L, 3L))))
				.thenReturn(subIngredientEntities);

		SearchSubIngredientsElement searchSubIngredientsElement1 = new SearchSubIngredientsElement(4L, "name   xyz");
		SearchSubIngredientsElement searchSubIngredientsElement2 = new SearchSubIngredientsElement(1L, "name");
		SearchSubIngredientsElement searchSubIngredientsElement3 = new SearchSubIngredientsElement(2L, "name");
		SearchSubIngredientsElement searchSubIngredientsElement4 = new SearchSubIngredientsElement(3L, "xyz");
		List<SearchSubIngredientsElement> searchSubIngredientsElements = new ArrayList<>();
		searchSubIngredientsElements.add(searchSubIngredientsElement1);
		searchSubIngredientsElements.add(searchSubIngredientsElement2);
		searchSubIngredientsElements.add(searchSubIngredientsElement3);
		searchSubIngredientsElements.add(searchSubIngredientsElement4);
		SearchSubIngredientsDTO searchSubIngredientsDTO = new SearchSubIngredientsDTO(searchSubIngredientsElements, "", "Found 4 occurrence(s).");
		SearchSubIngredientsMapper mapper = Mockito.mock(SearchSubIngredientsMapper.class);
		when(mapper.toSearchSubIngredientsDTO(subIngredientEntities, "Found 4 occurrence(s)."))
				.thenReturn(searchSubIngredientsDTO);

		SearchSubIngredientsService service = new SearchSubIngredientsService(repository, mapper);
		SearchSubIngredientsDTO actualSearchSubIngredientsDTO = service.searchSubIngredients("name   xyz");
		assertEquals(searchSubIngredientsDTO.getSubIngredients(), actualSearchSubIngredientsDTO.getSubIngredients());
		assertEquals("Found 4 occurrence(s).", actualSearchSubIngredientsDTO.getMessage());
		assertTrue(actualSearchSubIngredientsDTO.getSearchText().isEmpty());
	}

	@Test
	void listSubIngredients() {
		SubIngredientEntity subIngredientEntity1 = new SubIngredientEntity(1L, "name1", "allergen1");
		SubIngredientEntity subIngredientEntity2 = new SubIngredientEntity(2L, "name2", "allergen2");
		List<SubIngredientEntity> subIngredientEntities = new ArrayList<>();
		subIngredientEntities.add(subIngredientEntity1);
		subIngredientEntities.add(subIngredientEntity2);
		SubIngredientRepository repository = Mockito.mock(SubIngredientRepository.class);
		when(repository.findAll())
				.thenReturn(subIngredientEntities);

		SearchSubIngredientsElement searchSubIngredientsElement1 = new SearchSubIngredientsElement(1L, "name1");
		SearchSubIngredientsElement searchSubIngredientsElement2 = new SearchSubIngredientsElement(2L, "name2");
		List<SearchSubIngredientsElement> searchSubIngredientsElements = new ArrayList<>();
		searchSubIngredientsElements.add(searchSubIngredientsElement1);
		searchSubIngredientsElements.add(searchSubIngredientsElement2);
		SearchSubIngredientsDTO searchSubIngredientsDTO = new SearchSubIngredientsDTO(searchSubIngredientsElements, "", "Something went wrong, returned full list.");
		SearchSubIngredientsMapper mapper = Mockito.mock(SearchSubIngredientsMapper.class);
		when(mapper.toSearchSubIngredientsDTO(subIngredientEntities, "Something went wrong, returned full list."))
				.thenReturn(searchSubIngredientsDTO);

		SearchSubIngredientsService service = new SearchSubIngredientsService(repository, mapper);
		SearchSubIngredientsDTO actualSearchSubIngredientsDTO = service.listSubIngredients();
		assertEquals(searchSubIngredientsDTO.getSubIngredients(), actualSearchSubIngredientsDTO.getSubIngredients());
		assertEquals("Something went wrong, returned full list.", actualSearchSubIngredientsDTO.getMessage());
		assertTrue(actualSearchSubIngredientsDTO.getSearchText().isEmpty());
	}
}