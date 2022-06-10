package RestTestMain;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class RegisterCreateAc {

	
	@Test
	public void RegisterNewAccount() {
		
		RestAssured.baseURI="https://api.apps.atlmoneytransfer.com/client/v1";
		given().log().all().header("X-Client-ID","935a28a6-d8e1-4ff9-b9c4-3c541bb8572a")
		.header("X-Client-Secret","U0GF1314o32Q7383b5DJnF4suC878Jmsw3C28wAr5w7W30gq")
		.header("X-Client-IP","AUTO_DETECT")
		.header("X-Client-UA","Native Android 11;unknown;Android SDK built for x86;R;true")
		.header("X-Client-Fingerprint","cd1fe299-f34b-4147-8ed1-e3ece3d777b4")
		.contentType("multipart/form-data")
		.multiPart("email","qmerri12@yopmail.com")
		.multiPart("password","Qa123!")
		.multiPart("confirm_password","Qa123!")
		.multiPart("locale","en_US")
		.multiPart("timezone","Asia/Calcutta").when().post("/register").then().log()
		.all().statusCode(201);
		
	}
	
	@Test
	public void meCheckProfile() {
		// to check the profile

		RestAssured.baseURI="https://api.apps.atlmoneytransfer.com/client/v1";
		given().log().all().header("X-Client-ID","935a28a6-d8e1-4ff9-b9c4-3c541bb8572a")
		.header("X-Client-Secret","U0GF1314o32Q7383b5DJnF4suC878Jmsw3C28wAr5w7W30gq")
		.header("X-Client-UA","Native Android 11;unknown;Android SDK built for x86;R;true")
		.when().post("/me").then().log().all().assertThat().statusCode(200);
		
	}

}