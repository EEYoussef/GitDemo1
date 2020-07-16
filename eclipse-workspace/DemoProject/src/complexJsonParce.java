import files.payload;
import io.restassured.path.json.JsonPath;

public class complexJsonParce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonPath js = new JsonPath(payload.CoursePrice());
		int count  = js.getInt("courses.size()");
		System.out.println(count);
		int TotalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(TotalAmount);
		
		String titleFirstCourse = js.get("courses[0].title");
		String courseTitles;
		int coursePrices;
		System.out.println(titleFirstCourse);
	 
		for(int i = 0;i < count;i++)
		{
			courseTitles = js.get("courses["+ i +"].title");
			coursePrices = js.get("courses["+ i +"].price");
			
			System.out.println(js.get("courses["+ i +"].price").toString() );
			System.out.println(courseTitles );
			
			
			
		}
		int copies ;
		int coursePrice;
		int total;
		System.out.println("//////") ;
		for(int i = 0;i < count;i++)
		{
			
			courseTitles = js.get("courses["+ i +"].title");
			if (courseTitles.equalsIgnoreCase("RPA"))
			{
				 copies = js.get("courses["+ i +"].copies");
				System.out.println(copies );
				break;
			}
			
		
			System.out.println("//////") ;
		}
		
	}

}
