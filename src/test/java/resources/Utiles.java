package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utiles {
	public static RequestSpecification p;
	ResponseSpecification r;

	public RequestSpecification requestSpecification() throws IOException {
		if (p == null) {
			PrintStream log = new PrintStream(new FileOutputStream("looging.txt"));

			p = new RequestSpecBuilder().setBaseUri(getGlobalvalue("baseURl")).setContentType(ContentType.JSON)
					.addQueryParam("key", "qaclick123").addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
			return p;
		}
		return p;
	}

	public ResponseSpecification ResponseSpecification() {
		r = new ResponseSpecBuilder().expectStatusCode(200).expectHeader("Server", "Apache/2.4.18 (Ubuntu)").build();
		return r;
	}

	public String getGlobalvalue(String key) throws IOException {
		Properties global = new Properties();
		FileInputStream fis = new FileInputStream(
				"D:\\Api_Automation\\Api_Workspace\\ApiFrameworkCucmber\\src\\test\\java\\resources\\global.properties");
		global.load(fis);

		return global.getProperty(key);
	}

	public String getJsonpath(Response res, String key) {
		String resp = res.asString();
		JsonPath jss = new JsonPath(resp);
		return jss.get(key).toString();
	}
}
