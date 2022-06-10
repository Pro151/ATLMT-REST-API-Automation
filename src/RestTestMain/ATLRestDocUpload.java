package RestTestMain;
import io.restassured.RestAssured;
import io.restassured.response.Response;
 
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;
 
import java.io.File;

import org.testng.annotations.Test;
 
public class ATLRestDocUpload {
 
    @Test
    public void uploadFile() {
        File testUploadFile = new File("C:\\Users\\Promit\\Downloads\\Test\\atlmt\\Bugs\\Payout_Method_1.png");
        File testFile1 = new File("C:\\Users\\Promit\\Downloads\\Test\\atlmt\\Bugs\\Payout_Method.png"); //Specify your own location and file
 
        RestAssured.baseURI="https://api.apps.atlmoneytransfer.com/client/v1";
 
        		given().log().all().header("X-Client-ID","935a28a6-d8e1-4ff9-b9c4-3c541bb8572a")
        		.header("X-Client-Secret","U0GF1314o32Q7383b5DJnF4suC878Jmsw3C28wAr5w7W30gq")
        		.header("X-User-Token","1ujj7geb1IucLl4PvLs3Be67L65x4148")
        		.contentType("application/x-www-form-urlencoded").pathParam("pages[0][uri]", testFile1).multiPart(testUploadFile)
        		//.pathParam("pages[1][uri]", testFile1).multiPart(testFile1)
            .when()
            .post("/customers/upload-document/d1d0e82c-c65e-4de6-aa92-97a7843d1aa4/0ea60a79-9a27-4a73-9fb8-5597ea24cf93")
        	.then().log().all().statusCode(200);
 
        //System.out.println(response.getStatusCode());
        //System.out.println(response.asString());
 
        //assertTrue(response.asString().contains("successfully uploaded"));
    }
}




/*package RestTestMain;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

import Payload.PayloadRest;
public class ATLRestDocUpload {
	
	
	@Test
	public void AddDocument() {
		
		RestAssured.baseURI="https://api.apps.atlmoneytransfer.com/client/v1";
		given().log().all().header("X-Client-ID","935a28a6-d8e1-4ff9-b9c4-3c541bb8572a")
		.header("X-Client-Secret","U0GF1314o32Q7383b5DJnF4suC878Jmsw3C28wAr5w7W30gq")
		.header("X-User-Token","1ujj7geb1IucLl4PvLs3Be67L65x4148").contentType("multipart/form-data")
		.multiPart("file",new File("rmt.txt"))
		.when().post("/customers/upload-document/539c0338-5117-4a6a-bcfa-935cf818facf/0af52c39-b32c-4e5b-a0da-8b534bf1fae5")
		.then().log().all().statusCode(200);
		
		
		
		.pathParam("key","pages[0]").multiPart(testUploadFile)
        		//.pathParam("key","pages[1]").multiPart(testFile1)
		
	}
	

}*/



