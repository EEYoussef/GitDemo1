package stepDefinations;
import java.io.IOException;
import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScnario() throws IOException
	{
		StepDefination m = new StepDefination();
		if (StepDefination.place_id ==null)
		{
		m.add_place_playload_with("Eman", "French", "Asia");
		m.user_calls_with_http_request("AddPlaceAPI", "POST");
		m.verify_place_id_created_maps_to_using("Eman", "getPlaceAPI");
		}
	}

}
