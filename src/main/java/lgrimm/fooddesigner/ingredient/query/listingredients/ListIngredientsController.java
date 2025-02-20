package lgrimm.fooddesigner.ingredient.query.listingredients;

import lgrimm.fooddesigner.subingredient.query.listsubingredients.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@RestController
public class ListIngredientsController {
	private final ListIngredientsService service;

	@Autowired
	public ListIngredientsController(ListIngredientsService service) {
		this.service = service;
	}

	@GetMapping("/ingredient/list")
	public ModelAndView listIngredients(Model model) {
		model.asMap().clear();
		return new ModelAndView("ingredient_list", "ingredientList", service.listIngredients());
	}
}
