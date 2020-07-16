package files;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import pojo.GetCourse;
import pojo.WebAutomation;
import pojo.api;
public class oAuthTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] CourseTitle = {"Selenium Webdriver Java" , "Cypress","Protractor"};
		//String url="https://accounts.google.com/CheckCookie?hl=en&checkedDomains=youtube&checkConnection=youtube%3A846%3A1&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&chtml=LoginDoneHtml&service=lso&continue=https%3A%2F%2Faccounts.google.com%2Fsignin%2Foauth%2Fconsent%3Fauthuser%3Dunknown%26part%3DAJi8hAOnHIf8Q-EVG85JHUXuF6u0fmQx7G6hYpUMVBI_eBHTWyYbK02jUjUXRhd1f58RAbQJRYWBAgDbqinI3pS74NPYHD0CgnZ76wYdLE97n3s6zwMD2pGJZlgwGTCA0vF3oYj8BrTzyinZch1wUkjrQYPi1GAfgrjP_d2nyrTCkpM36bbcBuOdAhbImC36c8xm8aQR0u4X9OF9MHOyRcupWv563M_5zaa0WL-I1HXJThvMsoEfRjctWRo9tMoTc-pHIGpJ2PYKK-2MiI_W7kI1b2Bg1SPNJR-K8wqHc2Oi0IQmB1FKqhiJl0U6P0aYqS73DqsbfG-geq5FmzOOf1RDJKSD3I0e15Dsovg3-Kcx3sWL9EioaO8-NM7267iXHaTeVm5I0kb6ubjCWw7EU25Hibx8YpcNw1Q_5B_OxsKHCZzxY4qb217DN8gzV06pHF7UtOKZJgFQ%26as%3DSL26rOXJeX5CKR0QuVyZOA%26rapt%3DAEjHL4M8YPDwCDMbxOoxBUGd3JmszZkicZJXTiLxAsQWCnSFMevtG50Q1fD119cA-c1SCDvMnNVLxTBUwWgG7egoRhxUrjjcpg%23&gidl=EgIIAA";
		String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F1gG1ycVF-xkKzv6AeAa3z_7nduv6Em3b1JiGqlTDG2UpM30g9I2Ttu4kDo-B1d0_bMIJPxL0zXjF_Tr-fo0bdu4&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
		String parialcode = url.split("code=")[1];
		String code = parialcode.split("&scope")[0];
		System.out.println(code);
		
		String accessTokenResponse=	given().urlEncodingEnabled(false)
				.queryParams("code","4%2F1gG1ycVF-xkKzv6AeAa3z_7nduv6Em3b1JiGqlTDG2UpM30g9I2Ttu4kDo-B1d0_bMIJPxL0zXjF_Tr-fo0bdu4")
				.queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")	 
				.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.queryParams("grant_type", "authorization_code")
				.queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
				.when().log().all()
				.post("https://www.googleapis.com/oauth2/v4/token").asString();
			JsonPath js = new JsonPath(accessTokenResponse);
			String accessToken = js.getString("access_token")	;
				
				
			
			GetCourse gc  = given().queryParam("access_token","ya29.a0AfH6SMA-jJXxbPV76lzzMoxDYaiYhmcN5crbqrVqWj67myzbVhpAXe8qsdKB14cYMCLx0-W_jYpBnOOFYtYeeQlY9OV9_lUOoJcz3jLMxAZpYz9arDL1-39dnGV9SrcfFCKom7qJv8VhJ6m8nPuu1itf3I-y73CuBwUh").expect().defaultParser(Parser.JSON)
				.when()
				.get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);
				
			System.out.println(gc.getLinkedIn());
			System.out.println(gc.getInstructor());
			System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());

		List<api> apiCourses = gc.getCourses().getApi();
		List<WebAutomation> webAuto = gc.getCourses().getWebAutomation();
		
		
	for (int i =0; i<apiCourses.size();i++)
	{
		if(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
		{
			System.out.println(apiCourses.get(i).getPrice());
		}
	}
		//System.out.println(response);
	ArrayList<String> arrayofcourses = new ArrayList<String>();

	for (int i =0; i<webAuto.size();i++)
	{
		
		arrayofcourses.add(webAuto.get(i).getCourseTitle());
		
	}
	List<String> expectedList = Arrays.asList(CourseTitle);
	
	Assert.assertTrue(arrayofcourses.equals(expectedList));
	}

}
