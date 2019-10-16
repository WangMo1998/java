package HomeWork3;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class AddUserTest {

    private static WebDriver webDriver;
    private PageObjectVoid pageObjectVoid;

    @BeforeSuite(alwaysRun = true)
    public void setUpDriver() {
        ChromeDriverManager.chromedriver().setup();
    }

    @BeforeMethod(alwaysRun = true)
    public void initDriver() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        webDriver.get("https://mantisbt.org/bugs/login_page.php");
        pageObjectVoid = new PageObjectVoid(webDriver);
    }

    @Test
    public void addUserTest() {

        //Check title
        assertEquals(pageObjectVoid.getPageTitle(), "MantisBT");

        //perform login
        pageObjectVoid.login("administratorwm", "root");

        //check login
        assertEquals(pageObjectVoid.getUserName(), "administratorwm");

        pageObjectVoid.checkLeftBar();

        pageObjectVoid.createNewUser("wang123", "wang", "wm180901@gmail.com", "123456");

        //perform logout
        pageObjectVoid.logout();

        //Check title
        assertEquals(pageObjectVoid.getPageTitle(), "MantisBT");

        //perform login
        pageObjectVoid.login("wang123", "123456");

        //check login
        assertEquals(pageObjectVoid.getUserName(), "wang123");

    }

    @AfterClass
    public void dropDownDriver() {
        webDriver.close();
    }
}