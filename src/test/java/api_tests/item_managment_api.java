package api_tests;

import java.io.File;


import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.DataReader;

public class item_managment_api {
	String token;
	String baseurl = "http://crater.primetech-apps.com";
	Integer item_id ;
	Response response;
	
	@Test
	public void login_test()  {
		String payload = "{\n"
				+ "    \"username\": \""+DataReader.getProperty("crater_email")+"\",\n"
				+ "    \"password\": \""+DataReader.getProperty("crater_password")+"\",\n"
				+ "    \"device_name\": \"mobile_app\"\n"
				+ "}";
		 response=given().contentType("application/json").body(payload)
		.when().post(baseurl+"/api/v1/auth/login");
		
		response.prettyPrint();
		token = response.jsonPath().get("token");
	}
	
	
	@Test(dependsOnMethods={"login_test"},groups= {"smoke-test"})
	public void list_all_items() {
		response = given().accept("application/json").auth().oauth2("Bearer " + token)
		.when().get(baseurl+"/api/v1/items");
		
		response.prettyPrint();
		response.then().statusCode(200).contentType("application/json");
	}
	
	@Test(dependsOnMethods="login_test")
	public void create_item() {
		Map<String, Object>payload = new HashMap<>();
		payload.put("name", "backpack");
		payload.put("price", 7777);
		payload.put("unit_id", 10);
		payload.put("description", "back");
		
		response = given().auth().oauth2("Bearer "+token).body(payload).contentType("application/json")
		.when().post(baseurl+ "/api/v1/items");
		
		item_id = response.jsonPath().get("data.id");
		
		String item_name = response.jsonPath().get("data.name");
		
	}
	
	@Test(dependsOnMethods="create_item")
	public void get_item() {
		response = given().auth().oauth2("Bearer "+token).accept("application/json")
				.when().get(baseurl+"/api/v1/items/"+item_id);
				
				response.then().statusCode(200).contentType("application/json");
				int id = response.jsonPath().get("data.id");
				Assert.assertEquals(id,item_id);
			System.out.println(id + " This is ID of the ITEM");
				
	}
	
	@Test(dependsOnMethods="get_item")
	public void update_item() {
		File payload = new File("./src/test/resources/testfiles/update_item_data.json");
		response = given().auth().oauth2("Bearer "+token).contentType("application/json").body(payload)
		.when().put(baseurl+"/api/v1/items/"+item_id);
		response.prettyPrint();
		
		response.then().statusCode(200).contentType("application/json");
	}
	
	@Test(dependsOnMethods="update_item")
	public void delete_item() {
		
		String payload = "{\r\n"
				+ "    \"ids\": [\r\n"
				+ "        "+item_id+"\r\n"
				+ "    ]\r\n"
				+ "}";
		
		response = given().auth().oauth2("Bearer "+token).contentType("application/json").body(payload)
				.when().post(baseurl +"/api/v1/items/delete");
		
		response.then().statusCode(200).contentType("application/json");
	}
	
}










