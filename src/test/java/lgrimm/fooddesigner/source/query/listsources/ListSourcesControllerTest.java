package lgrimm.fooddesigner.source.query.listsources;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.*;
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
	private ListSourcesService service;

	@Test
	void listSources() throws Exception {
		ListSourcesElement listSourcesElement1 = new ListSourcesElement(1L, "name1");
		ListSourcesElement listSourcesElement2 = new ListSourcesElement(2L, "name2");
		List<ListSourcesElement> listSourcesElements = new ArrayList<>();
		listSourcesElements.add(listSourcesElement1);
		listSourcesElements.add(listSourcesElement2);
		ListSourcesDTO listSourcesDTO = new ListSourcesDTO(listSourcesElements, "", "");
		when(service.listSources())
				.thenReturn(listSourcesDTO);

		mockMvc
				.perform(
						get("/api/v1/source/list")
				)
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(jsonPath("$.sources[0].sourceId").value(listSourcesDTO.getSources().get(0).sourceId()))
				.andExpect(jsonPath("$.sources[0].sourceName").value(listSourcesDTO.getSources().get(0).sourceName()))
				.andExpect(jsonPath("$.sources[1].sourceId").value(listSourcesDTO.getSources().get(1).sourceId()))
				.andExpect(jsonPath("$.sources[1].sourceName").value(listSourcesDTO.getSources().get(1).sourceName()))
				.andExpect(jsonPath("$.searchText").value(listSourcesDTO.getSearchText()))
				.andExpect(jsonPath("$.message").value(listSourcesDTO.getMessage()));
	}
}