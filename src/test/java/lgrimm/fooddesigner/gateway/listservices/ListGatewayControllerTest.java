package lgrimm.fooddesigner.gateway.listservices;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.http.*;
import org.springframework.test.context.bean.override.mockito.*;
import org.springframework.test.web.servlet.*;
import org.springframework.web.client.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(ListGatewayController.class)
@AutoConfigureDataJpa
class ListGatewayControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockitoBean
	private RestTemplate restTemplate;

	@Test
	void getRoot() throws Exception {
		RootElement rootElement1 = new RootElement(1L, "name1");
		RootElement rootElement2 = new RootElement(2L, "name2");
		List<RootElement> rootElements = new ArrayList<>();
		rootElements.add(rootElement1);
		rootElements.add(rootElement2);
		RootDTO rootDTO = new RootDTO(rootElements, "", "");
		ResponseEntity<RootDTO> responseEntity = new ResponseEntity<>(rootDTO, HttpStatus.OK);
		when(restTemplate.getForEntity("http://localhost:8080/api/v1/root", RootDTO.class))
				.thenReturn(responseEntity);

		mockMvc
				.perform(
						get("http://localhost:8080/")
				)
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(view().name("recipe_list"))
				.andExpect(model().size(1))
				.andExpect(model().attribute("recipeList", rootDTO));
	}

	@Test
	void listSources() throws Exception {
		ListSourcesElement listSourcesElement1 = new ListSourcesElement(1L, "name1");
		ListSourcesElement listSourcesElement2 = new ListSourcesElement(2L, "name2");
		List<ListSourcesElement> listSourcesElements = new ArrayList<>();
		listSourcesElements.add(listSourcesElement1);
		listSourcesElements.add(listSourcesElement2);
		ListSourcesDTO listSourcesDTO = new ListSourcesDTO(listSourcesElements, "", "");
		ResponseEntity<ListSourcesDTO> responseEntity = new ResponseEntity<>(listSourcesDTO, HttpStatus.OK);
		when(restTemplate.getForEntity("http://localhost:8080/api/v1/source/list", ListSourcesDTO.class))
				.thenReturn(responseEntity);

		mockMvc
				.perform(
						get("/source/list")
				)
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(view().name("source_list"))
				.andExpect(model().size(1))
				.andExpect(model().attribute("sourceList", listSourcesDTO));
	}

	@Test
	void listIngredients() throws Exception {
		ListIngredientsElement listIngredientsElement1 = new ListIngredientsElement(1L, "name1");
		ListIngredientsElement listIngredientsElement2 = new ListIngredientsElement(2L, "name2");
		List<ListIngredientsElement> listIngredientsElements = new ArrayList<>();
		listIngredientsElements.add(listIngredientsElement1);
		listIngredientsElements.add(listIngredientsElement2);
		ListIngredientsDTO listIngredientsDTO = new ListIngredientsDTO(listIngredientsElements, "", "");
		ResponseEntity<ListIngredientsDTO> responseEntity = new ResponseEntity<>(listIngredientsDTO, HttpStatus.OK);
		when(restTemplate.getForEntity("http://localhost:8080/api/v1/ingredient/list", ListIngredientsDTO.class))
				.thenReturn(responseEntity);

		mockMvc
				.perform(
						get("/ingredient/list")
				)
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(view().name("ingredient_list"))
				.andExpect(model().size(1))
				.andExpect(model().attribute("ingredientList", listIngredientsDTO));
	}

	@Test
	void listRecipes() throws Exception {
		ListRecipesElement listRecipesElement1 = new ListRecipesElement(1L, "name1");
		ListRecipesElement listRecipesElement2 = new ListRecipesElement(2L, "name2");
		List<ListRecipesElement> listRecipesElements = new ArrayList<>();
		listRecipesElements.add(listRecipesElement1);
		listRecipesElements.add(listRecipesElement2);
		ListRecipesDTO listRecipesDTO = new ListRecipesDTO(listRecipesElements, "", "");
		ResponseEntity<ListRecipesDTO> responseEntity = new ResponseEntity<>(listRecipesDTO, HttpStatus.OK);
		when(restTemplate.getForEntity("http://localhost:8080/api/v1/recipe/list", ListRecipesDTO.class))
				.thenReturn(responseEntity);

		mockMvc
				.perform(
						get("/recipe/list")
				)
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(view().name("recipe_list"))
				.andExpect(model().size(1))
				.andExpect(model().attribute("recipeList", listRecipesDTO));
	}

	@Test
	void listSubIngredients() throws Exception {
		ListSubIngredientsElement listSubIngredientsElement1 = new ListSubIngredientsElement(1L, "name1");
		ListSubIngredientsElement listSubIngredientsElement2 = new ListSubIngredientsElement(2L, "name2");
		List<ListSubIngredientsElement> listSubIngredientsElements = new ArrayList<>();
		listSubIngredientsElements.add(listSubIngredientsElement1);
		listSubIngredientsElements.add(listSubIngredientsElement2);
		ListSubIngredientsDTO listSubIngredientsDTO = new ListSubIngredientsDTO(listSubIngredientsElements, "", "");
		ResponseEntity<ListSubIngredientsDTO> responseEntity = new ResponseEntity<>(listSubIngredientsDTO, HttpStatus.OK);
		when(restTemplate.getForEntity("http://localhost:8080/api/v1/subingredient/list", ListSubIngredientsDTO.class))
				.thenReturn(responseEntity);

		mockMvc
				.perform(
						get("/subingredient/list")
				)
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(view().name("subingredient_list"))
				.andExpect(model().size(1))
				.andExpect(model().attribute("subIngredientList", listSubIngredientsDTO));
	}

	@Test
	void listVolumes() throws Exception {
		ListVolumesElement listVolumesElement1 = new ListVolumesElement(1L, "name1");
		ListVolumesElement listVolumesElement2 = new ListVolumesElement(2L, "name2");
		List<ListVolumesElement> listVolumesElements = new ArrayList<>();
		listVolumesElements.add(listVolumesElement1);
		listVolumesElements.add(listVolumesElement2);
		ListVolumesDTO listVolumesDTO = new ListVolumesDTO(listVolumesElements, "", "");
		ResponseEntity<ListVolumesDTO> responseEntity = new ResponseEntity<>(listVolumesDTO, HttpStatus.OK);
		when(restTemplate.getForEntity("http://localhost:8080/api/v1/volume/list", ListVolumesDTO.class))
				.thenReturn(responseEntity);

		mockMvc
				.perform(
						get("/volume/list")
				)
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(view().name("volume_list"))
				.andExpect(model().size(1))
				.andExpect(model().attribute("volumeList", listVolumesDTO));
	}
}