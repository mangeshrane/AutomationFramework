package testBase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

public class RestBase {

	Logger log = Logger.getLogger("AutomationFramework-REST");
	public static String path;
	public static String jsonPathTerm;                                                                                                                                                                                                                                                                                                                

	// Sets Base URI
	public static void setBaseURI() {
		RestAssured.baseURI = "http://api.5min.com";
	}

	public static void resetAll() {
		RestAssured.reset();
	}

	// Sets base path
	public static void setBasePath(String basePathTerm) {
		RestAssured.basePath = basePathTerm;
	}

	// Reset Base URI (after test)
	public static void resetBaseURI() {
		RestAssured.baseURI = null;
	}

	// Reset base path
	public static void resetBasePath() {
		RestAssured.basePath = null;
	}

	// Sets ContentType
	public static void setContentType(ContentType Type) {
		given().contentType(Type);
	}

	// Sets Json path term
	public static void setJsonPathTerm(String jsonPath) {
		jsonPathTerm = jsonPath;
	}
	
	
	// Created search query path
	public static void createSearchQueryPath(String searchTerm, String param, String paramValue) {
		path = searchTerm + "/" + jsonPathTerm + "?" + param + "=" + paramValue;
	}

	// Returns response
	public static Response getResponse() {
		// System.out.print("path: " + path +"\n");
		return get(path);
	}

	// Returns JsonPath object
	public static JsonPath getJsonPath(Response res) {
		String json = res.asString();
		// System.out.print("returned json: " + json +"\n");
		return new JsonPath(json);
	}
	
	public long getResponseTime(Response response) {
		long timeInMS = response.time();
	    long timeInS = response.timeIn(TimeUnit.SECONDS);
		return timeInS;
	}
}
