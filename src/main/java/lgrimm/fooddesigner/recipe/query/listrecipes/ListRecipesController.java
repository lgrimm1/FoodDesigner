package lgrimm.fooddesigner.recipe.query.listrecipes;

import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@RestController
public class ListRecipesController {
	private final ListRecipesService service;

	@Autowired
	public ListRecipesController(ListRecipesService service) {
		this.service = service;
	}

	@GetMapping("/recipe/list")
	public ModelAndView listRecipes(Model model) {
		model.asMap().clear();
		return new ModelAndView("recipe_list", "recipeList", service.listRecipes());
	}
}
