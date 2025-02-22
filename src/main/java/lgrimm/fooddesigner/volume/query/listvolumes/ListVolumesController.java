package lgrimm.fooddesigner.volume.query.listvolumes;

import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@RestController
public class ListVolumesController {
	private final ListVolumesService service;

	@Autowired
	public ListVolumesController(ListVolumesService service) {
		this.service = service;
	}

	@GetMapping("/volume/list")
	public ModelAndView listVolumes(Model model) {
		model.asMap().clear();
		return new ModelAndView("volume_list", "volumeList", service.listVolumes());
	}
}
