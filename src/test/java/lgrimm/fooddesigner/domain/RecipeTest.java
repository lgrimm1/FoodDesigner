package lgrimm.fooddesigner.domain;

import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

	@Test
	void contructors() {
		Recipe recipe = new Recipe();
		assertEquals(0, recipe.getId());
		assertNull(recipe.getName());
		assertNull(recipe.getIngredientIds());
		assertNull(recipe.getIngredientWeights());
		assertNull(recipe.getNotes());
		assertNull(recipe.getSteps());
		assertEquals(0, recipe.getCoolingLimit());
		assertEquals(0, recipe.getFreezingLimit());

		assertThrows(Exception.class, () -> new Recipe(
				null,
				List.of(1L, 2L),
				List.of(11, 12),
				"notes",
				"steps",
				23,
				34));
		assertThrows(Exception.class, () -> new Recipe(
				"name",
				List.of(1L, 2L),
				List.of(11, 12),
				null,
				"steps",
				23,
				34));
		assertThrows(Exception.class, () -> new Recipe(
				"name",
				List.of(1L, 2L),
				List.of(11, 12),
				"notes",
				null,
				23,
				34));

		recipe = new Recipe(
				"name",
				List.of(1L, 2L),
				List.of(11, 12),
				"notes",
				"steps",
				23,
				34);
		assertEquals(0, recipe.getId());
		assertEquals("name", recipe.getName());
		assertEquals(List.of(1L, 2L), recipe.getIngredientIds());
		assertEquals(List.of(11, 12) ,recipe.getIngredientWeights());
		assertEquals("notes", recipe.getNotes());
		assertEquals("steps", recipe.getSteps());
		assertEquals(23, recipe.getCoolingLimit());
		assertEquals(34, recipe.getFreezingLimit());

		assertThrows(Exception.class, () -> new Recipe(
				12L,
				null,
				List.of(1L, 2L),
				List.of(11, 12),
				"notes",
				"steps",
				23,
				34));
		assertThrows(Exception.class, () -> new Recipe(
				12L,
				"name",
				List.of(1L, 2L),
				List.of(11, 12),
				null,
				"steps",
				23,
				34));
		assertThrows(Exception.class, () -> new Recipe(
				12L,
				"name",
				List.of(1L, 2L),
				List.of(11, 12),
				"notes",
				null,
				23,
				34));

		recipe = new Recipe(
				12L,
				"name",
				List.of(1L, 2L),
				List.of(11, 12),
				"notes",
				"steps",
				23,
				34);
		assertEquals(12L, recipe.getId());
		assertEquals("name", recipe.getName());
		assertEquals(List.of(1L, 2L), recipe.getIngredientIds());
		assertEquals(List.of(11, 12) ,recipe.getIngredientWeights());
		assertEquals("notes", recipe.getNotes());
		assertEquals("steps", recipe.getSteps());
		assertEquals(23, recipe.getCoolingLimit());
		assertEquals(34, recipe.getFreezingLimit());
	}

	@Test
	void setters() {
		Recipe recipe = new Recipe(
				12L,
				"name",
				List.of(1L, 2L),
				List.of(11, 12),
				"notes",
				"steps",
				23,
				34);

		assertThrows(Exception.class, () -> recipe.setName(null));
		assertThrows(Exception.class, () -> recipe.setNotes(null));
		assertThrows(Exception.class, () -> recipe.setSteps(null));

		recipe.setId(21L);
		recipe.setName("aaa");
		recipe.setIngredientIds(List.of(9L, 8L));
		recipe.setIngredientWeights(List.of(21, 22));
		recipe.setNotes("bbb");
		recipe.setSteps("ccc");
		recipe.setCoolingLimit(56);
		recipe.setFreezingLimit(65);

		assertEquals(21L, recipe.getId());
		assertEquals("aaa", recipe.getName());
		assertEquals(List.of(9L, 8L), recipe.getIngredientIds());
		assertEquals(List.of(21, 22) ,recipe.getIngredientWeights());
		assertEquals("bbb", recipe.getNotes());
		assertEquals("ccc", recipe.getSteps());
		assertEquals(56, recipe.getCoolingLimit());
		assertEquals(65, recipe.getFreezingLimit());
	}

	@Test
	void ingredientsAndWeightsMap() {
		Recipe recipe = new Recipe();

		assertThrows(Exception.class, () -> recipe.setIngredientsAndWeightsMap(null));

		Map<Long, Integer> map = new HashMap<>();
		map.put(4L, 6);
		map.put(8L, 12);

		recipe.setIngredientsAndWeightsMap(map);
		assertEquals(List.of(4L, 8L), recipe.getIngredientIds());
		assertEquals(List.of(6, 12), recipe.getIngredientWeights());

		recipe.setIngredientIds(List.of(56L, 65L));
		recipe.setIngredientWeights(List.of(99, 98));
		map.clear();
		map.put(56L, 99);
		map.put(65L, 98);
		assertEquals(map, recipe.getIngredientsAndWeightsMap());
	}
}