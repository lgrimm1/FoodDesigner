package lgrimm.fooddesigner.subingredient.query.findsubingredient;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FindSubIngredientServiceTest {

	@Test
	void noSuchSubIngredient() {
		SubIngredientEntity emptyEntity = new SubIngredientEntity();
		SubIngredientRepository repository = Mockito.mock(SubIngredientRepository.class);
		when(repository.findById(6L))
				.thenReturn(Optional.empty());

		FindSubIngredientDTO notFoundSubIngredientDTO = new FindSubIngredientDTO(emptyEntity, "No such subIngredient was found.");
		FindSubIngredientMapper mapper = Mockito.mock(FindSubIngredientMapper.class);
		when(mapper.toFindSubIngredientDTO(emptyEntity, "No such subIngredient was found."))
				.thenReturn(notFoundSubIngredientDTO);

		FindSubIngredientService service = new FindSubIngredientService(repository, mapper);
		FindSubIngredientDTO actualSubIngredientDTO = service.findSubIngredient(6L);
		assertEquals(notFoundSubIngredientDTO, actualSubIngredientDTO);
	}

	@Test
	void foundSubIngredient() {
		SubIngredientEntity foundEntity = new SubIngredientEntity(12L, "name", "allergen");
		SubIngredientRepository repository = Mockito.mock(SubIngredientRepository.class);
		when(repository.findById(12L))
				.thenReturn(Optional.of(foundEntity));

		FindSubIngredientDTO foundSubIngredientDTO = new FindSubIngredientDTO(foundEntity, "");
		FindSubIngredientMapper mapper = Mockito.mock(FindSubIngredientMapper.class);
		when(mapper.toFindSubIngredientDTO(foundEntity, ""))
				.thenReturn(foundSubIngredientDTO);

		FindSubIngredientService service = new FindSubIngredientService(repository, mapper);
		FindSubIngredientDTO actualDTO = service.findSubIngredient(12L);
		assertEquals(foundSubIngredientDTO, actualDTO);
	}

	@Test
	void listSubIngredients() {
		SubIngredientEntity subIngredientEntity1 = new SubIngredientEntity(1L, "name1", "allergen1");
		SubIngredientEntity subIngredientEntity2 = new SubIngredientEntity(2L, "name2", "allergen2");
		String message = "message";

		List<SubIngredientEntity> subIngredientEntities = new ArrayList<>();
		subIngredientEntities.add(subIngredientEntity1);
		subIngredientEntities.add(subIngredientEntity2);
		SubIngredientRepository repository = Mockito.mock(SubIngredientRepository.class);
		when(repository.findAll())
				.thenReturn(subIngredientEntities);

		ListSubIngredientsElement listRecipesElement1 = new ListSubIngredientsElement(1L, "name1");
		ListSubIngredientsElement listRecipesElement2 = new ListSubIngredientsElement(2L, "name2");
		List<ListSubIngredientsElement> listRecipesElements = new ArrayList<>();
		listRecipesElements.add(listRecipesElement1);
		listRecipesElements.add(listRecipesElement2);
		ListSubIngredientsDTO listSubIngredientsDTO = new ListSubIngredientsDTO(listRecipesElements, message);
		FindSubIngredientMapper mapper = Mockito.mock(FindSubIngredientMapper.class);
		when(mapper.toListSubIngredientsDTO(subIngredientEntities, message))
				.thenReturn(listSubIngredientsDTO);

		FindSubIngredientService service = new FindSubIngredientService(repository, mapper);
		ListSubIngredientsDTO actualListSubIngredientsDTO1 = service.listSubIngredients(message);
		assertEquals(listRecipesElements, actualListSubIngredientsDTO1.getSubIngredients());
		assertEquals(message, actualListSubIngredientsDTO1.getMessage());
	}
}
