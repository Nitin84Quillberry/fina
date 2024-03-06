package rest.MainDeserialzationTopic;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

import java.util.List;

import static io.restassured.RestAssured.given;

public class mobile {

    private String courseTitle;

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String price;

    public static class getAccessToken {

        public static void main(String[] args) {
            String url = "https://rahulshettyacademy.com/getCourse.php";


            String Authorization_response = "https://rahulshettyacademy.com/getCourse.php?code=4%2F3AHON5A56Vb-rrd_8fcZD0BnNecZ4tXZJV9HI7Qc6wlQN3sAZ8diXz5XChEZNtg8IvfC2O_2gCM8ChPpWkoJrXg&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none#";
            String a = Authorization_response.split("code=")[1];
            String code = a.split("&scope")[0];
            System.out.println("Authorization code=:" + code);

            String accessToken_Response = given().log().all().urlEncodingEnabled(false)
                    .queryParams("code", code)
                    .queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                    .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
                    .queryParams("redirect_uri", url)
                    .queryParams("grant_type", "authorization_code")
                    .when().post("https://www.googleapis.com/oauth2/v4/token")
                    .then().extract().asString();

            System.out.println(accessToken_Response);

            JsonPath j = new JsonPath(accessToken_Response);
            String Accesstoken = j.getString("access_token");

            System.out.println("Access Token :" + Accesstoken);


            deserialization gc = given().queryParam("access_token", Accesstoken).expect().defaultParser(Parser.JSON)
                    .when()
                    .get("https://rahulshettyacademy.com/getCourse.php").as(deserialization.class);

            System.out.println(gc.getServices());
            System.out.println( gc.getExpertise());
            System.out.println(gc.getInstructor());
            System.out.println(gc.getLinkedIn());


            List<api> getApi =gc.getCourses().getApi();
    //        for ( int i = 0; i <getApi.size() ; i++ ) {
                System.out.println(getApi.get(1).getCourseTitle());
                System.out.println(getApi.get(1).getPrice());
                System.out.println(getApi.get(0).getCourseTitle());
                System.out.println(getApi.get(0).getPrice());
    //        }

        }


    }
}
