import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {
	@Test
	public void sumOfcopies()
	{
		JsonPath js = new JsonPath(payload.CoursePrice());
		int count  = js.getInt("courses.size()");
		
		int total;
		int sum=0;
		for(int i = 0;i < count;i++)
		{
			
			
			int coursePrice = js.get("courses["+ i +"].price");
			int copies =js.get("courses["+ i +"].copies");
			int amount = coursePrice * copies;
			//total += coursePrice *copies;
			sum = sum+amount;
			System.out.println(amount );
			
		
	}
		System.out.println(sum );
		int purchaseAmount =js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sum, purchaseAmount);
		
	}

}
