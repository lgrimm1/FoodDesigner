package lgrimm.fooddesigner.ingredient.query.findingredient;

import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@RestController
public class FindIngredientController {
	private final FindIngredientService service;

	@Autowired
	public FindIngredientController(FindIngredientService service) {
		this.service = service;
	}

	@GetMapping("/ingredient/{id}")
	public ModelAndView findIngredient(@PathVariable long id, Model model) {
		model.asMap().clear();
		FindIngredientDTO findIngredientDTO = service.findIngredient(id);
		String message = findIngredientDTO.getMessage();
		if (message.isEmpty()) {
			return new ModelAndView("ingredient", "ingredient", service.findIngredient(id));
		}
		return new ModelAndView("ingredient_list", "ingredientList", service.listIngredients(message));
	}
}
