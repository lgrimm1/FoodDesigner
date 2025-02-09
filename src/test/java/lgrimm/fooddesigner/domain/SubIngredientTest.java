package lgrimm.fooddesigner.domain;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SubIngredientTest {

	@Test
	void constructors() {
		SubIngredient subIngredient = new SubIngredient();
		assertEquals(0, subIngredient.getId());
		assertNull(subIngredient.getName());
		assertNull(subIngredient.getAllergen());

		assertThrows(Exception.class, () -> new SubIngredient(null, "allergen"));
		assertThrows(Exception.class, () -> new SubIngredient("name", null));

		subIngredient = new SubIngredient("name", "allergen");
		assertEquals(0, subIngredient.getId());
		assertEquals("name", subIngredient.getName());
		assertEquals("allergen", subIngredient.getAllergen());

		assertThrows(Exception.class, () -> new SubIngredient(12L, null, "allergen"));
		assertThrows(Exception.class, () -> new SubIngredient(12L, "name", null));

		subIngredient = new SubIngredient(12L, "name", "allergen");
		assertEquals(12L, subIngredient.getId());
		assertEquals("name", subIngredient.getName());
		assertEquals("allergen", subIngredient.getAllergen());
	}

	@Test
	void setters() {
		SubIngredient subIngredient = new SubIngredient(12L, "name", "allergen");

		assertThrows(Exception.class, () -> subIngredient.setName(null));
		assertThrows(Exception.class, () -> subIngredient.setAllergen(null));

		subIngredient.setId(-36L);
		subIngredient.setName("xxx");
		subIngredient.setAllergen("zzz");

		assertEquals(-36L, subIngredient.getId());
		assertEquals("xxx", subIngredient.getName());
		assertEquals("zzz", subIngredient.getAllergen());
	}
}