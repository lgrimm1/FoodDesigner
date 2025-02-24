package lgrimm.fooddesigner.recipe.query.findrecipe;

import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@RestController
public class FindRecipeController {
	private final FindRecipeService service;

	@Autowired
	public FindRecipeController(FindRecipeService service) {
		this.service = service;
	}

	@GetMapping("/recipe/{id}")
	public ModelAndView findRecipe(@PathVariable long id, Model model) {
		model.asMap().clear();
		FindRecipeDTO findRecipeDTO = service.findRecipe(id);
		String message = findRecipeDTO.getMessage();
		if (message.isEmpty()) {
			return new ModelAndView("recipe", "recipe", service.findRecipe(id));
		}
		return new ModelAndView("recipe_list", "recipeList", service.listRecipes(message));
	}
}
