package rest.JIRA;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class addFileToRest {

        public static String sessionValue;
        public static String Issueid;
        public static String addCommentId;


        @BeforeTest
        public void beforeTest() {
            baseURI = "http://localhost:8080";

            //Getting Session value key
            String Rsp = given().log().all().header("Content-Type", "application/json")
                    .body("{\"username\":\"nitnkohli\",\"password\":\"Isha$5\"}\n" +
                            "\n")
                    .when().post("/rest/auth/1/session")
                    .then().assertThat().statusCode(200).extract().response().asString();


            System.out.println(Rsp);

            JsonPath js = new JsonPath(Rsp);
            sessionValue = js.getString("session.value");
            System.out.println("Extrated Value:" + sessionValue);


        }


        @Test
    public void addFile(){

            String res = given().log().all().header("Content-Type", "application/json").
                    header("Cookie", "JSESSIONID=" + sessionValue).
                    body("{" +
                            "\"fields\": {" +
                            "\"project\":{" +
                            "\"key\": \"AP\"" +
                            "}," +
                            "\"summary\": \"Issue for check adding comment\"," +
                            "\"description\": \"Creating my second bug\"," +
                            "\"issuetype\": {" +
                            "\"name\": \"Bug\"" +
                            "}" +
                            "}}").when().
                    post("/rest/api/2/issue").then().statusCode(201).extract().response().asString();

            System.out.println(res);

            //getting issue ID
            JsonPath j2 = new JsonPath(res);
            Issueid = j2.getString("id");



//Add File in attachments
//            given().log().all().header("X-Atlassian-Token","no-check").header("Content-Type","multipart/form-data")
////                    .multiPart("File",new File("abc.txt"))
//                    .multiPart("File",new File("C:\\Users\\NITIN KOHLI\\IdeaProjects\\RestAssuredAPI\\src\\test\\java\\rest\\JIRA\\abc.txt"))
//                    .when().post("/rest/api/2/issue/"+Issueid+"/attachments")
//                    .then().log().all().assertThat().statusCode(200).extract().response();


//GET ISSUE
           String getResponse= given().log().all().header("Content-Type", "application/json").
                    header("Cookie", "JSESSIONID=" + sessionValue).queryParam("fields","comment")
                    .when().get("/rest/api/2/issue/"+Issueid+"")
                    .then().assertThat().extract().response().asString();

            System.out.println(getResponse);



        }

}
