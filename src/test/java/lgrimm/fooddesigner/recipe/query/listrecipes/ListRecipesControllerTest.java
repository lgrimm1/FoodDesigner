package lgrimm.fooddesigner.recipe.query.listrecipes;

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

@WebMvcTest(ListRecipesController.class)
@AutoConfigureDataJpa
class ListRecipesControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockitoBean
	private ListRecipesService service;

	@Test
	void listRecipes() throws Exception {
		ListRecipesElement listRecipesElement1 = new ListRecipesElement(1L, "name1");
		ListRecipesElement listRecipesElement2 = new ListRecipesElement(2L, "name2");
		List<ListRecipesElement> listRecipesElements = new ArrayList<>();
		listRecipesElements.add(listRecipesElement1);
		listRecipesElements.add(listRecipesElement2);
		ListRecipesDTO listRecipesDTO = new ListRecipesDTO(listRecipesElements, "", "");
		when(service.listRecipes())
				.thenReturn(listRecipesDTO);

		mockMvc
				.perform(
						get("/recipe/list")
				)
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(view().name("recipe_list"))
				.andExpect(model().size(1))
				.andExpect(model().attribute("recipeList", listRecipesDTO));
	}
}