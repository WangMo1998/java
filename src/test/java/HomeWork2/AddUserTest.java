package HomeWork2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddUserTest {

    private static WebDriver webDriver;


    @Test
    public void addUserTest() {

        //navigate to mantisbt.org
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://mantisbt.org/bugs/login_page.php");

        //Check title
        assertEquals(webDriver.getTitle(), "MantisBT");

        //perform login

        webDriver.findElement(By.id("username")).sendKeys("administratorwm");
        webDriver.findElement(By.xpath("//input[@value='Login']")).click();

        webDriver.findElement(By.id("password")).sendKeys("root");
        webDriver.findElement(By.xpath("//input[@value='Login']")).click();

        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//span[@class='user-info']"))));

        //check login
        assertEquals(webDriver.findElement(
                By.xpath("//span[@class='user-info']")).getText(),
                "administratorwm");

        //check left side menu
        try {
            webDriver.findElement(By.cssSelector(".nav.nav-list"));
        } catch (NoSuchElementException e) {
            File file = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/screenshots/"
                        + new SimpleDateFormat("yyyy.MM.dd_HH:mm:ss").format(Calendar.getInstance().getTime())
                        + "_left_menu_error"));
                fail();
            } catch (IOException e1) {
                e1.printStackTrace();
                fail();
            }
        }

        webDriver.findElement(By.linkText("Manage")).click();

        //check Manage MantisBT opened
        assertEquals(webDriver.getTitle(), "Manage - MantisBT");

        //open Create New Project page
        webDriver.findElement(By.linkText("Manage Users")).click();
        webDriver.findElement(By.linkText("Create New Account")).click();

        //check fields on Create Project menu
        try {
            webDriver.findElement(By.id("user-username"));
            webDriver.findElement(By.id("user-realname"));
            webDriver.findElement(By.id("email-field"));
            webDriver.findElement(By.id("user-password"));
            webDriver.findElement(By.id("user-verify-password"));
            webDriver.findElement(By.id("user-access-level"));
            webDriver.findElement(By.id("user-enabled"));
            webDriver.findElement(By.id("user-protected"));
        } catch (NoSuchElementException e) {
            File file = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/screenshots/"
                        + new SimpleDateFormat("yyyy.MM.dd_HH:mm:ss").format(Calendar.getInstance().getTime())
                        + "_create_project_menu_error"));
                fail();
            } catch (IOException e1) {
                e1.printStackTrace();
                fail();
            }
        }

        webDriver.findElement(By.id("user-username"))
                .sendKeys("wang123");
        webDriver.findElement(By.id("user-realname"))
                .sendKeys("wang");
        webDriver.findElement(By.id("email-field"))
                .sendKeys("wm180901@gmail.com");
        webDriver.findElement(By.id("user-password"))
                .sendKeys("123456");
        webDriver.findElement(By.id("user-verify-password"))
                .sendKeys("123456");

        webDriver.findElement(By.xpath("//input[@value='Create User']")).click();

        //perform logout
        webDriver.findElement(By.className("user-info")).click();
        webDriver.findElement(By.xpath("//a[contains(., 'Logout')]")).click();

        //Check title
        assertEquals(webDriver.getTitle(), "MantisBT");

        //perform login

        webDriver.findElement(By.id("username")).sendKeys("wang123");
        webDriver.findElement(By.xpath("//input[@value='Login']")).click();

        webDriver.findElement(By.id("password")).sendKeys("123456");
        webDriver.findElement(By.xpath("//input[@value='Login']")).click();

        //check login
        assertEquals(webDriver.findElement(
                By.xpath("//span[@class='user-info']")).getText(),
                "wang123");

    }

    @AfterClass
    public void dropDownDriver() {
        webDriver.close();
    }
}