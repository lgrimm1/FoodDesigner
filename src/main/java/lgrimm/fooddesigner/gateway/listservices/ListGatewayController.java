package lgrimm.fooddesigner.gateway.listservices;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;
import org.springframework.web.servlet.*;

import java.util.*;

@RestController
public class ListGatewayController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/")
	public ModelAndView getRoot(Model model) {
		model.asMap().clear();
		String internalServiceUrl = "http://localhost:8080/api/v1/root";
		ResponseEntity<RootDTO> responseEntity = restTemplate.getForEntity(internalServiceUrl, RootDTO.class);
		return new ModelAndView("recipe_list", "recipeList", Objects.requireNonNull(responseEntity.getBody()));
	}

	@GetMapping("/source/list")
	public ModelAndView listSources(Model model) {
		model.asMap().clear();
		String internalServiceUrl = "http://localhost:8080/api/v1/source/list";
		ResponseEntity<ListSourcesDTO> responseEntity = restTemplate.getForEntity(internalServiceUrl, ListSourcesDTO.class);
		return new ModelAndView("source_list", "sourceList", Objects.requireNonNull(responseEntity.getBody()));
	}

	@GetMapping("/ingredient/list")
	public ModelAndView listIngredients(Model model) {
		model.asMap().clear();
		String internalServiceUrl = "http://localhost:8080/api/v1/ingredient/list";
		ResponseEntity<ListIngredientsDTO> responseEntity = restTemplate.getForEntity(internalServiceUrl, ListIngredientsDTO.class);
		return new ModelAndView("ingredient_list", "ingredientList", Objects.requireNonNull(responseEntity.getBody()));
	}

	@GetMapping("/recipe/list")
	public ModelAndView listRecipes(Model model) {
		model.asMap().clear();
		String internalServiceUrl = "http://localhost:8080/api/v1/recipe/list";
		ResponseEntity<ListRecipesDTO> responseEntity = restTemplate.getForEntity(internalServiceUrl, ListRecipesDTO.class);
		return new ModelAndView("recipe_list", "recipeList", Objects.requireNonNull(responseEntity.getBody()));
	}

	@GetMapping("/subingredient/list")
	public ModelAndView listSubIngredients(Model model) {
		model.asMap().clear();
		String internalServiceUrl = "http://localhost:8080/api/v1/subingredient/list";
		ResponseEntity<ListSubIngredientsDTO> responseEntity = restTemplate.getForEntity(internalServiceUrl, ListSubIngredientsDTO.class);
		return new ModelAndView("subingredient_list", "subIngredientList", Objects.requireNonNull(responseEntity.getBody()));
	}

	@GetMapping("/volume/list")
	public ModelAndView listVolumes(Model model) {
		model.asMap().clear();
		String internalServiceUrl = "http://localhost:8080/api/v1/volume/list";
		ResponseEntity<ListVolumesDTO> responseEntity = restTemplate.getForEntity(internalServiceUrl, ListVolumesDTO.class);
		return new ModelAndView("volume_list", "volumeList", Objects.requireNonNull(responseEntity.getBody()));
	}
}
