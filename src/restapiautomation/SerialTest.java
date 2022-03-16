package restapiautomation;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import pojo.AddPlace;
import pojo.Location;

public class SerialTest {

	public static void main(String args[]) {
	
	AddPlace p = new AddPlace();
	p.setAccuracy(50);
	p.setName("Frontline house");
	
	List<String> myList = new ArrayList<String>();
	myList.add("shoe park");
	myList.add("shoe");
	p.setTypes(myList);
	
	Location l = new Location();
	l.setLat(-38.383494);
	l.setLng(33.427362);
	p.setLocation(l);
	
	p.setAddress("29, side layout, cohen 09");
	p.setLanguage("French-IN");
	p.setPhone_number("(+91)9113283893");
	p.setWebsite("https://rahulshettyacademy.com");
	
	RestAssured.baseURI= "https://rahulshettyacademy.com";
	 String res=
	    given().log().all().queryParam("key","qaclick123")
	    .body(p)
	    .when().post("maps/api/place/add/json")
	    .then().assertThat().log().all().statusCode(200).extract().response().asString();
	 System.out.println(res);
	}
}