package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.location;
import pojo.mapLocation;

public class TestDataBuild {
	public mapLocation addPlacePayload(String name, String language,String address) {
		
		mapLocation addplace=new mapLocation();
		addplace.setAccuracy(50);
		addplace.setAddress(address);
		addplace.setLanguage(language);
		addplace.setName(name);
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
		return addplace;
	}
public String deletePlacePayload(String placeId)
{
	//System.out.println("{\\r\\n    \\\"place_id\\\":\\\" "+ placeId + "   \\t \\t\\r\\n}");

	return "{\r\n    \"place_id\":\""+ placeId +"\"   \t \t\r\n}";
	}
}
