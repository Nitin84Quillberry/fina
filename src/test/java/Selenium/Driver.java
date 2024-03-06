package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static Selenium.util.method;

public class Driver {
    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\NITIN KOHLI\\Downloads\\chrome\\geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();
//
//        driver.get("https://www.facebook.com/");
//        driver.manage().window().maximize();
////       driver.findElement(By.className("inputtext login_form_input_box")).click();
////       driver.findElement(By.xpath("//td//input[@id=pass]")).sendKeys("122333");
//        driver.findElement(By.xpath("//input[@type='email'][@class='inputtext login_form_input_box']")).sendKeys("1223");
//        driver.findElement(By.cssSelector("input[id='pass']")).sendKeys("1111");
//

       String bb=util.method();

        System.out.println(bb);


//            driver.navigate().to("https://www.google.com/");
//
//        try {
//            Thread.sleep(3000);
//        }
//        catch (InterruptedException e){
//            System.out.println("waiting 3 secondds");
//        }
//        driver.navigate().back();
//        driver.navigate().forward();


//        Select dropdown=new Select(driver.findElement(By.xpath("//div[@class='_5k_5']//span//span//select[@id='month']")));
//        dropdown.selectByVisibleText("Jan");
//
//        if (dropdown.isMultiple()){
//            System.out.println("can be multiple select ");
//        }
//        else System.out.println("no it can not be multiple select ");
//
//
//
//         List<WebElement> alloptions = dropdown.getOptions();
//         for (int i=0;i<alloptions.size();i++){
//             System.out.println(alloptions.get(i).getText());

//         }

//      driver.findElement(By.partialLinkText("Create a")).click();
//         Thread.sleep(3000);

//            String url=driver.getCurrentUrl();
//        System.out.println(url);
//        try {
//            Thread.sleep(3000);
//        }
//        catch (InterruptedException e){
//            System.out.println("waiting 3 secondds");
//        }
////            String pagesource=driver.getPageSource();
////        System.out.println(pagesource);
//
//        String currentTitle=driver.getTitle();
//        System.out.println(currentTitle);
//
//        String textOfBox=driver.findElement(By.xpath("//input[@name='reg_email__']")).getText();
//        System.out.println(textOfBox);

//        Select dateDropdown = new Select(driver.findElement(By.xpath("//span//select[@id='day']")));
//
//        List<WebElement> DateList = dateDropdown.getOptions();
//        for (int i = 0; i < DateList.size(); i++) {
//            System.out.println(DateList.get(i).getText());
//
//        }
//
//        dateDropdown.selectByIndex(20);
//
//
//        if (DateList.size() > 32) {
//            System.out.println("Dates are incorrect");
//        } else {
//            System.out.println("dates are correct");
//        }
//
//
////            WebElement radio=driver.findElement(By.xpath("//span//input[@id='u_0_7'][@class='_8esa']"));
////            radio.click();
////            if (radio.isSelected()){
////                System.out.println("you have selected male");
////            }
////            else {System.out.println("you have not selected male");}
////        driver.close();
//
//
//        List<WebElement> genders = driver.findElements(By.xpath("//a"));
//        System.out.println("total number of dropdowns :" + " " + genders.size());
//        List<String> tagnamesList = new ArrayList<String>();
//        for (int i = 0; i < genders.size(); i++) {
//
////            System.out.println(genders.get(i).getText());
//            String gettext = genders.get(i).getText();
//            tagnamesList.add(gettext);
//
//        }
//        System.out.println("tag are " + tagnamesList);
//
//
//        tagnamesList.clear();
//
//        System.out.println("now list is " + tagnamesList);
//
////            genders.get(1).click();
//
//        Thread.sleep(3000);
//
//        driver.quit();
    }

}


