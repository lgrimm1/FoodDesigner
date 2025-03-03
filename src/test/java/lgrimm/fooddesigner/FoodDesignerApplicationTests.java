package lgrimm.fooddesigner;

import lgrimm.fooddesigner.gateway.listservices.*;
import lgrimm.fooddesigner.ingredient.query.listingredients.*;
import lgrimm.fooddesigner.recipe.query.listrecipes.*;
import lgrimm.fooddesigner.root.*;
import lgrimm.fooddesigner.source.query.listsources.*;
import lgrimm.fooddesigner.subingredient.query.listsubingredients.*;
import lgrimm.fooddesigner.volume.query.listvolumes.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FoodDesignerApplicationTests {

	private final ListGatewayController listGatewayController;
	private final RootController rootController;
	private final ListSourcesController listSourcesController;
	private final ListRecipesController listRecipesController;
	private final ListIngredientsController listIngredientsController;
	private final ListSubIngredientsController listSubIngredientsController;
	private final ListVolumesController listVolumesController;

	@Autowired
	FoodDesignerApplicationTests(
			ListGatewayController listGatewayController,
			RootController rootController,
			ListSourcesController listSourcesController,
			ListRecipesController listRecipesController,
			ListIngredientsController listIngredientsController,
			ListSubIngredientsController listSubIngredientsController,
			ListVolumesController listVolumesController
	) {
		this.listGatewayController = listGatewayController;
		this.rootController = rootController;
		this.listSourcesController = listSourcesController;
		this.listRecipesController = listRecipesController;
		this.listIngredientsController = listIngredientsController;
		this.listSubIngredientsController = listSubIngredientsController;
		this.listVolumesController = listVolumesController;
	}

	@Test
	void contextLoads() {
		Assertions.assertNotNull(listGatewayController);

		Assertions.assertNotNull(rootController);
		Assertions.assertNotNull(listSourcesController);
		Assertions.assertNotNull(listRecipesController);
		Assertions.assertNotNull(listIngredientsController);
		Assertions.assertNotNull(listSubIngredientsController);
		Assertions.assertNotNull(listVolumesController);
	}
}
