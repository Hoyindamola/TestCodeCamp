import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JumiaOrderFlow {

    //import selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void setupPage() throws InterruptedException {

        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");

        //1.Open Chrome Browser
        driver = new ChromeDriver();

        //2. Open my Jumia Web URL (https://www.jumia.com.ng/)
        driver.get("https://www.jumia.com.ng/");

        // Test1. Verify the URL is correct and it takes user to the right webpage
        if (driver.getCurrentUrl().contains("https://www.jumia.com.ng/"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Invalid Webpage");
        Thread.sleep(5000);

        //3. Maximize the browser window

        driver.manage().window().maximize();

        //4. Get the page Title
        System.out.println(driver.getTitle());

        //5. Locate and click on the Account button to locate the Login button
        driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();
        //6. Click on the SIGN IN button to open the Login page
        driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();


        //Test2. Verify that clicking on the SIGN IN button takes user to the Login Page
        String expectedURL = "https://www.jumia.com.ng/customer/account/login/?return=%2F";
        String actualURL = driver.getCurrentUrl();

        if (actualURL.contains(expectedURL))
            System.out.println("Correct Login Page");
        else
            System.out.println("Invalid Login Page");
        Thread.sleep(5000);

    }
    @Test
    public void loginTest() throws InterruptedException {
        //Input email address on the email field
        driver.findElement(By.id("fi-email")).sendKeys("oyindamolaadedoyin2@gmail.com");
        //Input your password on the username field
        driver.findElement(By.id("fi-password")).sendKeys("pretty24");
        // Click on the LOGIN Button
        driver.findElement(By.xpath("//*[@id=\"authForm\"]/button/span")).click();
        Thread.sleep(5000);



    //@Test (priority = 1)
    //public void logout() throws InterruptedException {
        //Locate and click on User Profile name button to locate the Logout button
        driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();
        //Locate and Click on the LOGOUT button to log out of Jumia web App
        //driver.findElement(By.xpath("/html/body/div[1]/header/section/div[2]/div[1]/div/div/form/button")).click();
        Thread.sleep(5000);
    }

    @AfterTest
    public void quitBrowser(){
        //Quit the browser
        driver.quit();
    }
}
