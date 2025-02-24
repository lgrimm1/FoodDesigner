package lgrimm.fooddesigner.volume.query.searchvolumes;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class SearchVolumesServiceTest {

	@Test
	void searchVolumesNullArgument() {
		SearchVolumesMapper mapper = Mockito.mock(SearchVolumesMapper.class);
		VolumeRepository repository = Mockito.mock(VolumeRepository.class);
		SearchVolumesService service = new SearchVolumesService(repository, mapper);

		assertThrows(IllegalArgumentException.class, () -> service.searchVolumes(null));
	}

	@Test
	void searchVolumesBlankArgument() {
		String text = "  ";

		SearchVolumesMapper mapper = Mockito.mock(SearchVolumesMapper.class);
		VolumeRepository repository = Mockito.mock(VolumeRepository.class);
		SearchVolumesService service = new SearchVolumesService(repository, mapper);

		SearchVolumesDTO searchVolumesDTO = service.searchVolumes(text);
		assertEquals("No text were given.", searchVolumesDTO.getMessage());
		assertTrue(searchVolumesDTO.getVolumes().isEmpty());
		assertTrue(searchVolumesDTO.getSearchText().isEmpty());
	}

	@Test
	void searchVolumesNoMatch() {
		VolumeRepository repository = Mockito.mock(VolumeRepository.class);
		when(repository.findAllByName("name"))
				.thenReturn(new ArrayList<>());

		SearchVolumesDTO searchVolumesDTO = new SearchVolumesDTO(new ArrayList<>(), "", "Found 0 occurrence(s).");
		SearchVolumesMapper mapper = Mockito.mock(SearchVolumesMapper.class);
		when(mapper.toSearchVolumesDTO(new ArrayList<>(), "Found 0 occurrence(s)."))
				.thenReturn(searchVolumesDTO);

		SearchVolumesService service = new SearchVolumesService(repository, mapper);
		SearchVolumesDTO actualSearchVolumesDTO = service.searchVolumes("name");
		assertEquals(new ArrayList<SearchVolumesElement>(), actualSearchVolumesDTO.getVolumes());
		assertEquals("Found 0 occurrence(s).", actualSearchVolumesDTO.getMessage());
		assertTrue(actualSearchVolumesDTO.getSearchText().isEmpty());
	}

	@Test
	void searchVolumesOneWord() {
		VolumeEntity volumeEntity1 = new VolumeEntity(1L, "name", 11D);
		VolumeEntity volumeEntity2 = new VolumeEntity(2L, "name", 22D);
		List<VolumeEntity> volumeEntities = new ArrayList<>();
		volumeEntities.add(volumeEntity1);
		volumeEntities.add(volumeEntity2);
		VolumeRepository repository = Mockito.mock(VolumeRepository.class);
		when(repository.findAllByName("name"))
				.thenReturn(volumeEntities);
		when(repository.findAllById(new HashSet<>(List.of(1L, 2L))))
				.thenReturn(volumeEntities);

		SearchVolumesElement searchVolumesElement1 = new SearchVolumesElement(1L, "name");
		SearchVolumesElement searchVolumesElement2 = new SearchVolumesElement(2L, "name");
		List<SearchVolumesElement> searchVolumesElements = new ArrayList<>();
		searchVolumesElements.add(searchVolumesElement1);
		searchVolumesElements.add(searchVolumesElement2);
		SearchVolumesDTO searchVolumesDTO = new SearchVolumesDTO(searchVolumesElements, "", "Found 2 occurrence(s).");
		SearchVolumesMapper mapper = Mockito.mock(SearchVolumesMapper.class);
		when(mapper.toSearchVolumesDTO(volumeEntities, "Found 2 occurrence(s)."))
				.thenReturn(searchVolumesDTO);

		SearchVolumesService service = new SearchVolumesService(repository, mapper);
		SearchVolumesDTO actualSearchVolumesDTO = service.searchVolumes("name");
		assertEquals(searchVolumesDTO.getVolumes(), actualSearchVolumesDTO.getVolumes());
		assertEquals("Found 2 occurrence(s).", actualSearchVolumesDTO.getMessage());
		assertTrue(actualSearchVolumesDTO.getSearchText().isEmpty());
	}

	@Test
	void searchVolumesMoreWordsWithMoreSpacesBetween() {
		VolumeEntity volumeEntity1 = new VolumeEntity(1L, "name", 11D);
		VolumeEntity volumeEntity2 = new VolumeEntity(2L, "name", 22D);
		VolumeEntity volumeEntity3 = new VolumeEntity(3L, "xyz", 33D);
		VolumeEntity volumeEntity4 = new VolumeEntity(4L, "name   xyz", 44D);
		List<VolumeEntity> volumeEntities = new ArrayList<>();
		volumeEntities.add(volumeEntity1);
		volumeEntities.add(volumeEntity2);
		volumeEntities.add(volumeEntity3);
		volumeEntities.add(volumeEntity4);
		VolumeRepository repository = Mockito.mock(VolumeRepository.class);
		when(repository.findAllByName("name   xyz"))
				.thenReturn(volumeEntities.subList(3, 4));
		when(repository.findAllByName("name"))
				.thenReturn(volumeEntities.subList(0, 2));
		when(repository.findAllByName("xyz"))
				.thenReturn(volumeEntities.subList(2, 3));
		when(repository.findAllById(new HashSet<>(Set.of(4L, 1L, 2L, 3L))))
				.thenReturn(volumeEntities);

		SearchVolumesElement searchVolumesElement1 = new SearchVolumesElement(4L, "name   xyz");
		SearchVolumesElement searchVolumesElement2 = new SearchVolumesElement(1L, "name");
		SearchVolumesElement searchVolumesElement3 = new SearchVolumesElement(2L, "name");
		SearchVolumesElement searchVolumesElement4 = new SearchVolumesElement(3L, "xyz");
		List<SearchVolumesElement> searchVolumesElements = new ArrayList<>();
		searchVolumesElements.add(searchVolumesElement1);
		searchVolumesElements.add(searchVolumesElement2);
		searchVolumesElements.add(searchVolumesElement3);
		searchVolumesElements.add(searchVolumesElement4);
		SearchVolumesDTO searchVolumesDTO = new SearchVolumesDTO(searchVolumesElements, "", "Found 4 occurrence(s).");
		SearchVolumesMapper mapper = Mockito.mock(SearchVolumesMapper.class);
		when(mapper.toSearchVolumesDTO(volumeEntities, "Found 4 occurrence(s)."))
				.thenReturn(searchVolumesDTO);

		SearchVolumesService service = new SearchVolumesService(repository, mapper);
		SearchVolumesDTO actualSearchVolumesDTO = service.searchVolumes("name   xyz");
		assertEquals(searchVolumesDTO.getVolumes(), actualSearchVolumesDTO.getVolumes());
		assertEquals("Found 4 occurrence(s).", actualSearchVolumesDTO.getMessage());
		assertTrue(actualSearchVolumesDTO.getSearchText().isEmpty());
	}

	@Test
	void listVolumes() {
		VolumeEntity volumeEntity1 = new VolumeEntity(1L, "name1", 11D);
		VolumeEntity volumeEntity2 = new VolumeEntity(2L, "name2", 22D);
		List<VolumeEntity> volumeEntities = new ArrayList<>();
		volumeEntities.add(volumeEntity1);
		volumeEntities.add(volumeEntity2);
		VolumeRepository repository = Mockito.mock(VolumeRepository.class);
		when(repository.findAll())
				.thenReturn(volumeEntities);

		SearchVolumesElement searchVolumesElement1 = new SearchVolumesElement(1L, "name1");
		SearchVolumesElement searchVolumesElement2 = new SearchVolumesElement(2L, "name2");
		List<SearchVolumesElement> searchVolumesElements = new ArrayList<>();
		searchVolumesElements.add(searchVolumesElement1);
		searchVolumesElements.add(searchVolumesElement2);
		SearchVolumesDTO searchVolumesDTO = new SearchVolumesDTO(searchVolumesElements, "", "Something went wrong, returned full list.");
		SearchVolumesMapper mapper = Mockito.mock(SearchVolumesMapper.class);
		when(mapper.toSearchVolumesDTO(volumeEntities, "Something went wrong, returned full list."))
				.thenReturn(searchVolumesDTO);

		SearchVolumesService service = new SearchVolumesService(repository, mapper);
		SearchVolumesDTO actualSearchVolumesDTO = service.listVolumes();
		assertEquals(searchVolumesDTO.getVolumes(), actualSearchVolumesDTO.getVolumes());
		assertEquals("Something went wrong, returned full list.", actualSearchVolumesDTO.getMessage());
		assertTrue(actualSearchVolumesDTO.getSearchText().isEmpty());
	}
}