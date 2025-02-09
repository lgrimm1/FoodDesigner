package lgrimm.fooddesigner;

import lgrimm.fooddesigner.root.*;
import lgrimm.fooddesigner.source.query.listsources.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FoodDesignerApplicationTests {

	private final RootController rootController;
	private final ListSourcesController listSourcesController;

	@Autowired
	FoodDesignerApplicationTests(
			RootController rootController,
			ListSourcesController listSourcesController
	) {
		this.rootController = rootController;
		this.listSourcesController = listSourcesController;
	}

	@Test
	void contextLoads() {
		Assertions.assertNotNull(rootController);
		Assertions.assertNotNull(listSourcesController);
	}

}
