package rest.BasicFuntionalitiesRestAssured;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;



public class copied {

        @Test

        public void addBook() throws IOException



        {



            RestAssured.baseURI="http://216.10.245.166";

            String resp=given().

                    header("Content-Type","application/json").

                    body(GenerateStringFromResource("C:\\Users\\NITIN KOHLI\\Desktop\\bookData.json")).

                    when().

                    post("/Library/Addbook.php").

                    then().assertThat().statusCode(200).

                    extract().response().asString();

            JsonPath js=new JsonPath(resp);

            String id=js.get("ID");

            System.out.println(id);



            //deleteBOok

        }

        public static String GenerateStringFromResource(String path) throws IOException {



            return new String(Files.readAllBytes(Paths.get(path)));



        }

    }



