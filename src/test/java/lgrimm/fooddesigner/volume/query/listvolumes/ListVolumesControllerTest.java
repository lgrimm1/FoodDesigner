package lgrimm.fooddesigner.volume.query.listvolumes;

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

@WebMvcTest(ListVolumesController.class)
@AutoConfigureDataJpa
class ListVolumesControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockitoBean
	private ListVolumesService service;

	@Test
	void listVolumes() throws Exception {
		ListVolumesElement listVolumesElement1 = new ListVolumesElement(1L, "name1");
		ListVolumesElement listVolumesElement2 = new ListVolumesElement(2L, "name2");
		List<ListVolumesElement> listVolumesElements = new ArrayList<>();
		listVolumesElements.add(listVolumesElement1);
		listVolumesElements.add(listVolumesElement2);
		ListVolumesDTO listVolumesDTO = new ListVolumesDTO(listVolumesElements, "", "");
		when(service.listVolumes())
				.thenReturn(listVolumesDTO);

		mockMvc
				.perform(
						get("/api/v1/volume/list")
				)
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(jsonPath("$.volumes[0].volumeId").value(listVolumesDTO.getVolumes().get(0).volumeId()))
				.andExpect(jsonPath("$.volumes[0].volumeName").value(listVolumesDTO.getVolumes().get(0).volumeName()))
				.andExpect(jsonPath("$.volumes[1].volumeId").value(listVolumesDTO.getVolumes().get(1).volumeId()))
				.andExpect(jsonPath("$.volumes[1].volumeName").value(listVolumesDTO.getVolumes().get(1).volumeName()))
				.andExpect(jsonPath("$.searchText").value(listVolumesDTO.getSearchText()))
				.andExpect(jsonPath("$.message").value(listVolumesDTO.getMessage()));
	}
}