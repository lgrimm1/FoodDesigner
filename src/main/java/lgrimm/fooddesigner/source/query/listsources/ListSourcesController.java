package lgrimm.fooddesigner.source.query.listsources;

import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@RestController
public class ListSourcesController {
	private final ListSourcesService service;

	@Autowired
	public ListSourcesController(ListSourcesService service) {
		this.service = service;
	}

	@GetMapping("/source/list")
	public ModelAndView listSources(Model model) {
		model.asMap().clear();
		return new ModelAndView("source_list", "sourceList", service.listSources());
	}
}
