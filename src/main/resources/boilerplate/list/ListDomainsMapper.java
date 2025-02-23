/*
1. Copy-paste the file to the specific service
2. Rename the file: change Domains in the file filename according to the domain the service uses
3. Change the next words to correct ones and in the next order:
	- Domains
	- Domain
	- domain
*/

@Component
public class ListDomainsMapper {

	private ListDomainsElement toListDomainsElement(DomainEntity domainEntity) {
		if (domainEntity == null) {
			throw new IllegalArgumentException();
		}
		return new ListDomainsElement(domainEntity.getId(), domainEntity.getName());
	}

	public ListDomainsDTO toListDomainsDTO(List<DomainEntity> domainEntities) {
		if (domainEntities == null) {
			throw new IllegalArgumentException();
		}
		List<ListDomainsElement> listDomainsElements = domainEntities.stream()
				.map(this::toListDomainsElement)
				.collect(Collectors.toList());
		return new ListDomainsDTO(listDomainsElements, "", "");
	}
}
