package lgrimm.fooddesigner.subingredient.query.listsubingredients;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ListSubIngredientsMapperTest {

	@Test
	void toListSubIngredientsDTO() {
		SubIngredientEntity subIngredientEntity1 = new SubIngredientEntity(1L, "name1", "alergen1");
		SubIngredientEntity subIngredientEntity2 = new SubIngredientEntity(2L, "name2", "alergen2");
		List<SubIngredientEntity> subIngredientEntities = new ArrayList<>();
		subIngredientEntities.add(subIngredientEntity1);
		subIngredientEntities.add(subIngredientEntity2);

		ListSubIngredientsElement listSubIngredientsElement1 = new ListSubIngredientsElement(1L, "name1");
		ListSubIngredientsElement listSubIngredientsElement2 = new ListSubIngredientsElement(2L, "name2");
		List<ListSubIngredientsElement> listSubIngredientsElements = new ArrayList<>();
		listSubIngredientsElements.add(listSubIngredientsElement1);
		listSubIngredientsElements.add(listSubIngredientsElement2);

		ListSubIngredientsMapper mapper = new ListSubIngredientsMapper();

		assertThrows(IllegalArgumentException.class, () -> mapper.toListSubIngredientsDTO(null));

		ListSubIngredientsDTO actualistSubIngredientsDTO = mapper.toListSubIngredientsDTO(subIngredientEntities);
		assertEquals(listSubIngredientsElements, actualistSubIngredientsDTO.getSubIngredients());
		assertTrue(actualistSubIngredientsDTO.getSearchText().isEmpty());
		assertTrue(actualistSubIngredientsDTO.getMessage().isEmpty());
	}
}