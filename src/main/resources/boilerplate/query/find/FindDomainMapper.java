/*
1. Copy-paste the file to the specific service
2. Rename the file: change Domains in the file filename according to the domain the service uses
3. Change the next words to correct ones and in the next order:
	- Domains
	- Domain
	- domain
*/

@Component
public class FindDomainMapper {
	public FindDomainDTO toFindDomainDTO(DomainEntity domainEntity, String message) {
		if (domainEntity == null || message == null) {
			throw new IllegalArgumentException();
		}
		return new FindDomainDTO(domainEntity, message);
	}

	private ListDomainsElement toListDomainsElement(DomainEntity domainEntity) {
		if (domainEntity == null) {
			throw new IllegalArgumentException();
		}
		return new ListDomainsElement(domainEntity.getId(), domainEntity.getName());
	}

	public ListDomainsDTO toListDomainsDTO(List<DomainEntity> domainEntities, String message) {
		if (domainEntities == null || message == null) {
			throw new IllegalArgumentException();
		}
		List<ListDomainsElement> listRecipesElements = domainEntities.stream()
				.map(this::toListDomainsElement)
				.collect(Collectors.toList());
		return new ListDomainsDTO(listRecipesElements, message);
	}
}
