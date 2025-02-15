package lgrimm.fooddesigner.subingredient.query.listsubingredients;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ListSubIngredientsServiceTest {

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

		ListSubIngredientsElement listSubIngredientsElement1 = new ListSubIngredientsElement(1L, "name1");
		ListSubIngredientsElement listSubIngredientsElement2 = new ListSubIngredientsElement(2L, "name2");
		List<ListSubIngredientsElement> listSubIngredientsElements = new ArrayList<>();
		listSubIngredientsElements.add(listSubIngredientsElement1);
		listSubIngredientsElements.add(listSubIngredientsElement2);
		ListSubIngredientsDTO listSubIngredientsDTO = new ListSubIngredientsDTO(listSubIngredientsElements, "", "");
		ListSubIngredientsMapper mapper = Mockito.mock(ListSubIngredientsMapper.class);
		when(mapper.toListSubIngredientsDTO(subIngredientEntities))
				.thenReturn(listSubIngredientsDTO);

		ListSubIngredientsService service = new ListSubIngredientsService(repository, mapper);
		ListSubIngredientsDTO actualListSubIngredientsDTO = service.listSubIngredients();
		assertEquals(listSubIngredientsElements, actualListSubIngredientsDTO.getSubIngredients());
		assertTrue(actualListSubIngredientsDTO.getSearchText().isEmpty());
		assertTrue(actualListSubIngredientsDTO.getSearchText().isEmpty());
	}
}