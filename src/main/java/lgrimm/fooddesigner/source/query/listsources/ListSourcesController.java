package lgrimm.fooddesigner.source.query.listsources;

import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@RestController
@RequestMapping("/api/v1")
public class ListSourcesController {
	private final ListSourcesService service;

	@Autowired
	public ListSourcesController(ListSourcesService service) {
		this.service = service;
	}

	@GetMapping("/source/list")
	public ListSourcesDTO listSources() {
		return service.listSources();
	}
}
