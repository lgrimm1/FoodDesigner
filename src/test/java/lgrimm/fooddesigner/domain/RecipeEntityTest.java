package lgrimm.fooddesigner.domain;

import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class RecipeEntityTest {

	@Test
	void contructors() {
		RecipeEntity recipeEntity = new RecipeEntity();
		assertEquals(0, recipeEntity.getId());
		assertNull(recipeEntity.getName());
		assertNull(recipeEntity.getIngredientIds());
		assertNull(recipeEntity.getIngredientWeights());
		assertNull(recipeEntity.getNotes());
		assertNull(recipeEntity.getSteps());
		assertEquals(0, recipeEntity.getCoolingLimit());
		assertEquals(0, recipeEntity.getFreezingLimit());

		assertThrows(Exception.class, () -> new RecipeEntity(
				null,
				List.of(1L, 2L),
				List.of(11, 12),
				"notes",
				"steps",
				23,
				34));
		assertThrows(Exception.class, () -> new RecipeEntity(
				"name",
				List.of(1L, 2L),
				List.of(11, 12),
				null,
				"steps",
				23,
				34));
		assertThrows(Exception.class, () -> new RecipeEntity(
				"name",
				List.of(1L, 2L),
				List.of(11, 12),
				"notes",
				null,
				23,
				34));

		recipeEntity = new RecipeEntity(
				"name",
				List.of(1L, 2L),
				List.of(11, 12),
				"notes",
				"steps",
				23,
				34);
		assertEquals(0, recipeEntity.getId());
		assertEquals("name", recipeEntity.getName());
		assertEquals(List.of(1L, 2L), recipeEntity.getIngredientIds());
		assertEquals(List.of(11, 12) , recipeEntity.getIngredientWeights());
		assertEquals("notes", recipeEntity.getNotes());
		assertEquals("steps", recipeEntity.getSteps());
		assertEquals(23, recipeEntity.getCoolingLimit());
		assertEquals(34, recipeEntity.getFreezingLimit());

		assertThrows(Exception.class, () -> new RecipeEntity(
				12L,
				null,
				List.of(1L, 2L),
				List.of(11, 12),
				"notes",
				"steps",
				23,
				34));
		assertThrows(Exception.class, () -> new RecipeEntity(
				12L,
				"name",
				List.of(1L, 2L),
				List.of(11, 12),
				null,
				"steps",
				23,
				34));
		assertThrows(Exception.class, () -> new RecipeEntity(
				12L,
				"name",
				List.of(1L, 2L),
				List.of(11, 12),
				"notes",
				null,
				23,
				34));

		recipeEntity = new RecipeEntity(
				12L,
				"name",
				List.of(1L, 2L),
				List.of(11, 12),
				"notes",
				"steps",
				23,
				34);
		assertEquals(12L, recipeEntity.getId());
		assertEquals("name", recipeEntity.getName());
		assertEquals(List.of(1L, 2L), recipeEntity.getIngredientIds());
		assertEquals(List.of(11, 12) , recipeEntity.getIngredientWeights());
		assertEquals("notes", recipeEntity.getNotes());
		assertEquals("steps", recipeEntity.getSteps());
		assertEquals(23, recipeEntity.getCoolingLimit());
		assertEquals(34, recipeEntity.getFreezingLimit());
	}

	@Test
	void setters() {
		RecipeEntity recipeEntity = new RecipeEntity(
				12L,
				"name",
				List.of(1L, 2L),
				List.of(11, 12),
				"notes",
				"steps",
				23,
				34);

		assertThrows(Exception.class, () -> recipeEntity.setName(null));
		assertThrows(Exception.class, () -> recipeEntity.setNotes(null));
		assertThrows(Exception.class, () -> recipeEntity.setSteps(null));

		recipeEntity.setId(21L);
		recipeEntity.setName("aaa");
		recipeEntity.setIngredientIds(List.of(9L, 8L));
		recipeEntity.setIngredientWeights(List.of(21, 22));
		recipeEntity.setNotes("bbb");
		recipeEntity.setSteps("ccc");
		recipeEntity.setCoolingLimit(56);
		recipeEntity.setFreezingLimit(65);

		assertEquals(21L, recipeEntity.getId());
		assertEquals("aaa", recipeEntity.getName());
		assertEquals(List.of(9L, 8L), recipeEntity.getIngredientIds());
		assertEquals(List.of(21, 22) , recipeEntity.getIngredientWeights());
		assertEquals("bbb", recipeEntity.getNotes());
		assertEquals("ccc", recipeEntity.getSteps());
		assertEquals(56, recipeEntity.getCoolingLimit());
		assertEquals(65, recipeEntity.getFreezingLimit());
	}

	@Test
	void ingredientsAndWeightsMap() {
		RecipeEntity recipeEntity = new RecipeEntity();

		assertThrows(Exception.class, () -> recipeEntity.setIngredientsAndWeightsMap(null));

		Map<Long, Integer> map = new HashMap<>();
		map.put(4L, 6);
		map.put(8L, 12);

		recipeEntity.setIngredientsAndWeightsMap(map);
		assertEquals(List.of(4L, 8L), recipeEntity.getIngredientIds());
		assertEquals(List.of(6, 12), recipeEntity.getIngredientWeights());

		recipeEntity.setIngredientIds(List.of(56L, 65L));
		recipeEntity.setIngredientWeights(List.of(99, 98));
		map.clear();
		map.put(56L, 99);
		map.put(65L, 98);
		assertEquals(map, recipeEntity.getIngredientsAndWeightsMap());
	}
}