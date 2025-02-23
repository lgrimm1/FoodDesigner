/*
1. Copy-paste the file to the specific service
2. Rename the file: change Domains in the file filename according to the domain the service uses
3. Change the next words to correct ones and in the next order:
	- Domains
	- Domain
	- domain
*/

@Service
public class SearchDomainsService {
	private final DomainRepository repository;
	private final SearchDomainsMapper mapper;

	@Autowired
	public SearchDomainsService(DomainRepository repository, SearchDomainsMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	private String[] splitToWords(String text) {
		while (text.contains("  ")) {
			text = text.replace("  ", " ");
		}
		return text.split(" ");
	}

	public SearchDomainsDTO searchDomains(String text) {
		if (text == null) {
			throw new IllegalArgumentException();
		}
		if (text.isBlank()) {
			return new SearchDomainsDTO(new ArrayList<SearchDomainsElement>(), "", "No text were given.");
		}
		Set<Long> domainEntityIds = repository.findAllByName(text.trim()).stream()
				.map(DomainEntity::getId)
				.collect(Collectors.toSet());
		for (String word : splitToWords(text)) {
			repository.findAllByName(word).stream()
					.map(DomainEntity::getId)
					.forEach(domainEntityIds::add);
		}
		List<DomainEntity> finalDomainEntities = repository.findAllById(domainEntityIds);
		return mapper.toSearchDomainsDTO(finalDomainEntities, "Found " + finalDomainEntities.size() + " occurrence(s).");
	}

	public SearchDomainsDTO listDomains() {
		return mapper.toSearchDomainsDTO(repository.findAll(), "Something went wrong, returned full list.");
	}
}
