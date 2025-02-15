package lgrimm.fooddesigner.subingredient.query.listsubingredients;

import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@RestController
public class ListSubIngredientsController {
	private final ListSubIngredientsService service;

	@Autowired
	public ListSubIngredientsController(ListSubIngredientsService service) {
		this.service = service;
	}

	@GetMapping("/subingredient/list")
	public ModelAndView listSubIngredients(Model model) {
		model.asMap().clear();
		return new ModelAndView("subingredient_list", "subIngredientList", service.listSubIngredients());
	}
}
