package lgrimm.fooddesigner.root;

import lgrimm.fooddesigner.domain.*;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class RootServiceTest {

	@Test
	void getRoot() {
		SourceEntity sourceEntity1 = new SourceEntity(1L, "name1", "webshop1", "openHours1");
		SourceEntity sourceEntity2 = new SourceEntity(2L, "name2", "webshop2", "openHours2");
		String message = "";

		List<SourceEntity> sourceEntities = new ArrayList<>();
		sourceEntities.add(sourceEntity1);
		sourceEntities.add(sourceEntity2);
		SourceRepository repository = Mockito.mock(SourceRepository.class);
		when(repository.findAll())
				.thenReturn(sourceEntities);

		RootElement rootElement1 = new RootElement(1L, "name1");
		RootElement rootElement2 = new RootElement(2L, "name2");
		List<RootElement> rootElements = new ArrayList<>();
		rootElements.add(rootElement1);
		rootElements.add(rootElement2);
		RootDTO rootDTO = new RootDTO(rootElements, message);
		SourceRootMapper mapper = Mockito.mock(SourceRootMapper.class);
		when(mapper.toRootDTO(sourceEntities, message))
				.thenReturn(rootDTO);

		RootService service = new RootService(repository, mapper);
		RootDTO actualRootDTO = service.getRoot();
		assertEquals(rootElements, actualRootDTO.getSources());
		assertEquals(message, actualRootDTO.getMessage());
	}
}