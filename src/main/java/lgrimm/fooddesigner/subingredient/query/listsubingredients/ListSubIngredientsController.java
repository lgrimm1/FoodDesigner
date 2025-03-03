package lgrimm.fooddesigner.subingredient.query.listsubingredients;

import lgrimm.fooddesigner.ingredient.query.searchingredients.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@RestController
@RequestMapping("/api/v1")
public class ListSubIngredientsController {
	private final ListSubIngredientsService service;

	@Autowired
	public ListSubIngredientsController(ListSubIngredientsService service) {
		this.service = service;
	}

	@GetMapping("/subingredient/list")
	public ListSubIngredientsDTO listSubIngredients() {
		return service.listSubIngredients();
	}
}
