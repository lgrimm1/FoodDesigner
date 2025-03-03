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
	private final String searchText;
	private final String message;

	public ListDomainsDTO(
			List<ListDomainsElement> domains,
			String searchText,
			String message) {
		this.domains = domains;
		this.searchText = searchText;
		this.message = message;
	}

	public List<ListDomainsElement> getDomains() {
		return domains;
	}

	public String getSearchText() {
		return searchText;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof lgrimm.fooddesigner.domain.query.listdomains.ListDomainsDTO that)) return false;
		return Objects.equals(domains, that.domains) &&
				Objects.equals(searchText, that.searchText) &&
				Objects.equals(message, that.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(domains, searchText, message);
	}

	@Override
	public String toString() {
		return "ListDomainsDTO{" +
				"domains=" + domains +
				", searchText='" + searchText + '\'' +
				", message='" + message + '\'' +
				'}';
	}
}
