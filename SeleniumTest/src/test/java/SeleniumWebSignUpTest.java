import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignUpTest {

    //import selenium WebDriver
    private WebDriver driver;

    @Test
    public void setUp() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        //1. Open your chrome browser
        driver = new ChromeDriver();

        //2. Input your Selenium Demo Page URL (https://selenium-blog.herokuapp.com/)
        driver.get("https://selenium-blog.herokuapp.com/");

        // Test1. Verify the user input the right url and his on the right webpage
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);

        //3. Maximize the browser

        driver.manage().window().maximize();

        //4. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);

        //5. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("ominda97");

        //6.Locate the email address field and Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("omin@qa.teamy");

        //7. Locate the password field and Input your password on the username field
        driver.findElement(By.id("user_password")).sendKeys("blessedness678");

        //8. Click on the SignUp Button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);

        //9. Click on User1 item on the listpage
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();

        //10. Search for an item (Using Learn XPath) and confirm it is present
        //driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();

        //11. Click on Logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();


    }
        @AfterTest
        public void closeBrowser(){
            //Quit the browser
            driver.quit();
        }



}
