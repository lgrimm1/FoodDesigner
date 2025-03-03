package lgrimm.fooddesigner.subingredient.query.findsubingredient;

import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@RestController
@RequestMapping("/api/v1")
public class FindSubIngredientController {
	private final FindSubIngredientService service;

	@Autowired
	public FindSubIngredientController(FindSubIngredientService service) {
		this.service = service;
	}

	@GetMapping("/subIngredient/{id}")
	public ModelAndView findSubIngredient(@PathVariable long id, Model model) {
		model.asMap().clear();
		FindSubIngredientDTO findSubIngredientDTO = service.findSubIngredient(id);
		String message = findSubIngredientDTO.getMessage();
		if (message.isEmpty()) {
			return new ModelAndView("subIngredient", "subIngredient", service.findSubIngredient(id));
		}
		return new ModelAndView("subIngredient_list", "subIngredientList", service.listSubIngredients(message));
	}
}
