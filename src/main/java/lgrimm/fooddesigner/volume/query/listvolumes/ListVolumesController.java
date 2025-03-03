package lgrimm.fooddesigner.volume.query.listvolumes;

import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@RestController
@RequestMapping("/api/v1")
public class ListVolumesController {
	private final ListVolumesService service;

	@Autowired
	public ListVolumesController(ListVolumesService service) {
		this.service = service;
	}

	@GetMapping("/volume/list")
	public ListVolumesDTO listVolumes() {
		return service.listVolumes();
	}
}
