package stepDefinition;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	@Before("@DeletePlaceApi")
	public void beforeScenario() throws IOException {
		// execute the code only when place_id is null
		// write a code that will give you pace id--
		StepDefinition k = new StepDefinition();
		if (StepDefinition.place_id == null) {

			k.add_Place_Payload_with("maholi", "hindi", "Monu");
			k.user_calls_with_http_request("AddPlaceAPI", "Post");
			k.verify_place_id_created_maps_to_using("Monu", "GetPlaceAPI");
		}

	}
}
