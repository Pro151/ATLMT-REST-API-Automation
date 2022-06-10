package RestTestMain;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.lang.System.Logger;
import java.util.logging.FileHandler;

import org.testng.annotations.Test;

import Payload.PayloadRest;


public class VersionCheckLog {
	
	@Test
	public void versionCheck() {
		// to check the app version

		RestAssured.baseURI="https://api.apps.atlmoneytransfer.com/client/v1";
		given().log().all().header("X-Client-ID","c166652d-93e2-4822-95c4-1106836eef69").header("X-Client-Secret","56iZ7J99pW0xgN084d6yr824ET9Wd101CCu06fKrchI5N1il")
		.when().post("/android/version-check/3").then().log().all().assertThat().statusCode(200);;
	
		}
	
	
	/*@Test
	public void meCheckProfile() {
		// to check the profile

		RestAssured.baseURI="https://api.apps.atlmoneytransfer.com/client/v1";
		given().log().all().header("X-Client-ID","935a28a6-d8e1-4ff9-b9c4-3c541bb8572a")
		.header("X-Client-Secret","U0GF1314o32Q7383b5DJnF4suC878Jmsw3C28wAr5w7W30gq")
		.when().post("/me").then().log().all().assertThat().statusCode(200);
	
		}*/
	
	
	
	
	
	
	
	


	
}
