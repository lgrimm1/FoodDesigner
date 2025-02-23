/*
1. Copy-paste the file to the specific service
2. Rename the file: change Domains in the file filename according to the domain the service uses
3. Change the next words to correct ones and in the next order:
	- Domains
	- Domain
	- domain
*/

@Component
public class SearchDomainsMapper {

	private SearchDomainsElement toSearchDomainsElement(DomainEntity domainEntity) {
		if (domainEntity == null) {
			throw new IllegalArgumentException();
		}
		return new SearchDomainsElement(domainEntity.getId(), domainEntity.getName());
	}

	public SearchDomainsDTO toSearchDomainsDTO(List<DomainEntity> domainEntities, String message) {
		if (domainEntities == null || message == null) {
			throw new IllegalArgumentException();
		}
		List<SearchDomainsElement> searchDomainsElements = domainEntities.stream()
				.map(this::toSearchDomainsElement)
				.collect(Collectors.toList());
		return new SearchDomainsDTO(searchDomainsElements, "", message);
	}
}
