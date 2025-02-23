/*
1. Copy-paste the file to the specific service
2. Rename the file: change Domains in the file filename according to the domain the service uses
3. Change the next words to correct ones and in the next order:
	- Domains
	- Domain
	- domain
*/

public class FindDomainDTO {
	private final DomainEntity domain;
	private final String message;

	public FindDomainDTO(DomainEntity domain, String message) {
		this.domain = domain;
		this.message = message;
	}

	public DomainEntity getDomain() {
		return domain;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof lgrimm.fooddesigner.domain.query.finddomain.FindDomainDTO that)) return false;
		return
				Objects.equals(domain, that.domain) &&
						Objects.equals(message, that.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(domain, message);
	}

	@Override
	public String toString() {
		return "FindDomainDTO{" +
				"domain=" + domain +
				", message='" + message + '\'' +
				'}';
	}
}
