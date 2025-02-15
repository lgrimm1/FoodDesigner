package lgrimm.fooddesigner.source.query.findsource;

import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@RestController
public class FindSourceController {
	private final FindSourceService service;

	@Autowired
	public FindSourceController(FindSourceService service) {
		this.service = service;
	}

	@GetMapping("/source/{id}")
	public ModelAndView findSource(@PathVariable long id, Model model) {
		model.asMap().clear();
		FindSourceDTO findSourceDTO = service.findSource(id);
		String message = findSourceDTO.getMessage();
		if (message.isEmpty()) {
			return new ModelAndView("source", "source", service.findSource(id));
		}
		return new ModelAndView("source_list", "sourceList", service.listSources(message));
	}
}
