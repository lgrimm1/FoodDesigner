package lgrimm.fooddesigner.source.query.searchsources;

import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@RestController
public class SearchSourcesController {
	private final SearchSourcesService service;

	@Autowired
	public SearchSourcesController(SearchSourcesService service) {
		this.service = service;
	}

	@GetMapping("/source/search/{name}")
	public ModelAndView searchSources(@PathVariable String name, Model model) {
		model.asMap().clear();
		return new ModelAndView("source_list", "sourceList", service.searchSources(name));
	}
}
