package lgrimm.fooddesigner.volume.query.findvolume;

import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@RestController
public class FindVolumeController {
	private final FindVolumeService service;

	@Autowired
	public FindVolumeController(FindVolumeService service) {
		this.service = service;
	}

	@GetMapping("/volume/{id}")
	public ModelAndView findVolume(@PathVariable long id, Model model) {
		model.asMap().clear();
		FindVolumeDTO findVolumeDTO = service.findVolume(id);
		String message = findVolumeDTO.getMessage();
		if (message.isEmpty()) {
			return new ModelAndView("volume", "volume", service.findVolume(id));
		}
		return new ModelAndView("volume_list", "volumeList", service.listVolumes(message));
	}
}
