package lgrimm.fooddesigner.recipe.query.searchrecipes;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.test.context.bean.override.mockito.*;
import org.springframework.test.web.servlet.*;

import java.util.*;

@WebMvcTest(SearchRecipesController.class)
@AutoConfigureDataJpa
class SearchRecipesControllerTest {


	@Autowired
	private MockMvc mockMvc;
	@MockitoBean
	private SearchRecipesService service;

	@Test
	void searchRecipes() throws Exception {
		SearchRecipesElement searchRecipesElement1 = new SearchRecipesElement(1L, "name1");
		SearchRecipesElement searchRecipesElement2 = new SearchRecipesElement(2L, "name2");
		List<SearchRecipesElement> searchRecipesElements = new ArrayList<>();
		searchRecipesElements.add(searchRecipesElement1);
		searchRecipesElements.add(searchRecipesElement2);
		String message = "message";
		SearchRecipesDTO searchRecipesDTO = new SearchRecipesDTO(searchRecipesElements, "", message);
		String text = "text";
		when(service.searchRecipes(text))
				.thenReturn(searchRecipesDTO);

		mockMvc
				.perform(
						get("/recipe/search/" + text)
				)
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(view().name("recipe_list"))
				.andExpect(model().size(1))
				.andExpect(model().attribute("recipeList", searchRecipesDTO));
	}
}