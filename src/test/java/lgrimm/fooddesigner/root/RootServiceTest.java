package lgrimm.fooddesigner.root;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class RootServiceTest {

	@Test
	void getRoot() {
		RecipeEntity recipeEntity1 = new RecipeEntity(
				1L,
				"name1",
				List.of(11L, 21L),
				List.of(31, 41),
				"notes1",
				"steps1",
				51,
				61);
		RecipeEntity recipeEntity2 = new RecipeEntity(
				2L,
				"name2",
				List.of(12L, 22L),
				List.of(32, 42),
				"notes2",
				"steps2",
				52,
				62);

		List<RecipeEntity> recipeEntities = new ArrayList<>();
		recipeEntities.add(recipeEntity1);
		recipeEntities.add(recipeEntity2);
		RecipeRepository repository = Mockito.mock(RecipeRepository.class);
		when(repository.findAll())
				.thenReturn(recipeEntities);

		RootElement rootElement1 = new RootElement(1L, "name1");
		RootElement rootElement2 = new RootElement(2L, "name2");
		List<RootElement> rootElements = new ArrayList<>();
		rootElements.add(rootElement1);
		rootElements.add(rootElement2);
		RootDTO rootDTO = new RootDTO(rootElements, "", "");
		RootMapper mapper = Mockito.mock(RootMapper.class);
		when(mapper.toRootDTO(recipeEntities))
				.thenReturn(rootDTO);

		RootService service = new RootService(repository, mapper);
		RootDTO actualRootDTO = service.getRoot();
		assertEquals(rootElements, actualRootDTO.getRecipes());
		assertTrue(actualRootDTO.getSearchText().isEmpty());
		assertTrue(actualRootDTO.getMessage().isEmpty());
	}
}