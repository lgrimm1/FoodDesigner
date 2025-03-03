/*
1. Copy-paste the file to the specific service
2. Rename the file: change Domains in the file filename according to the domain the service uses
3. Change the next words to correct ones and in the next order:
	- Domains
	- Domain
	- domain
*/

@Service
public class ListDomainsService {
	private final DomainRepository repository;
	private final ListDomainsMapper mapper;

	@Autowired
	public ListDomainsService(DomainRepository repository, ListDomainsMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public ListDomainsDTO listDomains() {
		return mapper.toListDomainsDTO(repository.findAll());
	}
}
