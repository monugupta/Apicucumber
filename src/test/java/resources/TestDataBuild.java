package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Mainjaon;
import pojo.location;

public class TestDataBuild {
	public Mainjaon add_Place_Payload(String setAddress, String setLanguage, String setName) {
		Mainjaon js = new Mainjaon();
		js.setAccuracy(50);
		js.setAddress(setAddress);
		js.setLanguage(setLanguage);
		js.setWebsite("http://google.com");
		js.setName(setName);
		List<String> l = new ArrayList<String>();
		l.add("shoe park");
		l.add("shop");
		js.setTypes(l);
		location loc = new location();
		loc.setLat(-38);
		loc.setLng(39);
		js.setLocation(loc);
		return js;
	}

	public String getDeletePlace(String place_id) {
		return "{\r\n    \"place_id\":\"" + place_id + "\"\r\n}";
	}

}
