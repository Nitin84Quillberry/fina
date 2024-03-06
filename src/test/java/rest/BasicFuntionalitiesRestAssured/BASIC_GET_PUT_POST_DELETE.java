package rest.BasicFuntionalitiesRestAssured;

import data.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.springframework.test.annotation.SystemProfileValueSource;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


public class BASIC_GET_PUT_POST_DELETE {

    public static void main(String[] args) {
//*POST Method*

        RestAssured.baseURI = ("https://rahulshettyacademy.com");

        String Responce = given().log().all().header("Content-Type", "application/json").queryParam("key", "qaclick123")
//                .body("data.payload2")
                .body("{\n" +
                        "  \"location\": {\n" +
                        "    \"lat\": -38.383494,\n" +
                        "    \"lng\": 33.427362\n" +
                        "  },\n" +
                        "  \"accuracy\": 50,\n" +
                        "  \"name\": \"Isha and Nitin house\",\n" +
                        "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                        "  \"address\": \"29, side layout, cohen 09\",\n" +
                        "  \"types\": [\n" +
                        "    \"shoe park\",\n" +
                        "    \"shop\"\n" +
                        "  ],\n" +
                        "  \"website\": \"http://gooe.com\",\n" +
                        "  \"language\": \"French-IN\"\n" +
                        "}\n")
                .when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200).body("scope", equalTo("APP")).extract().response().asString();

        System.out.println("*Post* method output=========" + Responce);


//*GET Method*

        JsonPath Js = new JsonPath(Responce);
        String RetrivedID = Js.getString("place_id");

        JsonPath js2 = new JsonPath(Responce);
        String actualPath = js2.getString("address");
        System.out.println("Actual path comes as =" + actualPath);
        System.out.println("ID to use in get method= " + RetrivedID);

        /* now use this id in get method to retreive data */


        String GETResponse = given().log().all().header("Content-Type", "application/json").queryParam("key", "qaclick123").queryParam("place_id", RetrivedID)
                .when().get("/maps/api/place/get/json")
                .then().assertThat().statusCode(200).extract().response().asString();


        System.out.println("**Get Method Response**===== from Payload =  " + GETResponse);


        /* *PUT Method* */

        String NewAddress = "84 Quillberry";
        String PUTResponse = given().log().all().header("key", "qaclick123").queryParam("place_id", RetrivedID)
                .body("{\n" +
                        "\"place_id\":\"" + RetrivedID + "\",\n" +
                        "\"address\":\"" + NewAddress + "\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}\n")
                .when().put("/maps/api/place/update/json")
                .then().assertThat().statusCode(200).extract().response().asString();


        System.out.println("PUT Response ====" + PUTResponse);


    }


}
