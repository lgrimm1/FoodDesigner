package lgrimm.fooddesigner;

import lgrimm.fooddesigner.sourcemanagement.queryservices.rootservice.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FoodDesignerApplicationTests {

	private final RootController rootController;

	@Autowired
	FoodDesignerApplicationTests(RootController rootController) {
		this.rootController = rootController;
	}

	@Test
	void contextLoads() {
		Assertions.assertNotNull(rootController);
	}

}
