package lgrimm.fooddesigner.sourcemanagement.queryservices.rootservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.bean.override.mockito.*;
import org.springframework.test.web.servlet.*;
import org.springframework.web.servlet.*;

import java.util.*;

import static org.mockito.Mockito.when;

@WebMvcTest(RootController.class)
@AutoConfigureDataJpa
class RootControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockitoBean
	private RootService rootService;

	@Test
	public void getRoot() throws Exception {
		List<SourceListElement> sourceList = List.of(
				new SourceListElement(1L, "name1"),
				new SourceListElement(2L, "name2")
		);
		when(rootService.getRoot())
				.thenReturn(sourceList);

		mockMvc
				.perform(
						get("/")
				)
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(view().name("source_list"))
				.andExpect(model().size(1))
				.andExpect(model().attribute("sourceList", sourceList));
	}
}