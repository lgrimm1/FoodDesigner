package lgrimm.fooddesigner.sourcemanagement.queryservices.rootservice;

import lgrimm.fooddesigner.domains.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.web.servlet.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class RootServiceTest {

	@Test
	void getRoot() {
		List<Source> sourceList = new ArrayList<>();
		sourceList.add(new Source(1L, "name1", "webshop1", "openHours1"));
		sourceList.add(new Source(2L, "name2", "webshop2", "openHours2"));
		RootRepository repository = Mockito.mock(RootRepository.class);
		when(repository.findAll())
				.thenReturn(sourceList);

		List<SourceListElement> expectedSourceList = new ArrayList<>();
		expectedSourceList.add(new SourceListElement(1L, "name1"));
		expectedSourceList.add(new SourceListElement(2L, "name2"));

		RootService service = new RootService(repository);
		assertEquals(expectedSourceList, service.getRoot());
	}
}