package lgrimm.fooddesigner.ingredient.query.searchingredients;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SearchIngredientsMapperTest {

	@Test
	void toSearchIngredientsDTO() {
		IngredientEntity ingredientEntity1 = new IngredientEntity(
				1L,
				"name1",
				List.of(11L, 12L),
				"allergens1",
				15D,
				16,
				17,
				111,
				112,
				113,
				114,
				115,
				116,
				117,
				1L,
				"name1",
				"manu1",
				"desc1",
				118,
				119,
				120);
		IngredientEntity ingredientEntity2 = new IngredientEntity(
				2L,
				"name2",
				List.of(21L, 22L),
				"allergen2",
				25D,
				26,
				27,
				211,
				212,
				213,
				214,
				215,
				216,
				217,
				2L,
				"name2",
				"manu2",
				"desc2",
				218,
				219,
				220);
		List<IngredientEntity> ingredientEntities = new ArrayList<>();
		ingredientEntities.add(ingredientEntity1);
		ingredientEntities.add(ingredientEntity2);
		String message = "message";

		SearchIngredientsElement searchIngredientsElement1 = new SearchIngredientsElement(1L, "name1");
		SearchIngredientsElement searchIngredientsElement2 = new SearchIngredientsElement(2L, "name2");
		List<SearchIngredientsElement> searchIngredientsElements = new ArrayList<>();
		searchIngredientsElements.add(searchIngredientsElement1);
		searchIngredientsElements.add(searchIngredientsElement2);

		SearchIngredientsMapper mapper = new SearchIngredientsMapper();

		assertThrows(IllegalArgumentException.class, () -> mapper.toSearchIngredientsDTO(null, message));
		assertThrows(IllegalArgumentException.class, () -> mapper.toSearchIngredientsDTO(ingredientEntities, null));

		SearchIngredientsDTO actualSearchIngredientsDTO = mapper.toSearchIngredientsDTO(ingredientEntities, message);
		assertEquals(searchIngredientsElements, actualSearchIngredientsDTO.getIngredients());
		assertTrue(actualSearchIngredientsDTO.getSearchText().isEmpty());
		assertEquals(message, actualSearchIngredientsDTO.getMessage());
	}
}