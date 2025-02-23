package lgrimm.fooddesigner.recipe.query.searchrecipes;

import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@RestController
public class SearchRecipesController {
	private final SearchRecipesService service;

	@Autowired
	public SearchRecipesController(SearchRecipesService service) {
		this.service = service;
	}

	@GetMapping("/recipe/search/{name}")
	public ModelAndView searchRecipes(@PathVariable String name, Model model) {
		model.asMap().clear();
		return new ModelAndView("recipe_list", "recipeList", service.searchRecipes(name));
	}
}
