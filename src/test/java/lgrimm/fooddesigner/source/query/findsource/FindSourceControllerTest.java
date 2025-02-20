package lgrimm.fooddesigner.source.query.findsource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.*;
import org.springframework.test.web.servlet.*;

import java.util.*;

import static org.mockito.Mockito.when;

@WebMvcTest(FindSourceController.class)
@AutoConfigureDataJpa
class FindSourceControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockitoBean
	private FindSourceService service;

	@Test
	void findSourceWithExistingSource() throws Exception {
		SourceEntity sourceEntity = new SourceEntity(12L, "name", "webshop", "openHours");
		String message = "";
		FindSourceDTO findSourceDTO = new FindSourceDTO(sourceEntity, message);
		when(service.findSource(12L))
				.thenReturn(findSourceDTO);

		FindSourceController controller = new FindSourceController(service);

		mockMvc
				.perform(
						get("/source/12")
				)
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(view().name("source"))
				.andExpect(model().size(1))
				.andExpect(model().attribute("source", findSourceDTO));
	}

	@Test
	void findSourceWithNotExistingSource() throws Exception {
		SourceEntity source = new SourceEntity();
		String message = "message";
		FindSourceDTO findSourceDTO = new FindSourceDTO(source, message);
		when(service.findSource(12L))
				.thenReturn(findSourceDTO);

		ListSourcesElement element1 = new ListSourcesElement(1L, "name1");
		ListSourcesElement element2 = new ListSourcesElement(2L, "name2");
		List<ListSourcesElement> sources = new ArrayList<>();
		sources.add(element1);
		sources.add(element2);
		ListSourcesDTO listSourcesDTO = new ListSourcesDTO(sources, message);
		when(service.listSources(message))
				.thenReturn(listSourcesDTO);

		FindSourceController controller = new FindSourceController(service);

		mockMvc
				.perform(
						get("/source/12")
				)
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(view().name("source_list"))
				.andExpect(model().size(1))
				.andExpect(model().attribute("sourceList", listSourcesDTO));
	}
}