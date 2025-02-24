package lgrimm.fooddesigner.domain;

import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class IngredientEntityTest {

	@Test
	void defaultConstructor() {
		IngredientEntity ingredientEntity = new IngredientEntity();
		assertEquals(0, ingredientEntity.getId());
		assertNull(ingredientEntity.getName());
		assertNull(ingredientEntity.getSubIngredientIds());
		assertNull(ingredientEntity.getExtraAllergens());
		assertEquals(0D, ingredientEntity.getDensity());
		assertEquals(0, ingredientEntity.getEnergyKj());
		assertEquals(0, ingredientEntity.getEnergyKcal());
		assertEquals(0D, ingredientEntity.getTotalFats());
		assertEquals(0D, ingredientEntity.getSaturatedFats());
		assertEquals(0D, ingredientEntity.getTotalCarbohydrates());
		assertEquals(0D, ingredientEntity.getSugars());
		assertEquals(0D, ingredientEntity.getFiber());
		assertEquals(0D, ingredientEntity.getProteins());
		assertEquals(0D, ingredientEntity.getSalt());
		assertEquals(0L, ingredientEntity.getProductSourceId());
		assertNull(ingredientEntity.getProductName());
		assertNull(ingredientEntity.getProductManufacturer());
		assertNull(ingredientEntity.getProductDescription());
		assertEquals(0, ingredientEntity.getProductWeight());
		assertEquals(0D, ingredientEntity.getProductGrossPrice());
		assertEquals(0D, ingredientEntity.getProductVatPercent());
	}

	@Test
	void constructorWithoutIdWithNull() {
		assertThrows(Exception.class, () -> new IngredientEntity(
				null,
				new ArrayList<>(),
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
				"productName",
				"productManufacturer",
				"productDescription",
				100,
				123D,
				321D
		));
		assertThrows(Exception.class, () -> new IngredientEntity(
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
				"productName",
				"productManufacturer",
				"productDescription",
				100,
				123D,
				321D
		));
		assertThrows(Exception.class, () -> new IngredientEntity(
				"name",
				new ArrayList<>(),
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
				"productName",
				"productManufacturer",
				"productDescription",
				100,
				123D,
				321D
		));
		assertThrows(Exception.class, () -> new IngredientEntity(
				"name",
				new ArrayList<>(),
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
				"productManufacturer",
				"productDescription",
				100,
				123D,
				321D
		));
		assertThrows(Exception.class, () -> new IngredientEntity(
				"name",
				new ArrayList<>(),
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
				"productName",
				null,
				"productDescription",
				100,
				123D,
				321D
		));
		assertThrows(Exception.class, () -> new IngredientEntity(
				"name",
				new ArrayList<>(),
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
				"productName",
				"productManufacturer",
				null,
				100,
				123D,
				321D
		));
	}

	@Test
	void constructorWithoutId() {
		IngredientEntity ingredientEntity = new IngredientEntity(
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
				"productName",
				"productManufacturer",
				"productDescription",
				100,
				123D,
				321D
		);
		assertEquals(0L, ingredientEntity.getId());
		assertEquals("name", ingredientEntity.getName());
		assertEquals(List.of(1L, 2L, 3L), ingredientEntity.getSubIngredientIds());
		assertEquals("extra", ingredientEntity.getExtraAllergens());
		assertEquals(12.5D, ingredientEntity.getDensity());
		assertEquals(1000, ingredientEntity.getEnergyKj());
		assertEquals(2000, ingredientEntity.getEnergyKcal());
		assertEquals(10D, ingredientEntity.getTotalFats());
		assertEquals(20D, ingredientEntity.getSaturatedFats());
		assertEquals(30D, ingredientEntity.getTotalCarbohydrates());
		assertEquals(40D, ingredientEntity.getSugars());
		assertEquals(50D, ingredientEntity.getFiber());
		assertEquals(60D, ingredientEntity.getProteins());
		assertEquals(70D, ingredientEntity.getSalt());
		assertEquals(36L, ingredientEntity.getProductSourceId());
		assertEquals("productName", ingredientEntity.getProductName());
		assertEquals("productManufacturer", ingredientEntity.getProductManufacturer());
		assertEquals("productDescription", ingredientEntity.getProductDescription());
		assertEquals(100, ingredientEntity.getProductWeight());
		assertEquals(123D, ingredientEntity.getProductGrossPrice());
		assertEquals(321D, ingredientEntity.getProductVatPercent());
	}

	@Test
	void constructorWithIdWithNull() {
		assertThrows(Exception.class, () -> new IngredientEntity(
				12L,
				null,
				new ArrayList<>(),
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
				"productName",
				"productManufacturer",
				"productDescription",
				100,
				123D,
				321D
		));
		assertThrows(Exception.class, () -> new IngredientEntity(
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
				"productName",
				"productManufacturer",
				"productDescription",
				100,
				123D,
				321D
		));
		assertThrows(Exception.class, () -> new IngredientEntity(
				12L,
				"name",
				new ArrayList<>(),
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
				"productName",
				"productManufacturer",
				"productDescription",
				100,
				123D,
				321D
		));
		assertThrows(Exception.class, () -> new IngredientEntity(
				12L,
				"name",
				new ArrayList<>(),
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
				"productManufacturer",
				"productDescription",
				100,
				123D,
				321D
		));
		assertThrows(Exception.class, () -> new IngredientEntity(
				12L,
				"name",
				new ArrayList<>(),
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
				"productName",
				null,
				"productDescription",
				100,
				123D,
				321D
		));
		assertThrows(Exception.class, () -> new IngredientEntity(
				12L,
				"name",
				new ArrayList<>(),
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
				"productName",
				"productManufacturer",
				null,
				100,
				123D,
				321D
		));
	}

	@Test
	void constructorWithId() {
		IngredientEntity ingredientEntity = new IngredientEntity(
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
				"productName",
				"productManufacturer",
				"productDescription",
				100,
				123D,
				321D
		);
		assertEquals(12L, ingredientEntity.getId());
		assertEquals("name", ingredientEntity.getName());
		assertEquals(List.of(1L, 2L, 3L), ingredientEntity.getSubIngredientIds());
		assertEquals("extra", ingredientEntity.getExtraAllergens());
		assertEquals(12.5D, ingredientEntity.getDensity());
		assertEquals(1000, ingredientEntity.getEnergyKj());
		assertEquals(2000, ingredientEntity.getEnergyKcal());
		assertEquals(10D, ingredientEntity.getTotalFats());
		assertEquals(20D, ingredientEntity.getSaturatedFats());
		assertEquals(30D, ingredientEntity.getTotalCarbohydrates());
		assertEquals(40D, ingredientEntity.getSugars());
		assertEquals(50D, ingredientEntity.getFiber());
		assertEquals(60D, ingredientEntity.getProteins());
		assertEquals(70D, ingredientEntity.getSalt());
		assertEquals(36L, ingredientEntity.getProductSourceId());
		assertEquals("productName", ingredientEntity.getProductName());
		assertEquals("productManufacturer", ingredientEntity.getProductManufacturer());
		assertEquals("productDescription", ingredientEntity.getProductDescription());
		assertEquals(100, ingredientEntity.getProductWeight());
		assertEquals(123D, ingredientEntity.getProductGrossPrice());
		assertEquals(321D, ingredientEntity.getProductVatPercent());
	}

	@Test
	void setters() {
		IngredientEntity ingredientEntity = new IngredientEntity(
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
				"productName",
				"productManufacturer",
				"productDescription",
				100,
				123D,
				321D
		);

		assertThrows(Exception.class, () -> ingredientEntity.setName(null));
		assertThrows(Exception.class, () -> ingredientEntity.setSubIngredientIds(null));
		assertThrows(Exception.class, () -> ingredientEntity.setExtraAllergens(null));
		assertThrows(Exception.class, () -> ingredientEntity.setProductName(null));
		assertThrows(Exception.class, () -> ingredientEntity.setProductManufacturer(null));
		assertThrows(Exception.class, () -> ingredientEntity.setProductDescription(null));

		ingredientEntity.setId(-36L);
		ingredientEntity.setName("aaa");
		ingredientEntity.setSubIngredientIds(List.of(11L, 12L, 13L));
		ingredientEntity.setExtraAllergens("ccc");
		ingredientEntity.setDensity(987.6D);
		ingredientEntity.setEnergyKj(9000);
		ingredientEntity.setEnergyKcal(8000);
		ingredientEntity.setTotalFats(99.5D);
		ingredientEntity.setSaturatedFats(88.5D);
		ingredientEntity.setTotalCarbohydrates(77.5D);
		ingredientEntity.setSugars(66.5D);
		ingredientEntity.setFiber(55.5D);
		ingredientEntity.setProteins(44.5D);
		ingredientEntity.setSalt(33.5D);
		ingredientEntity.setProductSourceId(555L);
		ingredientEntity.setProductName("ddd");
		ingredientEntity.setProductManufacturer("eee");
		ingredientEntity.setProductDescription("fff");
		ingredientEntity.setProductWeight(3500);
		ingredientEntity.setProductGrossPrice(12345.6D);
		ingredientEntity.setProductVatPercent(321.1D);

		assertEquals(-36L, ingredientEntity.getId());
		assertEquals("aaa", ingredientEntity.getName());
		assertEquals(List.of(11L, 12L, 13L), ingredientEntity.getSubIngredientIds());
		assertEquals("ccc", ingredientEntity.getExtraAllergens());
		assertEquals(987.6D, ingredientEntity.getDensity());
		assertEquals(9000, ingredientEntity.getEnergyKj());
		assertEquals(8000, ingredientEntity.getEnergyKcal());
		assertEquals(99.5D, ingredientEntity.getTotalFats());
		assertEquals(88.5D, ingredientEntity.getSaturatedFats());
		assertEquals(77.5D, ingredientEntity.getTotalCarbohydrates());
		assertEquals(66.5D, ingredientEntity.getSugars());
		assertEquals(55.5D, ingredientEntity.getFiber());
		assertEquals(44.5D, ingredientEntity.getProteins());
		assertEquals(33.5D, ingredientEntity.getSalt());
		assertEquals(555L, ingredientEntity.getProductSourceId());
		assertEquals("ddd", ingredientEntity.getProductName());
		assertEquals("eee", ingredientEntity.getProductManufacturer());
		assertEquals("fff", ingredientEntity.getProductDescription());
		assertEquals(3500, ingredientEntity.getProductWeight());
		assertEquals(12345.6D, ingredientEntity.getProductGrossPrice());
		assertEquals(321.1D, ingredientEntity.getProductVatPercent());
	}
}