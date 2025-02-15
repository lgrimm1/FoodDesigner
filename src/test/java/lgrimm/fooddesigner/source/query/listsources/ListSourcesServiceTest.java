package lgrimm.fooddesigner.source.query.listsources;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ListSourcesServiceTest {

	@Test
	void listSources() {
		SourceEntity sourceEntity1 = new SourceEntity(1L, "name1", "webShop1", "openHours1");
		SourceEntity sourceEntity2 = new SourceEntity(2L, "name2", "webShop2", "openHours2");

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
		ListSourcesDTO listSourcesDTO = new ListSourcesDTO(listSourcesElements, "", "");
		ListSourcesMapper mapper = Mockito.mock(ListSourcesMapper.class);
		when(mapper.toListSourcesDTO(sourceEntities))
				.thenReturn(listSourcesDTO);

		ListSourcesService service = new ListSourcesService(repository, mapper);
		ListSourcesDTO actualListSourcesDTO = service.listSources();
		assertEquals(listSourcesElements, actualListSourcesDTO.getSources());
		assertTrue(actualListSourcesDTO.getSearchText().isEmpty());
		assertTrue(actualListSourcesDTO.getMessage().isEmpty());
	}
}