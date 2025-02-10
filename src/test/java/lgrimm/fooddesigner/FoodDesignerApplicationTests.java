package lgrimm.fooddesigner;

import lgrimm.fooddesigner.root.*;
import lgrimm.fooddesigner.source.query.listsources.*;
import lgrimm.fooddesigner.source.query.searchsources.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FoodDesignerApplicationTests {

	private final RootController rootController;
	private final ListSourcesController listSourcesController;
	private final SearchSourcesController searchSourcesController;

	@Autowired
	FoodDesignerApplicationTests(
			RootController rootController,
			ListSourcesController listSourcesController,
			SearchSourcesController searchSourcesController
	) {
		this.rootController = rootController;
		this.listSourcesController = listSourcesController;
		this.searchSourcesController = searchSourcesController;
	}

	@Test
	void contextLoads() {
		Assertions.assertNotNull(rootController);
		Assertions.assertNotNull(listSourcesController);
		Assertions.assertNotNull(searchSourcesController);
	}

}
