package lgrimm.fooddesigner.ingredient.query.findingredient;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FindIngredientServiceTest {

	IngredientEntity entity1;
	IngredientEntity entity2;

	@BeforeEach
	void setFields() {
		entity1 = new IngredientEntity(
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
		entity2 = new IngredientEntity(
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
	void noSuchIngredient() {
		IngredientEntity emptyEntity = new IngredientEntity();
		IngredientRepository repository = Mockito.mock(IngredientRepository.class);
		when(repository.findById(6L))
				.thenReturn(Optional.empty());

		FindIngredientDTO notFoundIngredientDTO = new FindIngredientDTO(emptyEntity, "No such ingredient was found.");
		FindIngredientMapper mapper = Mockito.mock(FindIngredientMapper.class);
		when(mapper.toFindIngredientDTO(emptyEntity, "No such ingredient was found."))
				.thenReturn(notFoundIngredientDTO);

		FindIngredientService service = new FindIngredientService(repository, mapper);
		FindIngredientDTO actualIngredientDTO = service.findIngredient(6L);
		assertEquals(notFoundIngredientDTO, actualIngredientDTO);
	}

	@Test
	void foundIngredient() {
		IngredientRepository repository = Mockito.mock(IngredientRepository.class);
		when(repository.findById(2L))
				.thenReturn(Optional.of(entity2));

		FindIngredientDTO foundIngredientDTO = new FindIngredientDTO(entity2, "");
		FindIngredientMapper mapper = Mockito.mock(FindIngredientMapper.class);
		when(mapper.toFindIngredientDTO(entity2, ""))
				.thenReturn(foundIngredientDTO);

		FindIngredientService service = new FindIngredientService(repository, mapper);
		FindIngredientDTO actualDTO = service.findIngredient(2L);
		assertEquals(foundIngredientDTO, actualDTO);
	}

	@Test
	void listIngredients() {
		String message = "message";

		List<IngredientEntity> ingredientEntities = new ArrayList<>();
		ingredientEntities.add(entity1);
		ingredientEntities.add(entity2);
		IngredientRepository repository = Mockito.mock(IngredientRepository.class);
		when(repository.findAll())
				.thenReturn(ingredientEntities);

		ListIngredientsElement listRecipesElement1 = new ListIngredientsElement(1L, "name1");
		ListIngredientsElement listRecipesElement2 = new ListIngredientsElement(2L, "name2");
		List<ListIngredientsElement> listRecipesElements = new ArrayList<>();
		listRecipesElements.add(listRecipesElement1);
		listRecipesElements.add(listRecipesElement2);
		ListIngredientsDTO listIngredientsDTO = new ListIngredientsDTO(listRecipesElements, message);
		FindIngredientMapper mapper = Mockito.mock(FindIngredientMapper.class);
		when(mapper.toListIngredientsDTO(ingredientEntities, message))
				.thenReturn(listIngredientsDTO);

		FindIngredientService service = new FindIngredientService(repository, mapper);
		ListIngredientsDTO actualListIngredientsDTO1 = service.listIngredients(message);
		assertEquals(listRecipesElements, actualListIngredientsDTO1.getIngredients());
		assertEquals(message, actualListIngredientsDTO1.getMessage());
	}
}
