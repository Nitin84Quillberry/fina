package rest.SerializationGoggleMaps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class CreateJsonBySerialization {


    public static void main(String[] args) {

        addPlace ob = new addPlace();
        ob.setAccuracy("10");
        ob.setName("This is nitin's address");
        ob.setPhone_number("6476870108");
        ob.setAddress("84 qillberry");
        ob.setWebsite("Google.com");
        ob.setLanguage("English");
        List<String> myList = new ArrayList();
        myList.add("ABC");
        myList.add("BCD");
        ob.setTypes(myList);
        location l = new location();
        l.setLat(38.090);
        l.setLng(29.098);
        ob.setLocation(l);


//
        RequestSpecification req =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("Key","qaclick123").setContentType(ContentType.JSON).build();
ResponseSpecification res= new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();

        RequestSpecification r=given().spec(req).body(ob);
        Response s=r.when().post("/maps/api/place/add/json").then().spec(res).extract().response();
        String response=s.asString();
        System.out.println(response);
//                baseURI = "https://rahulshettyacademy.com";
//        String Response = given().log().all().queryParam("key", "qaclick123")
//                .body(ob)
//                .when().post("/maps/api/place/add/json")
//                .then().extract().response().asString();
//
//        System.out.println(Response);
    }
}