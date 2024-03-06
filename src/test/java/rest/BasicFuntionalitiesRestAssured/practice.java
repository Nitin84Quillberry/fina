package rest.BasicFuntionalitiesRestAssured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;

public class practice {
    public static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String resource = "/maps/api/place/update/json";
        System.out.println(" ******************************************Post********************************************\n");
        String Response = given().log().all().queryParam("key", "qaclick123").header("Content-type", "application/json")
                .body("{\n" +
                        "  \"location\": {\n" +
                        "    \"lat\": -38.383494,\n" +
                        "    \"lng\": 33.427362\n" +
                        "  },\n" +
                        "  \"accuracy\": 50,\n" +
                        "  \"name\": \"Frontline house\",\n" +
                        "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                        "  \"address\": \"29, India, India\",\n" +
                        "  \"types\": [\n" +
                        "    \"shoe park\",\n" +
                        "    \"shop\"\n" +
                        "  ],\n" +
                        "  \"website\": \"http://google.com\",\n" +
                        "  \"language\": \"French-IN\"\n" +
                        "}\n" +
                        "")
                .when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200).body("scope",equalTo("APP")).extract().response().asString();

        System.out.println(Response);



        /*How to retrive data */
        JsonPath JsonObect = new JsonPath(Response);
        String Retrived_Id = JsonObect.getString("place_id");
        System.out.println("Id retrived=:" + " " + Retrived_Id);


        System.out.println("*********************************************GET********************************************");
        /* how to use retrived data in GET function*/

        String Get_response = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", Retrived_Id)
                .when().get("/maps/api/place/get/json")
                .then().assertThat().statusCode(200).extract().response().asString();

//        System.out.println(Get_response);


        JsonPath json_obj2 = new JsonPath(Get_response);
        String Retrived_address = json_obj2.getString("address");
//
        System.out.println("REtrived address from GET =:" + " " + Retrived_address);

        System.out.println("**********************PUT********************************************\n");
        /*PUT*/


        String newaddress = "Hydrabad,india ";
        String PutResponse = given().log().all().queryParam("key", "qaclick123")
                .body("{\n" +
                        "\"place_id\":\"" + Retrived_Id + "\",\n" +
                        "\"address\":\"" + newaddress + "\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}\n")
                .when().put(resource)
                .then().assertThat().statusCode(200).extract().response().asString();
        System.out.println("updated address message =:" + PutResponse);


        System.out.println("*****************************************************Delete********************************************");


        String deleteResponse=given().queryParam("key","qaclick123")
                .body("{\n"+
                                "\"place_id\":\"" +Retrived_Id +"\"}")
                .when().delete(resource)
                .then().log().all().assertThat().statusCode(200).extract().response().asString();

//        System.out.println(deleteResponse);


    }


    public static class First {



    public static void main(String[] args) {

            RestAssured.baseURI = "https://rahulshettyacademy.com";

            RestAssured.useRelaxedHTTPSValidation();

            String output = given().log().all().queryParam("key", "qaclick123")
            .header("Content-Type","application/json")
            .body("{\n" +
            "  \"location\": {\n" +
            "    \"lat\": -38.383494,\n" +
            "    \"lng\": 33.427362\n" +
            "  },\n" +
            "  \"accuracy\": 50,\n" +
            "  \"name\": \"Frontline house\",\n" +
            "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
            "  \"address\": \"29, side layout, cohen 09\",\n" +
            "  \"types\": [\n" +
            "    \"shoe park\",\n" +
            "    \"shop\"\n" +
            "  ],\n" +
            "  \"website\": \"http://google.com\",\n" +
            "  \"language\": \"French-IN\"\n" +
            "}\n" +
            "")
                    .when().post("/maps/api/place/add/json")
                    .then().assertThat().statusCode(200).body("scope", equalTo("APP")).extract().response().asString();

            System.out.println(output);



            }

    //                //Get Place
    //
    //                String getPlaceResponse=	given().log().all().queryParam("key", "qaclick123")
    //                        .queryParam("place_id",placeId)
    //                        .when().get("maps/api/place/get/json")
    //                        .then().assertThat().log().all().statusCode(200).extract().response().asString();
    //                JsonPath js1=ReUsableMethods.rawToJson(getPlaceResponse);
    //                String actualAddress =js1.getString("address");
    //                System.out.println(actualAddress);
    //                Assert.assertEquals(actualAddress, "Pacific ocean");
    //                //Cucumber Junit, Testng
    //
    //

                }
}
