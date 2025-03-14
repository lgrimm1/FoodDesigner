package lgrimm.fooddesigner.subingredient.query.listsubingredients;

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

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(ListSubIngredientsController.class)
@AutoConfigureDataJpa
class ListSubIngredientsControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockitoBean
	private ListSubIngredientsService service;

	@Test
	void listSubIngredients() throws Exception {
		ListSubIngredientsElement listSubIngredientsElement1 = new ListSubIngredientsElement(1L, "name1");
		ListSubIngredientsElement listSubIngredientsElement2 = new ListSubIngredientsElement(2L, "name2");
		List<ListSubIngredientsElement> listSubIngredientsElements = new ArrayList<>();
		listSubIngredientsElements.add(listSubIngredientsElement1);
		listSubIngredientsElements.add(listSubIngredientsElement2);
		ListSubIngredientsDTO listSubIngredientsDTO = new ListSubIngredientsDTO(listSubIngredientsElements, "", "");
		when(service.listSubIngredients())
				.thenReturn(listSubIngredientsDTO);

		mockMvc
				.perform(
						get("/api/v1/subingredient/list")
				)
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(jsonPath("$.subIngredients[0].subIngredientId").value(listSubIngredientsDTO.getSubIngredients().get(0).subIngredientId()))
				.andExpect(jsonPath("$.subIngredients[0].subIngredientName").value(listSubIngredientsDTO.getSubIngredients().get(0).subIngredientName()))
				.andExpect(jsonPath("$.subIngredients[1].subIngredientId").value(listSubIngredientsDTO.getSubIngredients().get(1).subIngredientId()))
				.andExpect(jsonPath("$.subIngredients[1].subIngredientName").value(listSubIngredientsDTO.getSubIngredients().get(1).subIngredientName()))
				.andExpect(jsonPath("$.searchText").value(listSubIngredientsDTO.getSearchText()))
				.andExpect(jsonPath("$.message").value(listSubIngredientsDTO.getMessage()));
	}
}