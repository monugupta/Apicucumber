package stepDefinition;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.ApiResources;
import resources.TestDataBuild;
import resources.Utiles;

public class StepDefinition extends Utiles {
	RequestSpecification res;
	// ResponseSpecification k;
	Response response;
	TestDataBuild resource = new TestDataBuild();
	public static String place_id;// why we make static this is imp

	@Given("Add Place Payload with {string} {string} {string}")
	public void add_Place_Payload_with(String setAddress, String setLanguage, String setName) throws IOException {
		/*
		 * RestAssured.baseURI = "https://rahulshettyacademy.com";
		 * 
		 * RequestSpecification p = new
		 * RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
		 * .setContentType(ContentType.JSON).addQueryParam("key", "qaclick123").build();
		 * k = new ResponseSpecBuilder().expectStatusCode(200).expectHeader("Server",
		 * "Apache/2.4.18 (Ubuntu)").build();
		 */
		res = given().spec(requestSpecification()).body(resource.add_Place_Payload(setAddress, setLanguage, setName));

	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String Apimethod) {
		/// constructor will be call--:
		ApiResources resou = ApiResources.valueOf(resource);
		String resourcess = resou.getResorces();
		if (Apimethod.equalsIgnoreCase("Post"))
			response = res.when().post(resourcess);
		else if (Apimethod.equalsIgnoreCase("Get"))
			response = res.when().get(resourcess);
		else if (Apimethod.equalsIgnoreCase("Delete"))
			response = res.when().post(resourcess);

	}

	@Then("the API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(Integer int1) {
		response.getStatusCode();
		assertEquals(response.getStatusCode(), 200);
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String string, String string2) {

		// System.out.println(resp);

		assertEquals(getJsonpath(response, string), string2);
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String name, String resource) throws IOException {
		place_id = getJsonpath(response, "place_id");
		res = given().spec(requestSpecification()).queryParam("place_id", place_id);
		// CALL METHOD--:
		user_calls_with_http_request(resource, "Get");
		String apiname = getJsonpath(response, "name");
		assertEquals(apiname, name);
	}

	@Given("DeletePlace palyload")
	public void deleteplace_palyload() throws IOException {
		res = given().spec(requestSpecification()).body(resource.getDeletePlace(place_id));
	}
}
