package files;
import static io.restassured.RestAssured.*;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.path.json.JsonPath;
public class JiraTest {
	public static void main(String[]args) {
		RestAssured.baseURI ="https://eycakes.atlassian.net";
	    PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
	    authScheme.setUserName("eesamsaied@gmail.com");
	    authScheme.setPassword("I2kHwotg2K2blepTuieo91F6");
	    RestAssured.authentication = authScheme;
	    
		//add comment
		String addcomment = given().pathParam("key", "EY-2").log().all()
		.header("Content-Type","application/json")
		.body("{\n" + 
				"	\"body\": \"Hi how are you i:( ohhhhhhh\"\n" + 
				"	\n" + 
				"}\n" + 
				"").when().post("/rest/api/2/issue/{key}/comment").then().log().all().assertThat().statusCode(201)
		.extract().response().asString();
		JsonPath js = new JsonPath(addcomment);
		String commentId = js.getString("id");
	//add attachment
		given().header("X-Atlassian-Token","no-check").pathParam("key", "EY-2")
		.header("Content-Type","multipart/form-data")
		.multiPart("file",new File("jira.txt"))
		.when()
		.post("rest/api/2/issue/{key}/attachments").then().log().all().assertThat().statusCode(200);
		//get issue
		System.out.println("///////////////////");
		String issueDetails = given().pathParam("key", "EY-2")
				.queryParam("fields", "comment")
			.log().all().
		when().get("rest/api/2/issue/{key}").then().log().all().extract().response().asString();
		
		System.out.println("///////////////////");
		System.out.println(issueDetails);
		JsonPath js1 = new JsonPath(issueDetails);
		int commentsCount = js1.getInt("fields.comment.comments.size()");
		for(int i=0;i<commentsCount;i++)
		{
			String commentIdIssue = js1.get("fields.comment.comments["+i+"].id").toString();
			if(commentIdIssue.equalsIgnoreCase(commentId))
			{
				String commentBody = js1.get("fields.comment.comments["+i+"].body").toString();
				System.out.println(commentBody);
			}
			
		}
	}
	

}
