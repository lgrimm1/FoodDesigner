package lgrimm.fooddesigner.subingredient.query.searchsubingredients;

import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@RestController
@RequestMapping("/api/v1")
public class SearchSubIngredientsController {
	private final SearchSubIngredientsService service;

	@Autowired
	public SearchSubIngredientsController(SearchSubIngredientsService service) {
		this.service = service;
	}

	@GetMapping("/subingredient/search/{name}")
	public ModelAndView searchSubIngredients(@PathVariable String name, Model model) {
		model.asMap().clear();
		return new ModelAndView("subingredient_list", "subIngredientList", service.searchSubIngredients(name));
	}
}
