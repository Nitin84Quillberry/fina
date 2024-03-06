package rest.BasicFuntionalitiesRestAssured;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class nestedAPI {
    public static void main(String[] args) {

        JsonPath j = new JsonPath(SourcePayload.Payload());

        Integer amount = j.getInt("dashboard.purchaseAmount");
        System.out.println(amount);


        String Firstsubject = j.getString("courses[0].title");
        System.out.println(Firstsubject);


        //        Integer numverCource=j.getInt("courses.size()");
        //        System.out.println(numverCource);

        int size = j.getInt("courses.size()");
        System.out.println(size);


        HashMap<String, Integer> values = new HashMap<String, Integer>();
        for ( int i = 0; i < size; i++ ) {
            values.put(j.getString("courses[" + i + "].title"), j.getInt("courses[" + i + "].price"));

        }
        System.out.println(values.entrySet());

        //  RPA cource
        List<String> ListName = new ArrayList<String>();
        String a = null;
        for ( int i = 0; i < size; i++ ) {

            a = j.getString("courses[" + i + "].title");
            ListName.add(a);

        }
        System.out.println(ListName);

        for ( int i = 0; i < ListName.size(); i++ ) {
            if (ListName.get(i).equalsIgnoreCase("Selenium Python")) {
                System.out.println("found");
                System.out.println(j.getString("courses[" + i + "].price"));
                break;

            }

        }



        int totalCost = 0;
        List<Integer> total=new ArrayList<Integer>();
        int size1=j.getInt("courses.size()");
        for ( int i = 0; i < size1 ; i++ ) {

            int individualSum=j.getInt("courses["+i+"].price");

           totalCost=totalCost+individualSum;


        }


        Assert.assertEquals(totalCost,135);


        if (totalCost==135){


            System.out.println("correct sum");
        }




    }
}





