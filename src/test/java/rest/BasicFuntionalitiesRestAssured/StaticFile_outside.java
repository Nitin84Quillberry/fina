package rest.BasicFuntionalitiesRestAssured;




import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class StaticFile_outside {

    @Test
    public void getMethod() throws IOException {

        RestAssured.baseURI = "";
        String post_response = given().log().all().header("", "")
                .body(filepath("C:\\Users\\NITIN KOHLI\\Desktop\\bookData.json"))
                .when().post("")
                .then().assertThat().statusCode(200).extract().response().asString();

    }




    public String filepath(String path)  throws IOException {


        return new String(Files.readAllBytes(Paths.get(path)));

    }

}