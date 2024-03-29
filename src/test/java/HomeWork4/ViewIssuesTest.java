package HomeWork4;

import HomeWork4.enums.MenuItem;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class ViewIssuesTest {
    private WebDriver driver;

    private LoginPage loginPage;
    private MyViewPage myViewPage;
    private ViewIssuePage viewIssuePage;

    private Properties properties;

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws IOException {
        ChromeDriverManager.chromedriver().setup();
        FileInputStream propertiesFile = new FileInputStream("src/test/resources/HomeWork4.properties");
        properties = new Properties();
        properties.load(propertiesFile);
    }

    @BeforeMethod(alwaysRun = true)
    public void initDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(properties.getProperty("mantis.url"));
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginTest() {
        assertEquals(properties.getProperty("mantis.main_title"), loginPage.getPageTitle());

        loginPage.login(properties.getProperty("mantis.admin_username"), properties.getProperty("mantis.admin_password"));
    }

    @Test
    public void filterIssuesTest() {

        loginPage.login(properties.getProperty("mantis.admin_username"), properties.getProperty("mantis.admin_password"));
        myViewPage = new MyViewPage(this.driver);
        assertEquals(properties.getProperty("mantis.view_title"), myViewPage.getTitle());
        assertNotNull(myViewPage.getLeftSideBar());
        myViewPage.selectMenu(MenuItem.VIEW_ISSUES);

        viewIssuePage = new ViewIssuePage(this.driver);
        viewIssuePage.filterIssues(properties);
        assertNotNull(viewIssuePage.getIssueRecord());
    }

    @AfterMethod(alwaysRun = true)
    public void dropDown() {
        loginPage.logout();
        driver.close();
    }

}
