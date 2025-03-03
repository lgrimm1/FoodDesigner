package lgrimm.fooddesigner.ingredient.query.listingredients;

import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@RestController
@RequestMapping("/api/v1")
public class ListIngredientsController {
	private final ListIngredientsService service;

	@Autowired
	public ListIngredientsController(ListIngredientsService service) {
		this.service = service;
	}

	@GetMapping("/ingredient/list")
	public ListIngredientsDTO listIngredients() {
		return service.listIngredients();
	}
}
