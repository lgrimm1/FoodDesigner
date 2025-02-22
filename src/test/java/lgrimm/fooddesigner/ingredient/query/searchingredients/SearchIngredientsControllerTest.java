package lgrimm.fooddesigner.ingredient.query.searchingredients;

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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebMvcTest(SearchIngredientsController.class)
@AutoConfigureDataJpa
class SearchIngredientsControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockitoBean
	private SearchIngredientsService service;

	@Test
	void searchIngredients() throws Exception {
		SearchIngredientsElement searchIngredientsElement1 = new SearchIngredientsElement(1L, "name1");
		SearchIngredientsElement searchIngredientsElement2 = new SearchIngredientsElement(2L, "name2");
		List<SearchIngredientsElement> searchIngredientsElements = new ArrayList<>();
		searchIngredientsElements.add(searchIngredientsElement1);
		searchIngredientsElements.add(searchIngredientsElement2);
		String message = "message";
		SearchIngredientsDTO searchIngredientsDTO = new SearchIngredientsDTO(searchIngredientsElements, "", message);
		String text = "text";
		when(service.searchIngredients(text))
				.thenReturn(searchIngredientsDTO);

		mockMvc
				.perform(
						get("/ingredient/search/" + text)
				)
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(view().name("ingredient_list"))
				.andExpect(model().size(1))
				.andExpect(model().attribute("ingredientList", searchIngredientsDTO));
	}
}