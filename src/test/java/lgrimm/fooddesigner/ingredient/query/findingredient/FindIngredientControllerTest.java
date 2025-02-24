package lgrimm.fooddesigner.ingredient.query.findingredient;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.test.context.bean.override.mockito.*;
import org.springframework.test.web.servlet.*;

import java.util.*;

import static org.mockito.Mockito.when;

@WebMvcTest(FindIngredientController.class)
@AutoConfigureDataJpa
class FindIngredientControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockitoBean
	private FindIngredientService service;

	@Test
	void findIngredientWithExistingIngredient() throws Exception {
		IngredientEntity ingredientEntity = new IngredientEntity(
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
				"productDescription1",
				4,
				101.1D,
				111.1D);
		String message = "";
		FindIngredientDTO findIngredientDTO = new FindIngredientDTO(ingredientEntity, message);
		when(service.findIngredient(12L))
				.thenReturn(findIngredientDTO);

		FindIngredientController controller = new FindIngredientController(service);

		mockMvc
				.perform(
						get("/ingredient/12")
				)
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(view().name("ingredient"))
				.andExpect(model().size(1))
				.andExpect(model().attribute("ingredient", findIngredientDTO));
	}

	@Test
	void findIngredientWithNotExistingIngredient() throws Exception {
		IngredientEntity ingredient = new IngredientEntity();
		String message = "message";
		FindIngredientDTO findIngredientDTO = new FindIngredientDTO(ingredient, message);
		when(service.findIngredient(12L))
				.thenReturn(findIngredientDTO);

		ListIngredientsElement element1 = new ListIngredientsElement(1L, "name1");
		ListIngredientsElement element2 = new ListIngredientsElement(2L, "name2");
		List<ListIngredientsElement> ingredients = new ArrayList<>();
		ingredients.add(element1);
		ingredients.add(element2);
		ListIngredientsDTO listIngredientsDTO = new ListIngredientsDTO(ingredients, message);
		when(service.listIngredients(message))
				.thenReturn(listIngredientsDTO);

		FindIngredientController controller = new FindIngredientController(service);

		mockMvc
				.perform(
						get("/ingredient/12")
				)
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(view().name("ingredient_list"))
				.andExpect(model().size(1))
				.andExpect(model().attribute("ingredientList", listIngredientsDTO));
	}
}
