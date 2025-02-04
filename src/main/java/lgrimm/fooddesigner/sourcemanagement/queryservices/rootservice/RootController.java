package lgrimm.fooddesigner.sourcemanagement.queryservices.rootservice;

import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@RestController
@ControllerAdvice
//@RequestMapping("/api/v1.0")
public class RootController {
	private final RootService service;

	@Autowired
	public RootController(RootService service) {
		this.service = service;
	}

	@GetMapping("/")
	public ModelAndView geRoot(Model model) {
		model.asMap().clear();
		return new ModelAndView("source_list", "sourceList", service.getRoot());
	}
}
