package lgrimm.fooddesigner.volume.query.searchvolumes;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SearchVolumesMapperTest {

	@Test
	void toSearchVolumesDTO() {
		VolumeEntity volumeEntity1 = new VolumeEntity(1L, "name1", 11D);
		VolumeEntity volumeEntity2 = new VolumeEntity(2L, "name2", 22D);
		List<VolumeEntity> volumeEntities = new ArrayList<>();
		volumeEntities.add(volumeEntity1);
		volumeEntities.add(volumeEntity2);
		String message = "message";

		SearchVolumesElement searchVolumesElement1 = new SearchVolumesElement(1L, "name1");
		SearchVolumesElement searchVolumesElement2 = new SearchVolumesElement(2L, "name2");
		List<SearchVolumesElement> searchVolumesElements = new ArrayList<>();
		searchVolumesElements.add(searchVolumesElement1);
		searchVolumesElements.add(searchVolumesElement2);

		SearchVolumesMapper mapper = new SearchVolumesMapper();

		assertThrows(IllegalArgumentException.class, () -> mapper.toSearchVolumesDTO(null, message));
		assertThrows(IllegalArgumentException.class, () -> mapper.toSearchVolumesDTO(volumeEntities, null));

		SearchVolumesDTO actualSearchVolumesDTO = mapper.toSearchVolumesDTO(volumeEntities, message);
		assertEquals(searchVolumesElements, actualSearchVolumesDTO.getVolumes());
		assertTrue(actualSearchVolumesDTO.getSearchText().isEmpty());
		assertEquals(message, actualSearchVolumesDTO.getMessage());
	}
}