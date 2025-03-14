package lgrimm.fooddesigner.ingredient.query.listingredients;

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

import static org.mockito.Mockito.when;

@WebMvcTest(ListIngredientsController.class)
@AutoConfigureDataJpa
class ListIngredientsControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockitoBean
	private ListIngredientsService service;

	@Test
	void listIngredients() throws Exception {
		ListIngredientsElement listIngredientsElement1 = new ListIngredientsElement(1L, "name1");
		ListIngredientsElement listIngredientsElement2 = new ListIngredientsElement(2L, "name2");
		List<ListIngredientsElement> listIngredientsElements = new ArrayList<>();
		listIngredientsElements.add(listIngredientsElement1);
		listIngredientsElements.add(listIngredientsElement2);
		ListIngredientsDTO listIngredientsDTO = new ListIngredientsDTO(listIngredientsElements, "", "");
		when(service.listIngredients())
				.thenReturn(listIngredientsDTO);

		mockMvc
				.perform(
						get("/api/v1/ingredient/list")
				)
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(jsonPath("$.ingredients[0].ingredientId").value(listIngredientsDTO.getIngredients().get(0).ingredientId()))
				.andExpect(jsonPath("$.ingredients[0].ingredientName").value(listIngredientsDTO.getIngredients().get(0).ingredientName()))
				.andExpect(jsonPath("$.ingredients[1].ingredientId").value(listIngredientsDTO.getIngredients().get(1).ingredientId()))
				.andExpect(jsonPath("$.ingredients[1].ingredientName").value(listIngredientsDTO.getIngredients().get(1).ingredientName()))
				.andExpect(jsonPath("$.searchText").value(listIngredientsDTO.getSearchText()))
				.andExpect(jsonPath("$.message").value(listIngredientsDTO.getMessage()));
	}
}