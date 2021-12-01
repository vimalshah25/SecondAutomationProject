package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MultiTest {
   static WebDriver driver;



   public static void clickOnElement(By by) {
      driver.findElement(by).click();
   }

   public static void typeText(By by, String text) {
      driver.findElement(by).sendKeys(text);
   }

   public static String getTextFromElement(By by) {
      return driver.findElement(by).getText();
   }

   public static String currentTimeSTamp() {
      Date date = new Date();
      SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyhhmmss");
      return sdf.format(date);
   }

   public static void waitForClicable(By by, int timeInSeconds) {
      WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
      wait.until(ExpectedConditions.elementToBeClickable(by));
   }

   public static void waitForVisible(By by, int timeInSeconds) {
      WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
   }
@BeforeMethod
public void OpenBrowser(){
   System.setProperty("webdriver.chrome.driver","src/test/drivers/chromedriver.exe");


   driver = new ChromeDriver();
   driver.manage().window().fullscreen();
   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   //type the url
   driver.get("https://demo.nopcommerce.com/");

}
   @Test

   public void verifyUserShouldBeAbleToRegisterSuccessfully() {



      // click on register button
      clickOnElement(By.xpath("//a[@class=\"ico-register\"]"));

      // verify user is on register page
     // Assert.assertTrue(driver.getCurrentUrl().contains(("register")));
      typeText(By.name("FirstName"), "Vimal");

      typeText(By.name("LastName"), "Shah");
      //select day from dropdown
      Select selectDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
      selectDay.selectByVisibleText("18");


      //select month from dropdown
      Select selectMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
      selectMonth.selectByValue("4");
      Select selectYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
      selectYear.selectByValue("1999");
      typeText(By.id("Email"),"vimalshah007+"+currentTimeSTamp()+"@gmail.com");



      typeText(By.id("Password"), "12345678");
      typeText(By.id("ConfirmPassword"), "12345678");


      clickOnElement(By.name("register-button"));

      String actualRegisterSuccessMessage = getTextFromElement(By.xpath("//div[@class='result']"));
      String expectedRegisterSuccessMessage = "Your registration completed";
     // Assert.assertEquals(actualRegisterSuccessMessage, "expectedRegisterSuccessMessage");
      Assert.assertTrue(actualRegisterSuccessMessage.equals(expectedRegisterSuccessMessage),"Your registration completed");


   }
   @Test
   public void UserIsAbleToNavigateToDesktopPage(){
      // click on computer
      clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li/a[@href=\"/computers\"]"));
      clickOnElement(By.xpath("//h2/a[@href='/desktops']"));



   }

   @Test
   public void NewsComments(){
      // click on news comments
      clickOnElement(By.xpath("//div[@class='news-list-homepage']/div[2]/div[2]/div[3]/a"));
      typeText(By.id("AddNewComment_CommentTitle"),"Very Nice Product");
      typeText(By.id("AddNewComment_CommentText"),"5 star Product");
      clickOnElement(By.xpath("//div[@class='page-body']/div[3]/form/div[2]/button[1]"));
      String actualNewscomments = getTextFromElement(By.xpath("//div[@class=\"result\"]"));
      String expectedNewscomments = "News comment is successfully added.";
      Assert.assertTrue(actualNewscomments.equals(expectedNewscomments),"News comment is successfully added.");
   }
   @Test
   public void VerifyRegisterUserShouldBeAbleToReferAProductToAFriend(){
      // click on registration button
      clickOnElement(By.xpath("//div[@class='header-links']/ul/li[1]/a"));
      typeText(By.name("FirstName"), "Vimal");

      typeText(By.name("LastName"), "Shah");
      //select day from dropdown
      Select selectDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
      selectDay.selectByVisibleText("18");


      //select month from dropdown
      Select selectMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
      selectMonth.selectByValue("4");
      Select selectYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
      selectYear.selectByValue("1999");
      typeText(By.id("Email"),"vimalshah007+"+currentTimeSTamp()+"@gmail.com");



      typeText(By.id("Password"), "12345678");
      typeText(By.id("ConfirmPassword"), "12345678");


      clickOnElement(By.name("register-button"));

      String actualRegisterSuccessMessage = getTextFromElement(By.xpath("//div[@class='result']"));
      String expectedRegisterSuccessMessage = "Your registration completed";
      // click on computer
      clickOnElement(By.xpath("//div[@class='header-menu']/ul[1]/li[1]/a"));
      // click on Desktop
      clickOnElement(By.xpath("//div[@class='page-body']/div[1]/div/div[1]/div/h2/a"));



      //click on build on your own computer picture
      clickOnElement(By.xpath("//div/a/img[@alt='Picture of Build your own computer']"));

      // click on Email a friend button
      clickOnElement(By.xpath("//button[@class=\"button-2 email-a-friend-button\"]"));

      // Enter Friends Email




   }





}
