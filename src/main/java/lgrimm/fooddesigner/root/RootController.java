package lgrimm.fooddesigner.root;

import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@RestController
@RequestMapping("/api/v1")
public class RootController {
	private final RootService service;

	@Autowired
	public RootController(RootService service) {
		this.service = service;
	}

	@GetMapping("/root")
	public RootDTO getRoot() {
		return service.getRoot();
	}
}
