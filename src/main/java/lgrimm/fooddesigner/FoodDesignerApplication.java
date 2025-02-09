package lgrimm.fooddesigner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;

@SpringBootApplication
//@ComponentScan(basePackages = {"lgrimm.fooddesigner.source.query.listsources"})
public class FoodDesignerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodDesignerApplication.class, args);
	}

}
