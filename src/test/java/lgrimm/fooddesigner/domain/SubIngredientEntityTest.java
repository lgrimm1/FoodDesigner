package lgrimm.fooddesigner.domain;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SubIngredientEntityTest {

	@Test
	void constructors() {
		SubIngredientEntity subIngredientEntity = new SubIngredientEntity();
		assertEquals(0, subIngredientEntity.getId());
		assertNull(subIngredientEntity.getName());
		assertNull(subIngredientEntity.getAllergen());

		assertThrows(Exception.class, () -> new SubIngredientEntity(null, "allergen"));
		assertThrows(Exception.class, () -> new SubIngredientEntity("name", null));

		subIngredientEntity = new SubIngredientEntity("name", "allergen");
		assertEquals(0, subIngredientEntity.getId());
		assertEquals("name", subIngredientEntity.getName());
		assertEquals("allergen", subIngredientEntity.getAllergen());

		assertThrows(Exception.class, () -> new SubIngredientEntity(12L, null, "allergen"));
		assertThrows(Exception.class, () -> new SubIngredientEntity(12L, "name", null));

		subIngredientEntity = new SubIngredientEntity(12L, "name", "allergen");
		assertEquals(12L, subIngredientEntity.getId());
		assertEquals("name", subIngredientEntity.getName());
		assertEquals("allergen", subIngredientEntity.getAllergen());
	}

	@Test
	void setters() {
		SubIngredientEntity subIngredientEntity = new SubIngredientEntity(12L, "name", "allergen");

		assertThrows(Exception.class, () -> subIngredientEntity.setName(null));
		assertThrows(Exception.class, () -> subIngredientEntity.setAllergen(null));

		subIngredientEntity.setId(-36L);
		subIngredientEntity.setName("xxx");
		subIngredientEntity.setAllergen("zzz");

		assertEquals(-36L, subIngredientEntity.getId());
		assertEquals("xxx", subIngredientEntity.getName());
		assertEquals("zzz", subIngredientEntity.getAllergen());
	}
}