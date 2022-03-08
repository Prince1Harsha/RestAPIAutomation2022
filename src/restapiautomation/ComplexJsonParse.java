package restapiautomation;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	/*TEST CASES: 
	 * 1. Print No of courses returned by API
	 * 2.Print Purchase Amount
	 * 3. Print Title of the first course
	 * 4. Print All course titles and their respective Prices
	 * 5. Print no of copies sold by RPA Course
	 * 6. Verify if Sum of all Course prices matches with Purchase Amount
	 */
	public static void main(String[] args) 
	{
		JsonPath js = new JsonPath(Payload.CoursePrice());
		
		//1.Print No of courses returned by API
		System.out.println("1.Print No of courses returned by API");
		int coursesCount = js.getInt("courses.size()");
		System.out.println(coursesCount);
		
		//2.Print Purchase Amount
		System.out.println("2.Print Purchase Amount");
		int totalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);
		
		//3.Print Title of the first course
		System.out.println("3.Print Title of the first course");
		String titleFirstCourse = js.getString("courses[0].title");
		System.out.println(titleFirstCourse);
		
		//4. Print All course titles and their respective Prices
		System.out.println("4. Print All course titles and their respective Prices");
		for(int i=0;i<coursesCount;i++)
		{
			String courseTitles = js.get("courses["+i+"].title");
			System.out.println(courseTitles);
			System.out.println(js.get("courses["+i+"].price").toString());
		}
		
		//5. Print no of copies sold by RPA Course
		System.out.println("5. Print no of copies sold by RPA Course");
		for(int i=0;i<coursesCount;i++)
		{
			String courseTitles = js.get("courses["+i+"].title");
			if(courseTitles.equalsIgnoreCase("RPA"))
			{
				int copies = js.get("courses["+i+"].copies");
				System.out.println(copies);
				break;
			}
		}
		
	}
}
