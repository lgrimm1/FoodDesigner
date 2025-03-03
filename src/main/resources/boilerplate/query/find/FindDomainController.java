/*
1. Copy-paste the file to the specific service
2. Rename the file: change Domains in the file filename according to the domain the service uses
3. Change the next words to correct ones and in the next order:
	- Domains
	- Domain
	- domain
*/

@RestController
public class FindDomainController {
	private final FindDomainService service;

	@Autowired
	public FindDomainController(FindDomainService service) {
		this.service = service;
	}

	@GetMapping("/domain/{id}")
	public ModelAndView findDomain(@PathVariable long id, Model model) {
		model.asMap().clear();
		FindDomainDTO findDomainDTO = service.findDomain(id);
		String message = findDomainDTO.getMessage();
		if (message.isEmpty()) {
			return new ModelAndView("domain", "domain", service.findDomain(id));
		}
		return new ModelAndView("domain_list", "domainList", service.listDomains(message));
	}
}
