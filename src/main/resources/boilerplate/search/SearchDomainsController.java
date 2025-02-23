/*
1. Copy-paste the file to the specific service
2. Rename the file: change Domains in the file filename according to the domain the service uses
3. Change the next words to correct ones and in the next order:
	- Domains
	- Domain
	- domain
*/

@RestController
public class SearchDomainsController {
	private final SearchDomainsService service;

	@Autowired
	public SearchDomainsController(SearchDomainsService service) {
		this.service = service;
	}

	@GetMapping("/domain/search/{name}")
	public ModelAndView searchDomains(@PathVariable String name, Model model) {
		model.asMap().clear();
		return new ModelAndView("domain_list", "domainList", service.searchDomains(name));
	}
}
