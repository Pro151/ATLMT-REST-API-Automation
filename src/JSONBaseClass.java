import Payload.PayloadRest;
import io.restassured.path.json.JsonPath;
//import java.lang.Object;
//import groovy.lang.Closure;


public class JSONBaseClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JsonPath js1=new JsonPath(PayloadRest.opjectStringJESON());
		
		int count = js1.getInt("courses.size()");
		System.out.println(count);
		int totalAmount = js1.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);
		
		
		//print title of first course
		
		//String firstCourseTiltle = js.get("courses[0].title");
		//System.out.println(firstCourseTiltle);

			
		for(int i=0; i<count; i++) {
			
			String courseTitle = js1.get("courses["+i+"].title");
			System.out.println(js1.get("courses["+i+"].price").toString());
			System.out.println(courseTitle);
			
		}
		
		System.out.println("Print no of copies sold for RPA");
		
		for(int i=0; i<count; i++) {
			
			String courseTitle = js1.get("courses["+i+"].title");
			
			if(courseTitle.equalsIgnoreCase("RPA")) {
				
				//copy sold
				int copiesCount = js1.get("courses["+i+"].copies");
				System.out.println(copiesCount);
				break;
			}
		}
	}

}
