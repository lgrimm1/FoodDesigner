/*
1. Copy-paste the file to the specific service
2. Rename the file: change Domains in the file filename according to the domain the service uses
3. Change the next words to correct ones and in the next order:
	- Domains
	- Domain
	- domain
*/

//in SearchDomainsDTO the element class of the data container List
public record SearchDomainsElement(Long domainId, String domainName) {
}
