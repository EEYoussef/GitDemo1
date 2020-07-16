import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojoMaps.location;
import pojoMaps.mapLocation;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
public class serializeTest {

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
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
		.addQueryParam("key", "qaclick123")
		.setContentType(ContentType.JSON).build();
		ResponseSpecification respec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		RequestSpecification  res = given().spec(req).body(addplace);
		
		Response response = res.when().post("/maps/api/place/add/json")
		.then().spec(respec).extract().response();
		
		String responseString = response.asString();
		System.out.println(responseString);  

	}

}
