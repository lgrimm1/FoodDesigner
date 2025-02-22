package lgrimm.fooddesigner.volume.query.listvolumes;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ListVolumesServiceTest {

	@Test
	void listVolumes() {
		VolumeEntity volumeEntity1 = new VolumeEntity(1L, "name1", 11D);
		VolumeEntity volumeEntity2 = new VolumeEntity(2L, "name2", 21D);

		List<VolumeEntity> volumeEntities = new ArrayList<>();
		volumeEntities.add(volumeEntity1);
		volumeEntities.add(volumeEntity2);
		VolumeRepository repository = Mockito.mock(VolumeRepository.class);
		when(repository.findAll())
				.thenReturn(volumeEntities);

		ListVolumesElement listVolumesElement1 = new ListVolumesElement(1L, "name1");
		ListVolumesElement listVolumesElement2 = new ListVolumesElement(2L, "name2");
		List<ListVolumesElement> listVolumesElements = new ArrayList<>();
		listVolumesElements.add(listVolumesElement1);
		listVolumesElements.add(listVolumesElement2);
		ListVolumesDTO listVolumesDTO = new ListVolumesDTO(listVolumesElements, "", "");
		ListVolumesMapper mapper = Mockito.mock(ListVolumesMapper.class);
		when(mapper.toListVolumesDTO(volumeEntities))
				.thenReturn(listVolumesDTO);

		ListVolumesService service = new ListVolumesService(repository, mapper);
		ListVolumesDTO actualListVolumesDTO = service.listVolumes();
		assertEquals(listVolumesDTO, actualListVolumesDTO);
		assertTrue(actualListVolumesDTO.getSearchText().isEmpty());
		assertTrue(actualListVolumesDTO.getMessage().isEmpty());
	}
}