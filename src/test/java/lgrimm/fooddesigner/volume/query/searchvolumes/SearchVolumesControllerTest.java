package lgrimm.fooddesigner.volume.query.searchvolumes;

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

@WebMvcTest(SearchVolumesController.class)
@AutoConfigureDataJpa
class SearchVolumesControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockitoBean
	private SearchVolumesService service;

	@Test
	void searchVolumes() throws Exception {
		SearchVolumesElement searchVolumesElement1 = new SearchVolumesElement(1L, "name1");
		SearchVolumesElement searchVolumesElement2 = new SearchVolumesElement(2L, "name2");
		List<SearchVolumesElement> searchVolumesElements = new ArrayList<>();
		searchVolumesElements.add(searchVolumesElement1);
		searchVolumesElements.add(searchVolumesElement2);
		String message = "message";
		SearchVolumesDTO searchVolumesDTO = new SearchVolumesDTO(searchVolumesElements, "", message);
		String text = "text";
		when(service.searchVolumes(text))
				.thenReturn(searchVolumesDTO);

		mockMvc
				.perform(
						get("/volume/search/" + text)
				)
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(view().name("volume_list"))
				.andExpect(model().size(1))
				.andExpect(model().attribute("volumeList", searchVolumesDTO));
	}
}
