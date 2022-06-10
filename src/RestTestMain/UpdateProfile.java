package RestTestMain;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class UpdateProfile {
	
	@Test
	public void UpdateProfileInfo() {
		
		RestAssured.baseURI="https://api.apps.atlmoneytransfer.com/client/v1";
		given().log().all()
		.header("X-Client-ID","935a28a6-d8e1-4ff9-b9c4-3c541bb8572a")
		.header("X-Client-Secret","U0GF1314o32Q7383b5DJnF4suC878Jmsw3C28wAr5w7W30gq")
		.header("X-User-Token","4LyXF0trPckBso95ydz26z4BsY13je7o")
		.contentType("multipart/form-data")
		.multiPart("first_name","Arin")
		.multiPart("last_name","Kate")
		.multiPart("date_of_birth","1993-06-10")
		.multiPart("nationality_id","053d21fc-1f39-451a-8b55-8fdd99924e2d")
		.when().post("/customers/update/4db78e3a-0e0c-418f-b5f5-4fcf17b37b9e").then().log().all().statusCode(200);
		
		
	}

}
