package lgrimm.fooddesigner.ingredient.query.searchingredients;

import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@RestController
public class SearchIngredientsController {
	private final SearchIngredientsService service;

	@Autowired
	public SearchIngredientsController(SearchIngredientsService service) {
		this.service = service;
	}

	@GetMapping("/ingredient/search/{name}")
	public ModelAndView searchIngredients(@PathVariable String name, Model model) {
		model.asMap().clear();
		return new ModelAndView("ingredient_list", "ingredientList", service.searchIngredients(name));
	}
}
