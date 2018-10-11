package RestApiTest;

import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.equalToPath;
import static org.hamcrest.MatcherAssert.assertThat; 
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static org.hamcrest.Matchers.*;


import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class UseCase1Test{
	
	@Test(description="To test sample get request and validate Status code ")
	public void sampleGetTests() {
		given().
			get("https://jsonplaceholder.typicode.com/todos/1").
		then().
			statusCode(200).
		log().all();
	}
	
	@Test
	public void sampleGetTestOne() {
		given().
			get("https://jsonplaceholder.typicode.com/todos/1").
		then().
			body("title", equalTo("delectus aut autem"));
	}
    
	@Test
	public void getRequestWithParams() {
		given().
			param("postId", "1").
			contentType("application/json").
		when().
			get("https://jsonplaceholder.typicode.com/comments").
		then().
			statusCode(200).
			body("$", hasSize(5));
	}
	
	@Test
	public void getRequestSchemaValidation() {
		given().
			get("https://jsonplaceholder.typicode.com/todos/1").
		then().
			statusCode(200).
		body(matchesJsonSchemaInClasspath("todos.json"));
	}
}