package lgrimm.fooddesigner.source.query.searchsources;

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

@WebMvcTest(SearchSourcesController.class)
@AutoConfigureDataJpa
class SearchSourcesControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockitoBean
	private SearchSourcesService service;

	@Test
	void searchSources() throws Exception {
		SearchSourcesElement searchSourcesElement1 = new SearchSourcesElement(1L, "name1");
		SearchSourcesElement searchSourcesElement2 = new SearchSourcesElement(2L, "name2");
		List<SearchSourcesElement> searchSourcesElements = new ArrayList<>();
		searchSourcesElements.add(searchSourcesElement1);
		searchSourcesElements.add(searchSourcesElement2);
		String message = "message";
		SearchSourcesDTO searchSourcesDTO = new SearchSourcesDTO(searchSourcesElements, "", message);
		String text = "text";
		when(service.searchSources(text))
				.thenReturn(searchSourcesDTO);

		mockMvc
				.perform(
						get("/source/search/" + text)
				)
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(view().name("source_list"))
				.andExpect(model().size(1))
				.andExpect(model().attribute("sourceList", searchSourcesDTO));
	}
}