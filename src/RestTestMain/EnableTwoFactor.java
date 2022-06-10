package RestTestMain;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class EnableTwoFactor {

	@Test
	public void EnTwoFactor() {
		RestAssured.baseURI="https://api.apps.atlmoneytransfer.com/client/v1";
		given().log().all().header("X-Client-ID","935a28a6-d8e1-4ff9-b9c4-3c541bb8572a")
		.header("X-Client-Secret","U0GF1314o32Q7383b5DJnF4suC878Jmsw3C28wAr5w7W30gq")
		.header("X-User-Token","fr59KHs200QJm9e2K9WupBA2WgTre9TB").contentType("multipart/form-data")
		.multiPart("pin","0000").multiPart("confirm_pin","0000").when().post("/enable-two-factor-auth").then().log().all().statusCode(200);
		
	}
	@Test
	public void TwoFactor() {
		RestAssured.baseURI="https://api.apps.atlmoneytransfer.com/client/v1";
		given().log().all().header("X-Client-ID","935a28a6-d8e1-4ff9-b9c4-3c541bb8572a")
		.header("X-Client-Secret","U0GF1314o32Q7383b5DJnF4suC878Jmsw3C28wAr5w7W30gq")
		.header("X-User-Token","fr59KHs200QJm9e2K9WupBA2WgTre9TB").contentType("multipart/form-data")
		.multiPart("pin","0000").when().post("/two-factor-auth").then().log().all().statusCode(200);
		
	}
}
