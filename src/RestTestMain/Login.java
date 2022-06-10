package RestTestMain;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Login {
	@Test
	public void LoginCheck() {
		// to check the profile

		RestAssured.baseURI="https://api.apps.atlmoneytransfer.com/client/v1";
		given().log().all().header("X-Client-ID", "935a28a6-d8e1-4ff9-b9c4-3c541bb8572a")
		  .header("X-Client-Secret", "U0GF1314o32Q7383b5DJnF4suC878Jmsw3C28wAr5w7W30gq")
		  .header("X-Client-IP", "AUTO_DETECT")
		  .header("X-Client-Fingerprint", "ac7d0510-1edc-4645-8ac4-cb7bc204756e")
		  .header("X-Client-UA", "Native App0.0.3;iOS:15.0;Apple;Simulator iPhone 13;true").contentType("multipart/form-data")
          .multiPart("email", "qmerr12@yopmail.com")
          .multiPart("password", "Qa123!").when().post("/login").then().log().all().assertThat().statusCode(200);
	
		}

}
