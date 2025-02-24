package lgrimm.fooddesigner.source.query.listsources;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ListSourcesMapperTest {
	@Test
	void toListSourcesDTO() {
		SourceEntity sourceEntity1 = new SourceEntity(1L, "name1", "webShop1", "openHours1");
		SourceEntity sourceEntity2 = new SourceEntity(2L, "name2", "webShop2", "openHours2");
		List<SourceEntity> sourceEntities = new ArrayList<>();
		sourceEntities.add(sourceEntity1);
		sourceEntities.add(sourceEntity2);

		ListSourcesElement listSourcesElement1 = new ListSourcesElement(1L, "name1");
		ListSourcesElement listSourcesElement2 = new ListSourcesElement(2L, "name2");
		List<ListSourcesElement> listSourcesElements = new ArrayList<>();
		listSourcesElements.add(listSourcesElement1);
		listSourcesElements.add(listSourcesElement2);

		ListSourcesMapper mapper = new ListSourcesMapper();

		assertThrows(IllegalArgumentException.class, () -> mapper.toListSourcesDTO(null));

		ListSourcesDTO actualListSourcesDTO = mapper.toListSourcesDTO(sourceEntities);
		assertEquals(listSourcesElements, actualListSourcesDTO.getSources());
		assertTrue(actualListSourcesDTO.getSearchText().isEmpty());
		assertTrue(actualListSourcesDTO.getMessage().isEmpty());
	}
}