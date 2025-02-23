package lgrimm.fooddesigner.volume.query.searchvolumes;

import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@RestController
public class SearchVolumesController {
	private final SearchVolumesService service;

	@Autowired
	public SearchVolumesController(SearchVolumesService service) {
		this.service = service;
	}

	@GetMapping("/volume/search/{name}")
	public ModelAndView searchVolumes(@PathVariable String name, Model model) {
		model.asMap().clear();
		return new ModelAndView("volume_list", "volumeList", service.searchVolumes(name));
	}
}
