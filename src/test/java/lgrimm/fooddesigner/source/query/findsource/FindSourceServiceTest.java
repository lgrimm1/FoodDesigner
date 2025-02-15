package lgrimm.fooddesigner.source.query.findsource;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FindSourceServiceTest {

	@Test
	void noSuchSource() {
		SourceEntity emptyEntity = new SourceEntity();
		SourceRepository repository = Mockito.mock(SourceRepository.class);
		when(repository.findById(6L))
				.thenReturn(Optional.empty());

		FindSourceDTO notFoundSourceDTO = new FindSourceDTO(emptyEntity, "No such source was found.");
		FindSourceMapper mapper = Mockito.mock(FindSourceMapper.class);
		when(mapper.toFindSourcesDTO(emptyEntity, "No such source was found."))
				.thenReturn(notFoundSourceDTO);

		FindSourceService service = new FindSourceService(repository, mapper);
		FindSourceDTO actualSourceDTO = service.findSource(6L);
		assertEquals(notFoundSourceDTO, actualSourceDTO);
	}

	@Test
	void foundSource() {
		SourceEntity foundEntity = new SourceEntity(12L, "name", "webshop", "openHours");
		SourceRepository repository = Mockito.mock(SourceRepository.class);
		when(repository.findById(12L))
				.thenReturn(Optional.of(foundEntity));

		FindSourceDTO foundSourceDTO = new FindSourceDTO(foundEntity, "");
		FindSourceMapper mapper = Mockito.mock(FindSourceMapper.class);
		when(mapper.toFindSourcesDTO(foundEntity, ""))
				.thenReturn(foundSourceDTO);

		FindSourceService service = new FindSourceService(repository, mapper);
		FindSourceDTO actualDTO = service.findSource(12L);
		assertEquals(foundSourceDTO, actualDTO);
	}

	@Test
	void listSources() {
		SourceEntity sourceEntity1 = new SourceEntity(1L, "name1", "webshop1", "openHours1");
		SourceEntity sourceEntity2 = new SourceEntity(2L, "name2", "webshop2", "openHours2");
		String message = "message";

		List<SourceEntity> sourceEntities = new ArrayList<>();
		sourceEntities.add(sourceEntity1);
		sourceEntities.add(sourceEntity2);
		SourceRepository repository = Mockito.mock(SourceRepository.class);
		when(repository.findAll())
				.thenReturn(sourceEntities);

		ListSourcesElement listSourcesElement1 = new ListSourcesElement(1L, "name1");
		ListSourcesElement listSourcesElement2 = new ListSourcesElement(2L, "name2");
		List<ListSourcesElement> listSourcesElements = new ArrayList<>();
		listSourcesElements.add(listSourcesElement1);
		listSourcesElements.add(listSourcesElement2);
		ListSourcesDTO listSourcesDTO = new ListSourcesDTO(listSourcesElements, message);
		FindSourceMapper mapper = Mockito.mock(FindSourceMapper.class);
		when(mapper.toListSourcesDTO(sourceEntities, message))
				.thenReturn(listSourcesDTO);

		FindSourceService service = new FindSourceService(repository, mapper);
		ListSourcesDTO actualListSourcesDTO1 = service.listSources(message);
		assertEquals(listSourcesElements, actualListSourcesDTO1.getSources());
		assertEquals(message, actualListSourcesDTO1.getMessage());
	}
}