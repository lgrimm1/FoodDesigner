package lgrimm.fooddesigner.source.query.listsources;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.*;
import org.springframework.test.web.servlet.*;

import java.util.*;

import static org.mockito.Mockito.when;

@WebMvcTest(ListSourcesController.class)
@AutoConfigureDataJpa
class ListSourcesControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockitoBean
	private ListSourcesService listSourcesService;

	@Test
	void listSources() throws Exception {
		ListSourcesElement listSourcesElement1 = new ListSourcesElement(1L, "name1");
		ListSourcesElement listSourcesElement2 = new ListSourcesElement(2L, "name2");
		List<ListSourcesElement> listSourcesElements = new ArrayList<>();
		listSourcesElements.add(listSourcesElement1);
		listSourcesElements.add(listSourcesElement2);
		String message = "";
		ListSourcesDTO listSourcesDTO = new ListSourcesDTO(listSourcesElements, message);
		when(listSourcesService.listSources())
				.thenReturn(listSourcesDTO);

		mockMvc
				.perform(
						get("/source/list")
				)
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(view().name("source_list"))
				.andExpect(model().size(1))
				.andExpect(model().attribute("sourceList", listSourcesDTO));
	}
}