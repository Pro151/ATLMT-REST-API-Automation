import org.testng.Assert;
import org.testng.annotations.Test;

import Payload.PayloadRest;
import io.restassured.path.json.JsonPath;

public class SumValidation {

	@Test
	public void SumCoursesPrice() {
		
		//int expectedAmount=910;
		JsonPath js1=new JsonPath(PayloadRest.opjectStringJESON());
		int count = js1.getInt("courses.size()");
		
		int sum=0;
		for(int i=0;i<count;i++) {
			
			
			
			int price = js1.get("courses["+i+"].price");
			int copies = js1.get("courses["+i+"].copies");
			
			int amount = price*copies;
			System.out.println(amount);
			sum=sum+amount;
			
			
		}
		System.out.println("Total sum is: "+sum);
		 int purchaseAmnt= js1.getInt("dashboard.purchaseAmount");
		
		/*if(purchaseAmnt==sum) {
			
			System.out.println("The total price & the sum of all prices are matched successfully");
		}*/
		
		Assert.assertEquals(sum,purchaseAmnt);
	}
	
}
