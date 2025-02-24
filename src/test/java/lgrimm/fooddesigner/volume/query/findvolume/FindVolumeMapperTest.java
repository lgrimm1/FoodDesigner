package lgrimm.fooddesigner.volume.query.findvolume;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FindVolumeMapperTest {

	@Test
	void toFindVolumeDTO() {
		VolumeEntity entity = new VolumeEntity(1L, "name1", 11D);
		String message = "message";
		FindVolumeMapper mapper = new FindVolumeMapper();

		assertThrows(IllegalArgumentException.class, () -> mapper.toFindVolumeDTO(null, message));
		assertThrows(IllegalArgumentException.class, () -> mapper.toFindVolumeDTO(entity, null));

		FindVolumeDTO findVolumeDTO = mapper.toFindVolumeDTO(entity, message);
		assertEquals(entity, findVolumeDTO.getVolume());
		assertEquals(message, findVolumeDTO.getMessage());
	}

	@Test
	void toListVolumesDTO() {
		VolumeEntity volumeEntity1 = new VolumeEntity(1L, "name1", 11D);
		VolumeEntity volumeEntity2 = new VolumeEntity(2L, "name2", 22D);
		List<VolumeEntity> volumeEntities = new ArrayList<>();
		volumeEntities.add(volumeEntity1);
		volumeEntities.add(volumeEntity2);
		String message = "message";

		ListVolumesElement listRecipesElement1 = new ListVolumesElement(1L, "name1");
		ListVolumesElement listRecipesElement2 = new ListVolumesElement(2L, "name2");
		List<ListVolumesElement> listRecipesElements = new ArrayList<>();
		listRecipesElements.add(listRecipesElement1);
		listRecipesElements.add(listRecipesElement2);

		FindVolumeMapper mapper = new FindVolumeMapper();

		assertThrows(IllegalArgumentException.class, () -> mapper.toListVolumesDTO(null, message));
		assertThrows(IllegalArgumentException.class, () -> mapper.toListVolumesDTO(volumeEntities, null));

		ListVolumesDTO actualListVolumesDTO = mapper.toListVolumesDTO(volumeEntities, message);
		assertEquals(listRecipesElements, actualListVolumesDTO.getVolumes());
		assertEquals(message, actualListVolumesDTO.getMessage());
	}
}