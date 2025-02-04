package lgrimm.fooddesigner.sourcemanagement.queryservices.rootservice;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Service
public class RootService {
	private final RootRepository repository;

	@Autowired
	public RootService(RootRepository repository) {
		this.repository = repository;
	}

	public List<SourceListElement> getRoot() {
		return repository.findAll().stream()
				.map(source -> new SourceListElement(source.getId(), source.getName()))
				.collect(Collectors.toList());
	}
}
