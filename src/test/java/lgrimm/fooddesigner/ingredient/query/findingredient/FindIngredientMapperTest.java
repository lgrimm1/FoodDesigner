package lgrimm.fooddesigner.ingredient.query.findingredient;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FindIngredientMapperTest {

	@Test
	void toFindIngredientDTO() {
		IngredientEntity entity = new IngredientEntity(
				1L,
				"name1",
				List.of(1L, 2L),
				"extraAllergens1",
				12.3D,
				11,
				12,
				31.1D,
				41.4D,
				51.5D,
				61.6D,
				71.7D,
				81.8D,
				91.9D,
				3L,
				"productName1",
				"productManufacturer1",
				"productDecription1",
				4,
				101.1D,
				111.1D);
		String message = "message";
		FindIngredientMapper mapper = new FindIngredientMapper();

		assertThrows(IllegalArgumentException.class, () -> mapper.toFindIngredientDTO(null, message));
		assertThrows(IllegalArgumentException.class, () -> mapper.toFindIngredientDTO(entity, null));

		FindIngredientDTO findIngredientDTO = mapper.toFindIngredientDTO(entity, message);
/*
		assertEquals(entity.getId(), findIngredientDTO.getIngredient().getId());
		assertEquals(entity.getName(), findIngredientDTO.getIngredient().getName());
		assertEquals(entity.getSubIngredientIds(), findIngredientDTO.getIngredient().getSubIngredientIds());
		assertEquals(entity.getExtraAllergens(), findIngredientDTO.getIngredient().getExtraAllergens());
		assertEquals(entity.getDensity(), findIngredientDTO.getIngredient().getDensity());
		assertEquals(entity.getEnergyKj(), findIngredientDTO.getIngredient().getEnergyKj());
		assertEquals(entity.getEnergyKcal(), findIngredientDTO.getIngredient().getEnergyKcal());
		assertEquals(entity.getTotalFats(), findIngredientDTO.getIngredient().getTotalFats());
		assertEquals(entity.getSaturatedFats(), findIngredientDTO.getIngredient().getSaturatedFats());
*/
		assertEquals(entity, findIngredientDTO.getIngredient());
		assertEquals(message, findIngredientDTO.getMessage());
	}

	@Test
	void toListIngredientsDTO() {
		IngredientEntity ingredientEntity1 = new IngredientEntity(
				1L,
				"name1",
				List.of(1L, 2L),
				"extraAllergens1",
				12.3D,
				11,
				12,
				31.1D,
				41.4D,
				51.5D,
				61.6D,
				71.7D,
				81.8D,
				91.9D,
				3L,
				"productName1",
				"productManufacturer1",
				"productDecription1",
				4,
				101.1D,
				111.1D);
		IngredientEntity ingredientEntity2 = new IngredientEntity(
				2L,
				"name2",
				List.of(2L, 2L),
				"extraAllergens2",
				22.3D,
				22,
				22,
				32.2D,
				42.4D,
				52.5D,
				62.6D,
				72.7D,
				82.8D,
				92.9D,
				3L,
				"productName2",
				"productManufacturer2",
				"productDecription2",
				4,
				102.2D,
				112.2D);
		List<IngredientEntity> ingredientEntities = new ArrayList<>();
		ingredientEntities.add(ingredientEntity1);
		ingredientEntities.add(ingredientEntity2);
		String message = "message";

		ListIngredientsElement listRecipesElement1 = new ListIngredientsElement(1L, "name1");
		ListIngredientsElement listRecipesElement2 = new ListIngredientsElement(2L, "name2");
		List<ListIngredientsElement> listRecipesElements = new ArrayList<>();
		listRecipesElements.add(listRecipesElement1);
		listRecipesElements.add(listRecipesElement2);

		FindIngredientMapper mapper = new FindIngredientMapper();

		assertThrows(IllegalArgumentException.class, () -> mapper.toListIngredientsDTO(null, message));
		assertThrows(IllegalArgumentException.class, () -> mapper.toListIngredientsDTO(ingredientEntities, null));

		ListIngredientsDTO actualListIngredientsDTO = mapper.toListIngredientsDTO(ingredientEntities, message);
		assertEquals(listRecipesElements, actualListIngredientsDTO.getIngredients());
		assertEquals(message, actualListIngredientsDTO.getMessage());
	}
}
