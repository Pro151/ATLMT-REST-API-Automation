package RestTestMain;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetRecipient {


	@Test
	public void GetRecipientDetails() {
		
		RestAssured.baseURI="https://api.apps.atlmoneytransfer.com/client/v1";
		given().log().all().header("X-Client-ID","935a28a6-d8e1-4ff9-b9c4-3c541bb8572a")
		.header("X-Client-Secret","U0GF1314o32Q7383b5DJnF4suC878Jmsw3C28wAr5w7W30gq")
		.header("X-User-Token","8A8DVFh1B7pw33VF5xP78Wi5izi7G842").when().get("/recipients/89d18248-f6a6-4640-a41b-aca4a716c0ae")
		.then().log().all().assertThat().statusCode(200);
	}
}
