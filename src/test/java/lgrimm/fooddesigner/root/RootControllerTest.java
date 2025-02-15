package lgrimm.fooddesigner.root;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.test.context.bean.override.mockito.*;
import org.springframework.test.web.servlet.*;

import java.util.*;

import static org.mockito.Mockito.when;

@WebMvcTest(RootController.class)
class RootControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockitoBean
	private RootService service;

	@Test
	void getRoot() throws Exception {
		RootElement rootElement1 = new RootElement(1L, "name1");
		RootElement rootElement2 = new RootElement(2L, "name2");
		List<RootElement> rootElements = new ArrayList<>();
		rootElements.add(rootElement1);
		rootElements.add(rootElement2);
		RootDTO rootDTO = new RootDTO(rootElements, "", "");
		when(service.getRoot())
				.thenReturn(rootDTO);

		mockMvc
				.perform(
						get("/")
				)
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(view().name("recipe_list"))
				.andExpect(model().size(1))
				.andExpect(model().attribute("recipeList", rootDTO));
	}
}