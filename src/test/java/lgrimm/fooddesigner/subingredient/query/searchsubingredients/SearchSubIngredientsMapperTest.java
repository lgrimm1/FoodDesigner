package lgrimm.fooddesigner.subingredient.query.searchsubingredients;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SearchSubIngredientsMapperTest {

	@Test
	void toSearchSubIngredientsDTO() {
		SubIngredientEntity subIngredientEntity1 = new SubIngredientEntity(1L, "name1", "allergen1");
		SubIngredientEntity subIngredientEntity2 = new SubIngredientEntity(2L, "name2", "allergen2");
		List<SubIngredientEntity> subIngredientEntities = new ArrayList<>();
		subIngredientEntities.add(subIngredientEntity1);
		subIngredientEntities.add(subIngredientEntity2);
		String message = "message";

		SearchSubIngredientsElement searchSubIngredientsElement1 = new SearchSubIngredientsElement(1L, "name1");
		SearchSubIngredientsElement searchSubIngredientsElement2 = new SearchSubIngredientsElement(2L, "name2");
		List<SearchSubIngredientsElement> searchSubIngredientsElements = new ArrayList<>();
		searchSubIngredientsElements.add(searchSubIngredientsElement1);
		searchSubIngredientsElements.add(searchSubIngredientsElement2);

		SearchSubIngredientsMapper mapper = new SearchSubIngredientsMapper();

		assertThrows(IllegalArgumentException.class, () -> mapper.toSearchSubIngredientsDTO(null, message));
		assertThrows(IllegalArgumentException.class, () -> mapper.toSearchSubIngredientsDTO(subIngredientEntities, null));

		SearchSubIngredientsDTO actualSearchSubIngredientsDTO = mapper.toSearchSubIngredientsDTO(subIngredientEntities, message);
		assertEquals(searchSubIngredientsElements, actualSearchSubIngredientsDTO.getSubIngredients());
		assertTrue(actualSearchSubIngredientsDTO.getSearchText().isEmpty());
		assertEquals(message, actualSearchSubIngredientsDTO.getMessage());
	}
}