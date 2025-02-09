package lgrimm.fooddesigner.domain;

import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {

	@Test
	void defaultConstructor() {
		Ingredient ingredient = new Ingredient();
		assertEquals(0, ingredient.getId());
		assertNull(ingredient.getName());
		assertNull(ingredient.getSubIngredientIds());
		assertNull(ingredient.getExtraAllergens());
		assertEquals(0D, ingredient.getDensity());
		assertEquals(0, ingredient.getEnergyKj());
		assertEquals(0, ingredient.getEnergyKcal());
		assertEquals(0D, ingredient.getTotalFats());
		assertEquals(0D, ingredient.getSaturatedFats());
		assertEquals(0D, ingredient.getTotalCarbohydrates());
		assertEquals(0D, ingredient.getSugars());
		assertEquals(0D, ingredient.getFiber());
		assertEquals(0D, ingredient.getProteins());
		assertEquals(0D, ingredient.getSalt());
		assertEquals(0L, ingredient.getProductSourceId());
		assertNull(ingredient.getProductName());
		assertNull(ingredient.getProductManufacturer());
		assertNull(ingredient.getProductDescription());
		assertEquals(0, ingredient.getProductWeight());
		assertEquals(0D, ingredient.getProductGrossPrice());
		assertEquals(0D, ingredient.getProductVat());
	}

	@Test
	void constructorWithoutIdWithNull() {
		assertThrows(Exception.class, () -> new Ingredient(
				null,
				new ArrayList<Long>(),
				"extra",
				12.5D,
				1000,
				2000,
				10D,
				20D,
				30D,
				40D,
				50D,
				60D,
				70D,
				36L,
				"pname",
				"pmanu",
				"pdesc",
				100,
				123D,
				321D
		));
		assertThrows(Exception.class, () -> new Ingredient(
				"name",
				null,
				"extra",
				12.5D,
				1000,
				2000,
				10D,
				20D,
				30D,
				40D,
				50D,
				60D,
				70D,
				36L,
				"pname",
				"pmanu",
				"pdesc",
				100,
				123D,
				321D
		));
		assertThrows(Exception.class, () -> new Ingredient(
				"name",
				new ArrayList<Long>(),
				null,
				12.5D,
				1000,
				2000,
				10D,
				20D,
				30D,
				40D,
				50D,
				60D,
				70D,
				36L,
				"pname",
				"pmanu",
				"pdesc",
				100,
				123D,
				321D
		));
		assertThrows(Exception.class, () -> new Ingredient(
				"name",
				new ArrayList<Long>(),
				"extra",
				12.5D,
				1000,
				2000,
				10D,
				20D,
				30D,
				40D,
				50D,
				60D,
				70D,
				36L,
				null,
				"pmanu",
				"pdesc",
				100,
				123D,
				321D
		));
		assertThrows(Exception.class, () -> new Ingredient(
				"name",
				new ArrayList<Long>(),
				"extra",
				12.5D,
				1000,
				2000,
				10D,
				20D,
				30D,
				40D,
				50D,
				60D,
				70D,
				36L,
				"pname",
				null,
				"pdesc",
				100,
				123D,
				321D
		));
		assertThrows(Exception.class, () -> new Ingredient(
				"name",
				new ArrayList<Long>(),
				"extra",
				12.5D,
				1000,
				2000,
				10D,
				20D,
				30D,
				40D,
				50D,
				60D,
				70D,
				36L,
				"pname",
				"pmanu",
				null,
				100,
				123D,
				321D
		));
	}

	@Test
	void constructorWithoutId() {
		Ingredient ingredient = new Ingredient(
				"name",
				List.of(1L, 2L, 3L),
				"extra",
				12.5D,
				1000,
				2000,
				10D,
				20D,
				30D,
				40D,
				50D,
				60D,
				70D,
				36L,
				"pname",
				"pmanu",
				"pdesc",
				100,
				123D,
				321D
		);
		assertEquals(0L, ingredient.getId());
		assertEquals("name", ingredient.getName());
		assertEquals(List.of(1L, 2L, 3L), ingredient.getSubIngredientIds());
		assertEquals("extra", ingredient.getExtraAllergens());
		assertEquals(12.5D, ingredient.getDensity());
		assertEquals(1000, ingredient.getEnergyKj());
		assertEquals(2000, ingredient.getEnergyKcal());
		assertEquals(10D, ingredient.getTotalFats());
		assertEquals(20D, ingredient.getSaturatedFats());
		assertEquals(30D, ingredient.getTotalCarbohydrates());
		assertEquals(40D, ingredient.getSugars());
		assertEquals(50D, ingredient.getFiber());
		assertEquals(60D, ingredient.getProteins());
		assertEquals(70D, ingredient.getSalt());
		assertEquals(36L, ingredient.getProductSourceId());
		assertEquals("pname", ingredient.getProductName());
		assertEquals("pmanu", ingredient.getProductManufacturer());
		assertEquals("pdesc", ingredient.getProductDescription());
		assertEquals(100, ingredient.getProductWeight());
		assertEquals(123D, ingredient.getProductGrossPrice());
		assertEquals(321D, ingredient.getProductVat());
	}

	@Test
	void constructorWithIdWithNull() {
		assertThrows(Exception.class, () -> new Ingredient(
				12L,
				null,
				new ArrayList<Long>(),
				"extra",
				12.5D,
				1000,
				2000,
				10D,
				20D,
				30D,
				40D,
				50D,
				60D,
				70D,
				36L,
				"pname",
				"pmanu",
				"pdesc",
				100,
				123D,
				321D
		));
		assertThrows(Exception.class, () -> new Ingredient(
				12L,
				"name",
				null,
				"extra",
				12.5D,
				1000,
				2000,
				10D,
				20D,
				30D,
				40D,
				50D,
				60D,
				70D,
				36L,
				"pname",
				"pmanu",
				"pdesc",
				100,
				123D,
				321D
		));
		assertThrows(Exception.class, () -> new Ingredient(
				12L,
				"name",
				new ArrayList<Long>(),
				null,
				12.5D,
				1000,
				2000,
				10D,
				20D,
				30D,
				40D,
				50D,
				60D,
				70D,
				36L,
				"pname",
				"pmanu",
				"pdesc",
				100,
				123D,
				321D
		));
		assertThrows(Exception.class, () -> new Ingredient(
				12L,
				"name",
				new ArrayList<Long>(),
				"extra",
				12.5D,
				1000,
				2000,
				10D,
				20D,
				30D,
				40D,
				50D,
				60D,
				70D,
				36L,
				null,
				"pmanu",
				"pdesc",
				100,
				123D,
				321D
		));
		assertThrows(Exception.class, () -> new Ingredient(
				12L,
				"name",
				new ArrayList<Long>(),
				"extra",
				12.5D,
				1000,
				2000,
				10D,
				20D,
				30D,
				40D,
				50D,
				60D,
				70D,
				36L,
				"pname",
				null,
				"pdesc",
				100,
				123D,
				321D
		));
		assertThrows(Exception.class, () -> new Ingredient(
				12L,
				"name",
				new ArrayList<Long>(),
				"extra",
				12.5D,
				1000,
				2000,
				10D,
				20D,
				30D,
				40D,
				50D,
				60D,
				70D,
				36L,
				"pname",
				"pmanu",
				null,
				100,
				123D,
				321D
		));
	}

	@Test
	void constructorWithId() {
		Ingredient ingredient = new Ingredient(
				12L,
				"name",
				List.of(1L, 2L, 3L),
				"extra",
				12.5D,
				1000,
				2000,
				10D,
				20D,
				30D,
				40D,
				50D,
				60D,
				70D,
				36L,
				"pname",
				"pmanu",
				"pdesc",
				100,
				123D,
				321D
		);
		assertEquals(12L, ingredient.getId());
		assertEquals("name", ingredient.getName());
		assertEquals(List.of(1L, 2L, 3L), ingredient.getSubIngredientIds());
		assertEquals("extra", ingredient.getExtraAllergens());
		assertEquals(12.5D, ingredient.getDensity());
		assertEquals(1000, ingredient.getEnergyKj());
		assertEquals(2000, ingredient.getEnergyKcal());
		assertEquals(10D, ingredient.getTotalFats());
		assertEquals(20D, ingredient.getSaturatedFats());
		assertEquals(30D, ingredient.getTotalCarbohydrates());
		assertEquals(40D, ingredient.getSugars());
		assertEquals(50D, ingredient.getFiber());
		assertEquals(60D, ingredient.getProteins());
		assertEquals(70D, ingredient.getSalt());
		assertEquals(36L, ingredient.getProductSourceId());
		assertEquals("pname", ingredient.getProductName());
		assertEquals("pmanu", ingredient.getProductManufacturer());
		assertEquals("pdesc", ingredient.getProductDescription());
		assertEquals(100, ingredient.getProductWeight());
		assertEquals(123D, ingredient.getProductGrossPrice());
		assertEquals(321D, ingredient.getProductVat());
	}

	@Test
	void setters() {
		Ingredient ingredient = new Ingredient(
				12L,
				"name",
				List.of(1L, 2L, 3L),
				"extra",
				12.5D,
				1000,
				2000,
				10D,
				20D,
				30D,
				40D,
				50D,
				60D,
				70D,
				36L,
				"pname",
				"pmanu",
				"pdesc",
				100,
				123D,
				321D
		);

		assertThrows(Exception.class, () -> ingredient.setName(null));
		assertThrows(Exception.class, () -> ingredient.setSubIngredientIds(null));
		assertThrows(Exception.class, () -> ingredient.setExtraAllergens(null));
		assertThrows(Exception.class, () -> ingredient.setProductName(null));
		assertThrows(Exception.class, () -> ingredient.setProductManufacturer(null));
		assertThrows(Exception.class, () -> ingredient.setProductDescription(null));

		ingredient.setId(-36L);
		ingredient.setName("aaa");
		ingredient.setSubIngredientIds(List.of(11L, 12L, 13L));
		ingredient.setExtraAllergens("ccc");
		ingredient.setDensity(987.6D);
		ingredient.setEnergyKj(9000);
		ingredient.setEnergyKcal(8000);
		ingredient.setTotalFats(99.5D);
		ingredient.setSaturatedFats(88.5D);
		ingredient.setTotalCarbohydrates(77.5D);
		ingredient.setSugars(66.5D);
		ingredient.setFiber(55.5D);
		ingredient.setProteins(44.5D);
		ingredient.setSalt(33.5D);
		ingredient.setProductSourceId(555L);
		ingredient.setProductName("ddd");
		ingredient.setProductManufacturer("eee");
		ingredient.setProductDescription("fff");
		ingredient.setProductWeight(3500);
		ingredient.setProductGrossPrice(12345.6D);
		ingredient.setProductVat(321.1D);

		assertEquals(-36L, ingredient.getId());
		assertEquals("aaa", ingredient.getName());
		assertEquals(List.of(11L, 12L, 13L), ingredient.getSubIngredientIds());
		assertEquals("ccc", ingredient.getExtraAllergens());
		assertEquals(987.6D, ingredient.getDensity());
		assertEquals(9000, ingredient.getEnergyKj());
		assertEquals(8000, ingredient.getEnergyKcal());
		assertEquals(99.5D, ingredient.getTotalFats());
		assertEquals(88.5D, ingredient.getSaturatedFats());
		assertEquals(77.5D, ingredient.getTotalCarbohydrates());
		assertEquals(66.5D, ingredient.getSugars());
		assertEquals(55.5D, ingredient.getFiber());
		assertEquals(44.5D, ingredient.getProteins());
		assertEquals(33.5D, ingredient.getSalt());
		assertEquals(555L, ingredient.getProductSourceId());
		assertEquals("ddd", ingredient.getProductName());
		assertEquals("eee", ingredient.getProductManufacturer());
		assertEquals("fff", ingredient.getProductDescription());
		assertEquals(3500, ingredient.getProductWeight());
		assertEquals(12345.6D, ingredient.getProductGrossPrice());
		assertEquals(321.1D, ingredient.getProductVat());
	}
}