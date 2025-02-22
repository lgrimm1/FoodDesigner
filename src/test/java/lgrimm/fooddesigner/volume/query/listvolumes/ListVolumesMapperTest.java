package lgrimm.fooddesigner.volume.query.listvolumes;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ListVolumesMapperTest {

	@Test
	void toListVolumesDTO() {
		VolumeEntity volumeEntity1 = new VolumeEntity(1L, "name1", 11D);
		VolumeEntity volumeEntity2 = new VolumeEntity(2L, "name2", 12D);
		List<VolumeEntity> volumeEntities = new ArrayList<>();
		volumeEntities.add(volumeEntity1);
		volumeEntities.add(volumeEntity2);

		ListVolumesElement listVolumesElement1 = new ListVolumesElement(1L, "name1");
		ListVolumesElement listVolumesElement2 = new ListVolumesElement(2L, "name2");
		List<ListVolumesElement> listVolumesElements = new ArrayList<>();
		listVolumesElements.add(listVolumesElement1);
		listVolumesElements.add(listVolumesElement2);

		ListVolumesMapper mapper = new ListVolumesMapper();

		assertThrows(IllegalArgumentException.class, () -> mapper.toListVolumesDTO(null));

		ListVolumesDTO actualListSourcesDTO = mapper.toListVolumesDTO(volumeEntities);
		assertEquals(listVolumesElements, actualListSourcesDTO.getVolumes());
		assertTrue(actualListSourcesDTO.getSearchText().isEmpty());
		assertTrue(actualListSourcesDTO.getMessage().isEmpty());
	}
}