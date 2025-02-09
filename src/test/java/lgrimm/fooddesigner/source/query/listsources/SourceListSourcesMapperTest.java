package lgrimm.fooddesigner.source.query.listsources;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SourceListSourcesMapperTest {
	@Test
	void toListSourcesDTO() {
		SourceEntity sourceEntity1 = new SourceEntity(1L, "name1", "webshop1", "openHours1");
		SourceEntity sourceEntity2 = new SourceEntity(2L, "name2", "webshop2", "openHours2");
		List<SourceEntity> sourceEntities = new ArrayList<>();
		sourceEntities.add(sourceEntity1);
		sourceEntities.add(sourceEntity2);
		String message = "message";

		ListSourcesElement listSourcesElement1 = new ListSourcesElement(1L, "name1");
		ListSourcesElement listSourcesElement2 = new ListSourcesElement(2L, "name2");
		List<ListSourcesElement> listSourcesElements = new ArrayList<>();
		listSourcesElements.add(listSourcesElement1);
		listSourcesElements.add(listSourcesElement2);

		SourceListSourcesMapper mapper = new SourceListSourcesMapper();

		assertThrows(IllegalArgumentException.class, () -> mapper.toListSourcesDTO(null, message));
		assertThrows(IllegalArgumentException.class, () -> mapper.toListSourcesDTO(sourceEntities, null));

		ListSourcesDTO actualListSourcesDTO = mapper.toListSourcesDTO(sourceEntities, message);
		assertEquals(listSourcesElements, actualListSourcesDTO.getSources());
		assertEquals(message, actualListSourcesDTO.getMessage());
	}
}