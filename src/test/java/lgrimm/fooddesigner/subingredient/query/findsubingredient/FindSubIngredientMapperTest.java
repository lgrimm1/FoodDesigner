package lgrimm.fooddesigner.subingredient.query.findsubingredient;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FindSubIngredientMapperTest {

	@Test
	void toFindSubIngredientDTO() {
		SubIngredientEntity entity = new SubIngredientEntity(12L, "name", "allergen");
		String message = "message";
		FindSubIngredientMapper mapper = new FindSubIngredientMapper();

		assertThrows(IllegalArgumentException.class, () -> mapper.toFindSubIngredientDTO(null, message));
		assertThrows(IllegalArgumentException.class, () -> mapper.toFindSubIngredientDTO(entity, null));

		FindSubIngredientDTO findSubIngredientDTO = mapper.toFindSubIngredientDTO(entity, message);
		assertEquals(entity.getId(), findSubIngredientDTO.getSubIngredient().getId());
		assertEquals(entity.getName(), findSubIngredientDTO.getSubIngredient().getName());
		assertEquals(entity.getAllergen(), findSubIngredientDTO.getSubIngredient().getAllergen());
		assertEquals(message, findSubIngredientDTO.getMessage());
	}

	@Test
	void toListSubIngredientsDTO() {
		SubIngredientEntity subIngredientEntity1 = new SubIngredientEntity(1L, "name1", "allergen1");
		SubIngredientEntity subIngredientEntity2 = new SubIngredientEntity(2L, "name2", "allergen2");
		List<SubIngredientEntity> subIngredientEntities = new ArrayList<>();
		subIngredientEntities.add(subIngredientEntity1);
		subIngredientEntities.add(subIngredientEntity2);
		String message = "message";

		ListSubIngredientsElement listRecipesElement1 = new ListSubIngredientsElement(1L, "name1");
		ListSubIngredientsElement listRecipesElement2 = new ListSubIngredientsElement(2L, "name2");
		List<ListSubIngredientsElement> listRecipesElements = new ArrayList<>();
		listRecipesElements.add(listRecipesElement1);
		listRecipesElements.add(listRecipesElement2);

		FindSubIngredientMapper mapper = new FindSubIngredientMapper();

		assertThrows(IllegalArgumentException.class, () -> mapper.toListSubIngredientsDTO(null, message));
		assertThrows(IllegalArgumentException.class, () -> mapper.toListSubIngredientsDTO(subIngredientEntities, null));

		ListSubIngredientsDTO actualListSubIngredientsDTO = mapper.toListSubIngredientsDTO(subIngredientEntities, message);
		assertEquals(listRecipesElements, actualListSubIngredientsDTO.getSubIngredients());
		assertEquals(message, actualListSubIngredientsDTO.getMessage());
	}
}
