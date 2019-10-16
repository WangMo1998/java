package HomeWork3;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class mantisTests {

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
    public void loginTest() {

        assertEquals(pageObjectVoid.getPageTitle(), "MantisBT");

        pageObjectVoid.login("administratorwm", "root");

        assertEquals(pageObjectVoid.getUserName(), "administratorwm");
        assertEquals(pageObjectVoid.getPageTitle(), "My View - MantisBT");
    }

    @Test
    public void leftBarTest() {

        pageObjectVoid.login("administratorwm", "root");

        //check left side menu
        pageObjectVoid.checkLeftBar();

        pageObjectVoid.createNewProject();

        //perform logout
        pageObjectVoid.logout();
    }

    @AfterMethod(alwaysRun = true)
    public void dropDownDriver() {
        webDriver.close();
    }
}
