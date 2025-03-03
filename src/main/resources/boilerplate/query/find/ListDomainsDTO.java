/*
1. Copy-paste the file to the specific service
2. Rename the file: change Domains in the file filename according to the domain the service uses
3. Change the next words to correct ones and in the next order:
	- Domains
	- Domain
	- domain
*/

public class ListDomainsDTO {
	private final List<ListDomainsElement> domains;
	private final String message;

	public ListDomainsDTO(List<ListDomainsElement> domains, String message) {
		this.domains = domains;
		this.message = message;
	}

	public List<ListDomainsElement> getDomains() {
		return domains;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof lgrimm.fooddesigner.domain.query.finddomain.ListDomainsDTO rootDTO)) return false;
		return Objects.equals(domains, rootDTO.domains) &&
				Objects.equals(message, rootDTO.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(domains, message);
	}

	@Override
	public String toString() {
		return "ListDomainsDTO{" +
				"domains=" + domains +
				", message='" + message + '\'' +
				'}';
	}
}
