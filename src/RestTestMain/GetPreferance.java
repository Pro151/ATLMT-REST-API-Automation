package RestTestMain;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetPreferance {

	@Test
	public void ChangePreferances() {
		
		RestAssured.baseURI="https://api.apps.atlmoneytransfer.com/client/v1";
		given().log().all().header("X-Client-ID","935a28a6-d8e1-4ff9-b9c4-3c541bb8572a")
		.header("X-Client-Secret","U0GF1314o32Q7383b5DJnF4suC878Jmsw3C28wAr5w7W30gq")
		.header("X-User-Token","93X37Aalx3Wng2XsnDviftZFG7viKZ9X").contentType("multipart/form-data")
        .multiPart("timezone", "Asia/Kolkata")
        .multiPart("locale", "en_GB").when().post("/update-preferences").then().log().all().statusCode(200);
	}
}
