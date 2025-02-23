package lgrimm.fooddesigner.source.query.searchsources;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class SearchSourcesServiceTest {

	@Test
	void searchSourcesNullArgument() {
		SearchSourcesMapper mapper = Mockito.mock(SearchSourcesMapper.class);
		SourceRepository repository = Mockito.mock(SourceRepository.class);
		SearchSourcesService service = new SearchSourcesService(repository, mapper);

		assertThrows(IllegalArgumentException.class, () -> service.searchSources(null));
	}

	@Test
	void searchSourcesBlankArgument() {
		String text = "  ";

		SearchSourcesMapper mapper = Mockito.mock(SearchSourcesMapper.class);
		SourceRepository repository = Mockito.mock(SourceRepository.class);
		SearchSourcesService service = new SearchSourcesService(repository, mapper);

		SearchSourcesDTO searchSourcesDTO = service.searchSources(text);
		assertEquals("No text were given.", searchSourcesDTO.getMessage());
		assertTrue(searchSourcesDTO.getSources().isEmpty());
		assertTrue(searchSourcesDTO.getSearchText().isEmpty());
	}

	@Test
	void searchSourcesNoMatch() {
		SourceRepository repository = Mockito.mock(SourceRepository.class);
		when(repository.findAllByName("name"))
				.thenReturn(new ArrayList<SourceEntity>());

		SearchSourcesDTO searchSourcesDTO = new SearchSourcesDTO(new ArrayList<SearchSourcesElement>(), "", "Found 0 occurrence(s).");
		SearchSourcesMapper mapper = Mockito.mock(SearchSourcesMapper.class);
		when(mapper.toSearchSourcesDTO(new ArrayList<SourceEntity>(), "Found 0 occurrence(s)."))
				.thenReturn(searchSourcesDTO);

		SearchSourcesService service = new SearchSourcesService(repository, mapper);
		SearchSourcesDTO actualSearchSourcesDTO = service.searchSources("name");
		assertEquals(new ArrayList<SearchSourcesElement>(), actualSearchSourcesDTO.getSources());
		assertEquals("Found 0 occurrence(s).", actualSearchSourcesDTO.getMessage());
		assertTrue(actualSearchSourcesDTO.getSearchText().isEmpty());
	}

	@Test
	void searchSourcesOneWord() {
		SourceEntity sourceEntity1 = new SourceEntity(1L, "name", "webshop1", "openHours1");
		SourceEntity sourceEntity2 = new SourceEntity(2L, "name", "webshop2", "openHours2");
		List<SourceEntity> sourceEntities = new ArrayList<>();
		sourceEntities.add(sourceEntity1);
		sourceEntities.add(sourceEntity2);
		SourceRepository repository = Mockito.mock(SourceRepository.class);
		when(repository.findAllByName("name"))
				.thenReturn(sourceEntities);
		when(repository.findAllById(new HashSet<>(List.of(1L, 2L))))
				.thenReturn(sourceEntities);

		SearchSourcesElement searchSourcesElement1 = new SearchSourcesElement(1L, "name");
		SearchSourcesElement searchSourcesElement2 = new SearchSourcesElement(2L, "name");
		List<SearchSourcesElement> searchSourcesElements = new ArrayList<>();
		searchSourcesElements.add(searchSourcesElement1);
		searchSourcesElements.add(searchSourcesElement2);
		SearchSourcesDTO searchSourcesDTO = new SearchSourcesDTO(searchSourcesElements, "", "Found 2 occurrence(s).");
		SearchSourcesMapper mapper = Mockito.mock(SearchSourcesMapper.class);
		when(mapper.toSearchSourcesDTO(sourceEntities, "Found 2 occurrence(s)."))
				.thenReturn(searchSourcesDTO);

		SearchSourcesService service = new SearchSourcesService(repository, mapper);
		SearchSourcesDTO actualSearchSourcesDTO = service.searchSources("name");
		assertEquals(searchSourcesDTO.getSources(), actualSearchSourcesDTO.getSources());
		assertEquals("Found 2 occurrence(s).", actualSearchSourcesDTO.getMessage());
		assertTrue(actualSearchSourcesDTO.getSearchText().isEmpty());
	}

	@Test
	void searchSourcesMoreWordsWithMoreSpacesBetween() {
		SourceEntity sourceEntity1 = new SourceEntity(1L, "name", "webshop1", "openHours1");
		SourceEntity sourceEntity2 = new SourceEntity(2L, "name", "webshop2", "openHours2");
		SourceEntity sourceEntity3 = new SourceEntity(3L, "xyz", "webshop3", "openHours3");
		SourceEntity sourceEntity4 = new SourceEntity(4L, "name   xyz", "webshop4", "openHours4");
		List<SourceEntity> sourceEntities = new ArrayList<>();
		sourceEntities.add(sourceEntity1);
		sourceEntities.add(sourceEntity2);
		sourceEntities.add(sourceEntity3);
		sourceEntities.add(sourceEntity4);
		SourceRepository repository = Mockito.mock(SourceRepository.class);
		when(repository.findAllByName("name   xyz"))
				.thenReturn(sourceEntities.subList(3, 4));
		when(repository.findAllByName("name"))
				.thenReturn(sourceEntities.subList(0, 2));
		when(repository.findAllByName("xyz"))
				.thenReturn(sourceEntities.subList(2, 3));
		when(repository.findAllById(new HashSet<>(Set.of(4L, 1L, 2L, 3L))))
				.thenReturn(sourceEntities);

		SearchSourcesElement searchSourcesElement1 = new SearchSourcesElement(4L, "name   xyz");
		SearchSourcesElement searchSourcesElement2 = new SearchSourcesElement(1L, "name");
		SearchSourcesElement searchSourcesElement3 = new SearchSourcesElement(2L, "name");
		SearchSourcesElement searchSourcesElement4 = new SearchSourcesElement(3L, "xyz");
		List<SearchSourcesElement> searchSourcesElements = new ArrayList<>();
		searchSourcesElements.add(searchSourcesElement1);
		searchSourcesElements.add(searchSourcesElement2);
		searchSourcesElements.add(searchSourcesElement3);
		searchSourcesElements.add(searchSourcesElement4);
		SearchSourcesDTO searchSourcesDTO = new SearchSourcesDTO(searchSourcesElements, "", "Found 4 occurrence(s).");
		SearchSourcesMapper mapper = Mockito.mock(SearchSourcesMapper.class);
		when(mapper.toSearchSourcesDTO(sourceEntities, "Found 4 occurrence(s)."))
				.thenReturn(searchSourcesDTO);

		SearchSourcesService service = new SearchSourcesService(repository, mapper);
		SearchSourcesDTO actualSearchSourcesDTO = service.searchSources("name   xyz");
		assertEquals(searchSourcesDTO.getSources(), actualSearchSourcesDTO.getSources());
		assertEquals("Found 4 occurrence(s).", actualSearchSourcesDTO.getMessage());
		assertTrue(actualSearchSourcesDTO.getSearchText().isEmpty());
	}

	@Test
	void listSources() {
		SourceEntity sourceEntity1 = new SourceEntity(1L, "name1", "webshop1", "openHours1");
		SourceEntity sourceEntity2 = new SourceEntity(2L, "name2", "webshop2", "openHours2");
		List<SourceEntity> sourceEntities = new ArrayList<>();
		sourceEntities.add(sourceEntity1);
		sourceEntities.add(sourceEntity2);
		SourceRepository repository = Mockito.mock(SourceRepository.class);
		when(repository.findAll())
				.thenReturn(sourceEntities);

		SearchSourcesElement searchSourcesElement1 = new SearchSourcesElement(1L, "name1");
		SearchSourcesElement searchSourcesElement2 = new SearchSourcesElement(2L, "name2");
		List<SearchSourcesElement> searchSourcesElements = new ArrayList<>();
		searchSourcesElements.add(searchSourcesElement1);
		searchSourcesElements.add(searchSourcesElement2);
		SearchSourcesDTO searchSourcesDTO = new SearchSourcesDTO(searchSourcesElements, "", "Something went wrong, returned full list.");
		SearchSourcesMapper mapper = Mockito.mock(SearchSourcesMapper.class);
		when(mapper.toSearchSourcesDTO(sourceEntities, "Something went wrong, returned full list."))
				.thenReturn(searchSourcesDTO);

		SearchSourcesService service = new SearchSourcesService(repository, mapper);
		SearchSourcesDTO actualSearchSourcesDTO = service.listSources();
		assertEquals(searchSourcesDTO.getSources(), actualSearchSourcesDTO.getSources());
		assertEquals("Something went wrong, returned full list.", actualSearchSourcesDTO.getMessage());
		assertTrue(actualSearchSourcesDTO.getSearchText().isEmpty());
	}
}