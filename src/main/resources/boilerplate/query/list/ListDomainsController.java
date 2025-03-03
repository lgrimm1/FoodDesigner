/*
1. Copy-paste the file to the specific service
2. Rename the file: change Domains in the file filename according to the domain the service uses
3. Change the next words to correct ones and in the next order:
	- Domains
	- Domain
	- domain
*/

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ListDomainsController {
	private final ListDomainsService service;

	@Autowired
	public ListDomainsController(ListDomainsService service) {
		this.service = service;
	}

	@GetMapping("/domain/list")
	public ListDomainsDTO listDomains() {
		return service.listDomains();
	}
}
