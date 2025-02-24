package lgrimm.fooddesigner.volume.query.findvolume;

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

import static org.mockito.Mockito.when;

@WebMvcTest(FindVolumeController.class)
@AutoConfigureDataJpa
class FindVolumeControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockitoBean
	private FindVolumeService service;

	@Test
	void findVolumeWithExistingVolume() throws Exception {
		VolumeEntity volumeEntity = new VolumeEntity(12L, "name", 11D);
		String message = "";
		FindVolumeDTO findVolumeDTO = new FindVolumeDTO(volumeEntity, message);
		when(service.findVolume(12L))
				.thenReturn(findVolumeDTO);

		FindVolumeController controller = new FindVolumeController(service);

		mockMvc
				.perform(
						get("/volume/12")
				)
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(view().name("volume"))
				.andExpect(model().size(1))
				.andExpect(model().attribute("volume", findVolumeDTO));
	}

	@Test
	void findVolumeWithNotExistingVolume() throws Exception {
		VolumeEntity volume = new VolumeEntity();
		String message = "message";
		FindVolumeDTO findVolumeDTO = new FindVolumeDTO(volume, message);
		when(service.findVolume(12L))
				.thenReturn(findVolumeDTO);

		ListVolumesElement element1 = new ListVolumesElement(1L, "name1");
		ListVolumesElement element2 = new ListVolumesElement(2L, "name2");
		List<ListVolumesElement> volumes = new ArrayList<>();
		volumes.add(element1);
		volumes.add(element2);
		ListVolumesDTO listVolumesDTO = new ListVolumesDTO(volumes, message);
		when(service.listVolumes(message))
				.thenReturn(listVolumesDTO);

		FindVolumeController controller = new FindVolumeController(service);

		mockMvc
				.perform(
						get("/volume/12")
				)
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(view().name("volume_list"))
				.andExpect(model().size(1))
				.andExpect(model().attribute("volumeList", listVolumesDTO));
	}
}