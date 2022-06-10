package Pojo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Payload.PayloadRest;

import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson {
	
	@Test(dataProvider = "booksData")
	public void addBook(String isbn, String aisle) {
		
		RestAssured.baseURI = "http://216.10.245.166/";
		String ResponseJson= given().log().all().header("Content-Type","application/json").
		body(PayloadRest.LibraryApiJson(isbn,aisle))
		.when().post("/Library/Addbook.php").
		then().assertThat().statusCode(200).extract().response().asString();
		
		
		System.out.println(ResponseJson);
		JsonPath js = new JsonPath(ResponseJson);
		String id= js.get("ID");
		System.out.println(id);
		
		
		//delete book scenario
		}
	
	@DataProvider(name="booksData")
	public Object[][] getData() {
		
		return new Object[][] {{"hjhkjh","7887"},{"ndhfhfh","090923"},{"uytubm","92425"}};
		
	}

	}



