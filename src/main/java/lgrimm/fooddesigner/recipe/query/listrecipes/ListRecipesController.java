package lgrimm.fooddesigner.recipe.query.listrecipes;

import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@RestController
@RequestMapping("/api/v1")
public class ListRecipesController {
	private final ListRecipesService service;

	@Autowired
	public ListRecipesController(ListRecipesService service) {
		this.service = service;
	}

	@GetMapping("/recipe/list")
	public ListRecipesDTO listRecipes() {
		return service.listRecipes();
	}
}
