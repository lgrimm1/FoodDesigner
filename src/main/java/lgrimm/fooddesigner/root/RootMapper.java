package lgrimm.fooddesigner.root;

import lgrimm.fooddesigner.domain.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Component
public class RootMapper {

	private RootElement toRootElement(RecipeEntity recipeEntity) {
		if (recipeEntity == null) {
			throw new IllegalArgumentException();
		}
		return new RootElement(recipeEntity.getId(), recipeEntity.getName());
	}

	public RootDTO toRootDTO(List<RecipeEntity> recipeEntities) {
		if (recipeEntities == null) {
			throw new IllegalArgumentException();
		}
		List<RootElement> rootEntities = recipeEntities.stream()
				.map(this::toRootElement)
				.collect(Collectors.toList());
		return new RootDTO(rootEntities, "", "");
	}
}
