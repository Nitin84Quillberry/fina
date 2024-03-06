package rest.BasicFuntionalitiesRestAssured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;


public class BookAPI {
    List<String> allid=new ArrayList<String>();
    @Test(dataProvider = "dataAPI")
    public void addbooks(String isbn,String aisle) {
        RestAssured.baseURI = "http://216.10.245.166";

        String PostResponse = given().log().all().header("Content-Type", "application/json")
                .body(SourcePayload.addbook(isbn, aisle))
                .when().post("/Library/Addbook.php")
                .then().assertThat().statusCode(200).extract().response().asString();

        System.out.println(PostResponse);

        JsonPath js = new JsonPath(PostResponse);
        String id = js.getString("ID");
        System.out.println(id);

        allid.add(id);
        System.out.println("All ids are "+allid);


        }
    @Test
    public void delete(){


        for ( int i = 0; i <allid.size() ; i++ ) {
            String idd=allid.get(i);
            System.out.println(idd);
            given().log().all().body("{\n" +
                    " \n" +
                    "\"ID\" : \""+ idd +"\"\n" +
                    " \n" +
                    "} \n")
                    .when().delete("/Library/DeleteBook.php")
                    .then().assertThat().statusCode(200).extract().response().asString();

        }

    }


        @DataProvider(name = "dataAPI")
        public Object[][] getdata () {
            return new Object[][]{{"afjjmcf", "1247034"}, {"qekfmod", "2140328"}, {"sfguyfss", "468243"}};


        }



}
