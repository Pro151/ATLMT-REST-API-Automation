package Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

public class RestTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//validate if add place API is working as expected
		
		//given - all input details
		//when - submit the API- resource,http/https method
		//Then - validate the response
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(PayloadRest.addPlace()).when().post("/maps/api/place/add/json").then()
		.assertThat().statusCode(200).body("scope", equalTo("APP")).header("Server","Apache/2.4.41 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js= new JsonPath(response); // for parsing json
		js.getString("place_id");
		String placeId=js.getString("place_id");
		
		//update place
		
		String newAddress="70 Summer walk, USA";
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "")
		.when().put("/maps/api/place/update/json").then().assertThat().log().all().statusCode(200).body("msg",equalTo("Address successfully updated"));
		
		//Get placeid
		
		String getplaceResponse = given().log().all().queryParam("key", "qaclick123")
		.queryParam("place_id",placeId).when().get("/maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
		
		JsonPath jsp= new JsonPath(getplaceResponse); // for parsing json
		String actualAddress = jsp.getString("address");
		System.out.println(actualAddress);
		
		//Cucumber Junit, TestNG
		
		Assert.assertEquals(actualAddress,newAddress );
		
		}
	

}
