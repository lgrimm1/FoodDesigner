package lgrimm.fooddesigner.subingredient.query.findsubingredient;

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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebMvcTest(FindSubIngredientController.class)
@AutoConfigureDataJpa
class FindSubIngredientControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockitoBean
	private FindSubIngredientService service;

	@Test
	void findSubIngredientWithExistingSubIngredient() throws Exception {
		SubIngredientEntity subIngredientEntity = new SubIngredientEntity(12L, "name", "allergen");
		String message = "";
		FindSubIngredientDTO findSubIngredientDTO = new FindSubIngredientDTO(subIngredientEntity, message);
		when(service.findSubIngredient(12L))
				.thenReturn(findSubIngredientDTO);

		FindSubIngredientController controller = new FindSubIngredientController(service);

		mockMvc
				.perform(
						get("/subIngredient/12")
				)
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(view().name("subIngredient"))
				.andExpect(model().size(1))
				.andExpect(model().attribute("subIngredient", findSubIngredientDTO));
	}

	@Test
	void findSubIngredientWithNotExistingSubIngredient() throws Exception {
		SubIngredientEntity subIngredient = new SubIngredientEntity();
		String message = "message";
		FindSubIngredientDTO findSubIngredientDTO = new FindSubIngredientDTO(subIngredient, message);
		when(service.findSubIngredient(12L))
				.thenReturn(findSubIngredientDTO);

		ListSubIngredientsElement element1 = new ListSubIngredientsElement(1L, "name1");
		ListSubIngredientsElement element2 = new ListSubIngredientsElement(2L, "name2");
		List<ListSubIngredientsElement> subIngredients = new ArrayList<>();
		subIngredients.add(element1);
		subIngredients.add(element2);
		ListSubIngredientsDTO listSubIngredientsDTO = new ListSubIngredientsDTO(subIngredients, message);
		when(service.listSubIngredients(message))
				.thenReturn(listSubIngredientsDTO);

		FindSubIngredientController controller = new FindSubIngredientController(service);

		mockMvc
				.perform(
						get("/subIngredient/12")
				)
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(view().name("subIngredient_list"))
				.andExpect(model().size(1))
				.andExpect(model().attribute("subIngredientList", listSubIngredientsDTO));
	}
}
