package lgrimm.fooddesigner.source.query.findsource;

import lgrimm.fooddesigner.domain.*;
//import org.aspectj.bridge.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FindSourceMapperTest {

	@Test
	void toFindSourceDTO() {
		SourceEntity entity = new SourceEntity(12L, "name", "webshop", "openHours");
		String message = "message";
		FindSourceMapper mapper = new FindSourceMapper();

		assertThrows(IllegalArgumentException.class, () -> mapper.toFindSourceDTO(null, message));
		assertThrows(IllegalArgumentException.class, () -> mapper.toFindSourceDTO(entity, null));

		FindSourceDTO findSourceDTO = mapper.toFindSourceDTO(entity, message);
		assertEquals(entity.getId(), findSourceDTO.getSource().getId());
		assertEquals(entity.getName(), findSourceDTO.getSource().getName());
		assertEquals(entity.getWebShop(), findSourceDTO.getSource().getWebShop());
		assertEquals(entity.getOpenHours(), findSourceDTO.getSource().getOpenHours());
		assertEquals(message, findSourceDTO.getMessage());
	}

	@Test
	void toListSourcesDTO() {
		SourceEntity sourceEntity1 = new SourceEntity(1L, "name1", "webshop1", "openHours1");
		SourceEntity sourceEntity2 = new SourceEntity(2L, "name2", "webshop2", "openHours2");
		List<SourceEntity> sourceEntities = new ArrayList<>();
		sourceEntities.add(sourceEntity1);
		sourceEntities.add(sourceEntity2);
		String message = "message";

		ListSourcesElement listRecipesElement1 = new ListSourcesElement(1L, "name1");
		ListSourcesElement listRecipesElement2 = new ListSourcesElement(2L, "name2");
		List<ListSourcesElement> listRecipesElements = new ArrayList<>();
		listRecipesElements.add(listRecipesElement1);
		listRecipesElements.add(listRecipesElement2);

		FindSourceMapper mapper = new FindSourceMapper();

		assertThrows(IllegalArgumentException.class, () -> mapper.toListSourcesDTO(null, message));
		assertThrows(IllegalArgumentException.class, () -> mapper.toListSourcesDTO(sourceEntities, null));

		ListSourcesDTO actualListSourcesDTO = mapper.toListSourcesDTO(sourceEntities, message);
		assertEquals(listRecipesElements, actualListSourcesDTO.getSources());
		assertEquals(message, actualListSourcesDTO.getMessage());
	}
}