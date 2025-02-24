package lgrimm.fooddesigner.recipe.query.findrecipe;

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

@WebMvcTest(FindRecipeController.class)
@AutoConfigureDataJpa
class FindRecipeControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockitoBean
	private FindRecipeService service;

	@Test
	void findRecipeWithExistingRecipe() throws Exception {
		RecipeEntity recipeEntity = new RecipeEntity(
				1L,
				"name1",
				List.of(11L, 12L),
				List.of(13, 14),
				"notes1",
				"steps1",
				13,
				14);
		String message = "";
		FindRecipeDTO findRecipeDTO = new FindRecipeDTO(recipeEntity, message);
		when(service.findRecipe(12L))
				.thenReturn(findRecipeDTO);

		FindRecipeController controller = new FindRecipeController(service);

		mockMvc
				.perform(
						get("/recipe/12")
				)
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(view().name("recipe"))
				.andExpect(model().size(1))
				.andExpect(model().attribute("recipe", findRecipeDTO));
	}

	@Test
	void findRecipeWithNotExistingRecipe() throws Exception {
		RecipeEntity recipe = new RecipeEntity();
		String message = "message";
		FindRecipeDTO findRecipeDTO = new FindRecipeDTO(recipe, message);
		when(service.findRecipe(12L))
				.thenReturn(findRecipeDTO);

		ListRecipesElement element1 = new ListRecipesElement(1L, "name1");
		ListRecipesElement element2 = new ListRecipesElement(2L, "name2");
		List<ListRecipesElement> recipes = new ArrayList<>();
		recipes.add(element1);
		recipes.add(element2);
		ListRecipesDTO listRecipesDTO = new ListRecipesDTO(recipes, message);
		when(service.listRecipes(message))
				.thenReturn(listRecipesDTO);

		FindRecipeController controller = new FindRecipeController(service);

		mockMvc
				.perform(
						get("/recipe/12")
				)
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(view().name("recipe_list"))
				.andExpect(model().size(1))
				.andExpect(model().attribute("recipeList", listRecipesDTO));
	}
}