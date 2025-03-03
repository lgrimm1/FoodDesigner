/*
1. Copy-paste the file to the specific service
2. Rename the file: change Domains in the file filename according to the domain the service uses
3. Change the next words to correct ones and in the next order:
	- Domains
	- Domain
	- domain
*/

@Service
public class FindDomainService {
	private final DomainRepository repository;
	private final FindDomainMapper mapper;

	@Autowired
	public FindDomainService(DomainRepository repository, FindDomainMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public FindDomainDTO findDomain(long id) {
		Optional<DomainEntity> entity = repository.findById(id);
		if (entity.isPresent()) {
			return mapper.toFindDomainDTO(entity.get(), "");
		}
		return mapper.toFindDomainDTO(new DomainEntity(), "No such domain was found.");
	}

	public ListDomainsDTO listDomains(String message) {
		return mapper.toListDomainsDTO(repository.findAll(), message);
	}
}
