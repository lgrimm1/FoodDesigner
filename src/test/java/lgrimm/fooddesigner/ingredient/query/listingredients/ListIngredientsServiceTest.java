package lgrimm.fooddesigner.ingredient.query.listingredients;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ListIngredientsServiceTest {

	@Test
	void listIngredients() {
		IngredientEntity ingredientEntity1 = new IngredientEntity(
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
				"productDecription1",
				4,
				101.1D,
				111.1D);
		IngredientEntity ingredientEntity2 = new IngredientEntity(
				2L,
				"name2",
				List.of(2l, 2L),
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
				"productDecription2",
				4,
				102.2D,
				112.2D);
		List<IngredientEntity> ingredientEntities = new ArrayList<>();
		ingredientEntities.add(ingredientEntity1);
		ingredientEntities.add(ingredientEntity2);
		IngredientRepository repository = Mockito.mock(IngredientRepository.class);
		when(repository.findAll())
				.thenReturn(ingredientEntities);

		ListIngredientsElement listIngredientsElement1 = new ListIngredientsElement(1L, "name1");
		ListIngredientsElement listIngredientsElement2 = new ListIngredientsElement(2L, "name2");
		List<ListIngredientsElement> listIngredientsElements = new ArrayList<>();
		listIngredientsElements.add(listIngredientsElement1);
		listIngredientsElements.add(listIngredientsElement2);
		ListIngredientsDTO listIngredientsDTO = new ListIngredientsDTO(listIngredientsElements, "", "");
		ListIngredientsMapper mapper = Mockito.mock(ListIngredientsMapper.class);
		when(mapper.toListIngredientsDTO(ingredientEntities))
				.thenReturn(listIngredientsDTO);

		ListIngredientsService service = new ListIngredientsService(repository, mapper);
		ListIngredientsDTO actualListIngredientsDTO = service.listIngredients();
		assertEquals(listIngredientsElements, actualListIngredientsDTO.getIngredients());
		assertTrue(actualListIngredientsDTO.getSearchText().isEmpty());
		assertTrue(actualListIngredientsDTO.getSearchText().isEmpty());
	}
}