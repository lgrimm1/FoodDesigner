package lgrimm.fooddesigner.ingredient.query.findingredient;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FindIngredientMapperTest {

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
	void toFindIngredientDTO() {
		String message = "message";
		FindIngredientMapper mapper = new FindIngredientMapper();

		assertThrows(IllegalArgumentException.class, () -> mapper.toFindIngredientDTO(null, message));
		assertThrows(IllegalArgumentException.class, () -> mapper.toFindIngredientDTO(entity1, null));

		FindIngredientDTO findIngredientDTO = mapper.toFindIngredientDTO(entity1, message);
		assertEquals(entity1, findIngredientDTO.getIngredient());
		assertEquals(message, findIngredientDTO.getMessage());
	}

	@Test
	void toListIngredientsDTO() {
		List<IngredientEntity> ingredientEntities = new ArrayList<>();
		ingredientEntities.add(entity1);
		ingredientEntities.add(entity2);
		String message = "message";

		ListIngredientsElement listRecipesElement1 = new ListIngredientsElement(1L, "name1");
		ListIngredientsElement listRecipesElement2 = new ListIngredientsElement(2L, "name2");
		List<ListIngredientsElement> listRecipesElements = new ArrayList<>();
		listRecipesElements.add(listRecipesElement1);
		listRecipesElements.add(listRecipesElement2);

		FindIngredientMapper mapper = new FindIngredientMapper();

		assertThrows(IllegalArgumentException.class, () -> mapper.toListIngredientsDTO(null, message));
		assertThrows(IllegalArgumentException.class, () -> mapper.toListIngredientsDTO(ingredientEntities, null));

		ListIngredientsDTO actualListIngredientsDTO = mapper.toListIngredientsDTO(ingredientEntities, message);
		assertEquals(listRecipesElements, actualListIngredientsDTO.getIngredients());
		assertEquals(message, actualListIngredientsDTO.getMessage());
	}
}
