package lgrimm.fooddesigner.ingredient.query.listingredients;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ListIngredientsMapperTest {

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
	void toListIngredientsDTO() {
		List<IngredientEntity> ingredientEntities = new ArrayList<>();
		ingredientEntities.add(entity1);
		ingredientEntities.add(entity2);

		ListIngredientsElement listIngredientsElement1 = new ListIngredientsElement(1L, "name1");
		ListIngredientsElement listIngredientsElement2 = new ListIngredientsElement(2L, "name2");
		List<ListIngredientsElement> listIngredientsElements = new ArrayList<>();
		listIngredientsElements.add(listIngredientsElement1);
		listIngredientsElements.add(listIngredientsElement2);

		ListIngredientsMapper mapper = new ListIngredientsMapper();

		assertThrows(IllegalArgumentException.class, () -> mapper.toListIngredientsDTO(null));

		ListIngredientsDTO actualListIngredientsDTO = mapper.toListIngredientsDTO(ingredientEntities);
		assertEquals(listIngredientsElements, actualListIngredientsDTO.getIngredients());
		assertTrue(actualListIngredientsDTO.getSearchText().isEmpty());
		assertTrue(actualListIngredientsDTO.getMessage().isEmpty());
	}
}