import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojoMaps.location;
import pojoMaps.mapLocation;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
public class specBuilderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		mapLocation addplace=new mapLocation();
		addplace.setAccuracy(50);
		addplace.setAddress("29, side layout, cohen 09");
		addplace.setLanguage("English");
		addplace.setName("Frontline house");
		addplace.setPhone_number( "(+91) 983 893 3937");
		List <String> mylist = new ArrayList<String>();
		mylist.add("shoe park");
		mylist.add( "shop");
		addplace.setTypes(mylist);
		location l = new location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		addplace.setLocation(l);
		
		addplace.setWebsite("http://google.com");
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		
		Response  response = given().queryParam("key", "qaclick123")
		.body(addplace)
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response();
		String responseString = response.asString();
		System.out.println(responseString);  

	}

}
