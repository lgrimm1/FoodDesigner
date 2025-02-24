package lgrimm.fooddesigner.volume.query.findvolume;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FindVolumeServiceTest {

	@Test
	void noSuchVolume() {
		VolumeEntity emptyEntity = new VolumeEntity();
		VolumeRepository repository = Mockito.mock(VolumeRepository.class);
		when(repository.findById(6L))
				.thenReturn(Optional.empty());

		FindVolumeDTO notFoundVolumeDTO = new FindVolumeDTO(emptyEntity, "No such volume was found.");
		FindVolumeMapper mapper = Mockito.mock(FindVolumeMapper.class);
		when(mapper.toFindVolumeDTO(emptyEntity, "No such volume was found."))
				.thenReturn(notFoundVolumeDTO);

		FindVolumeService service = new FindVolumeService(repository, mapper);
		FindVolumeDTO actualVolumeDTO = service.findVolume(6L);
		assertEquals(notFoundVolumeDTO, actualVolumeDTO);
	}

	@Test
	void foundVolume() {
		VolumeEntity foundEntity = new VolumeEntity(12L, "name", 11D);
		VolumeRepository repository = Mockito.mock(VolumeRepository.class);
		when(repository.findById(12L))
				.thenReturn(Optional.of(foundEntity));

		FindVolumeDTO foundVolumeDTO = new FindVolumeDTO(foundEntity, "");
		FindVolumeMapper mapper = Mockito.mock(FindVolumeMapper.class);
		when(mapper.toFindVolumeDTO(foundEntity, ""))
				.thenReturn(foundVolumeDTO);

		FindVolumeService service = new FindVolumeService(repository, mapper);
		FindVolumeDTO actualDTO = service.findVolume(12L);
		assertEquals(foundVolumeDTO, actualDTO);
	}

	@Test
	void listVolumes() {
		VolumeEntity volumeEntity1 = new VolumeEntity(1L, "name1", 11D);
		VolumeEntity volumeEntity2 = new VolumeEntity(2L, "name2", 22D);
		String message = "message";

		List<VolumeEntity> volumeEntities = new ArrayList<>();
		volumeEntities.add(volumeEntity1);
		volumeEntities.add(volumeEntity2);
		VolumeRepository repository = Mockito.mock(VolumeRepository.class);
		when(repository.findAll())
				.thenReturn(volumeEntities);

		ListVolumesElement listRecipesElement1 = new ListVolumesElement(1L, "name1");
		ListVolumesElement listRecipesElement2 = new ListVolumesElement(2L, "name2");
		List<ListVolumesElement> listRecipesElements = new ArrayList<>();
		listRecipesElements.add(listRecipesElement1);
		listRecipesElements.add(listRecipesElement2);
		ListVolumesDTO listVolumesDTO = new ListVolumesDTO(listRecipesElements, message);
		FindVolumeMapper mapper = Mockito.mock(FindVolumeMapper.class);
		when(mapper.toListVolumesDTO(volumeEntities, message))
				.thenReturn(listVolumesDTO);

		FindVolumeService service = new FindVolumeService(repository, mapper);
		ListVolumesDTO actualListVolumesDTO1 = service.listVolumes(message);
		assertEquals(listRecipesElements, actualListVolumesDTO1.getVolumes());
		assertEquals(message, actualListVolumesDTO1.getMessage());
	}
}