package lgrimm.fooddesigner.subingredient.query.searchsubingredients;

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

@WebMvcTest(SearchSubIngredientsController.class)
@AutoConfigureDataJpa
class SearchSubIngredientsControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockitoBean
	private SearchSubIngredientsService service;

	@Test
	void searchSubIngredients() throws Exception {
		SearchSubIngredientsElement searchSubIngredientsElement1 = new SearchSubIngredientsElement(1L, "name1");
		SearchSubIngredientsElement searchSubIngredientsElement2 = new SearchSubIngredientsElement(2L, "name2");
		List<SearchSubIngredientsElement> searchSubIngredientsElements = new ArrayList<>();
		searchSubIngredientsElements.add(searchSubIngredientsElement1);
		searchSubIngredientsElements.add(searchSubIngredientsElement2);
		String message = "message";
		SearchSubIngredientsDTO searchSubIngredientsDTO = new SearchSubIngredientsDTO(searchSubIngredientsElements, "", message);
		String text = "text";
		when(service.searchSubIngredients(text))
				.thenReturn(searchSubIngredientsDTO);

		mockMvc
				.perform(
						get("/subingredient/search/" + text)
				)
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(view().name("subingredient_list"))
				.andExpect(model().size(1))
				.andExpect(model().attribute("subIngredientList", searchSubIngredientsDTO));
	}
}