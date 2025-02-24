package lgrimm.fooddesigner.source.query.searchsources;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SearchSourcesMapperTest {

	@Test
	void toSearchSourcesDTO() {
		SourceEntity sourceEntity1 = new SourceEntity(1L, "name1", "webShop1", "openHours1");
		SourceEntity sourceEntity2 = new SourceEntity(2L, "name2", "webShop2", "openHours2");
		List<SourceEntity> sourceEntities = new ArrayList<>();
		sourceEntities.add(sourceEntity1);
		sourceEntities.add(sourceEntity2);
		String message = "message";

		SearchSourcesElement searchSourcesElement1 = new SearchSourcesElement(1L, "name1");
		SearchSourcesElement searchSourcesElement2 = new SearchSourcesElement(2L, "name2");
		List<SearchSourcesElement> searchSourcesElements = new ArrayList<>();
		searchSourcesElements.add(searchSourcesElement1);
		searchSourcesElements.add(searchSourcesElement2);

		SearchSourcesMapper mapper = new SearchSourcesMapper();

		assertThrows(IllegalArgumentException.class, () -> mapper.toSearchSourcesDTO(null, message));
		assertThrows(IllegalArgumentException.class, () -> mapper.toSearchSourcesDTO(sourceEntities, null));

		SearchSourcesDTO actualSearchSourcesDTO = mapper.toSearchSourcesDTO(sourceEntities, message);
		assertEquals(searchSourcesElements, actualSearchSourcesDTO.getSources());
		assertTrue(actualSearchSourcesDTO.getSearchText().isEmpty());
		assertEquals(message, actualSearchSourcesDTO.getMessage());
	}
}