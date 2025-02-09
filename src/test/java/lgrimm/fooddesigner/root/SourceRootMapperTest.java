package lgrimm.fooddesigner.root;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SourceRootMapperTest {

	@Test
	void toRootDTO() {
		SourceEntity sourceEntity1 = new SourceEntity(1L, "name1", "webshop1", "openHours1");
		SourceEntity sourceEntity2 = new SourceEntity(2L, "name2", "webshop2", "openHours2");
		List<SourceEntity> sourceEntities = new ArrayList<>();
		sourceEntities.add(sourceEntity1);
		sourceEntities.add(sourceEntity2);
		String message = "message";

		RootElement rootElement1 = new RootElement(1L, "name1");
		RootElement rootElement2 = new RootElement(2L, "name2");
		List<RootElement> rootElements = new ArrayList<>();
		rootElements.add(rootElement1);
		rootElements.add(rootElement2);

		SourceRootMapper mapper = new SourceRootMapper();

		assertThrows(IllegalArgumentException.class, () -> mapper.toRootDTO(null, message));
		assertThrows(IllegalArgumentException.class, () -> mapper.toRootDTO(sourceEntities, null));

		RootDTO actualRootDTO = mapper.toRootDTO(sourceEntities, message);
		assertEquals(rootElements, actualRootDTO.getSources());
		assertEquals(message, actualRootDTO.getMessage());
	}
}