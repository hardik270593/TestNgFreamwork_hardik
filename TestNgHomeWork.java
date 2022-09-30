import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.sql.Driver;

public class TestNgHomeWork {
    WebDriver driver;

    @Test//(priority = 1)
    void OpenBrowser(){
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\jdk1.8.0_333\\bin\\TestNgfremwork_homework\\src\\test\\resources\\BrowserDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test(priority = 2)
    void select_item() throws InterruptedException
    {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a")).click();
       // Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div[1]/div[2]/ul/li[1]/ul/li[1]/a")));
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div[1]/div[2]/ul/li[1]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/h2/a")).click();
       // Thread.sleep(2000);

    }
    @Test(priority = 3)
    void Add_to_cart()
    {
        driver.findElement(By.id("add-to-cart-button-3")).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div/p/a")));
        driver.findElement(By.xpath("/html/body/div[5]/div/p/a")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[1]/table/tbody/tr/td[5]/input")).clear();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[1]/table/tbody/tr/td[5]/input")).sendKeys("3");
        driver.findElement(By.id("updatecart")).click();

    }
    @Test(priority = 4)
    void CheckOut()
    {
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button[1]")).click();


    }
    @Test(priority = 5)
    void Register_as_guest()
    {
       driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("hardik");
       driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("patel");
       driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("harjsahd@gmail.com");
       driver.findElement(By.id("BillingNewAddress_Company")).sendKeys("spyder solution");

       WebElement contry = driver.findElement(By.id("BillingNewAddress_CountryId"));
       Select select2 = new Select(contry);
       select2.selectByValue("133");

       driver.findElement(By.id("BillingNewAddress_City")).sendKeys("british");
       driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("79 gsadashjkas,sdas");
       driver.findElement(By.id("BillingNewAddress_Address2")).sendKeys("bristol");
       driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("Bs58jy");
       driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("0732842342");
       driver.findElement(By.id("BillingNewAddress_FaxNumber")).sendKeys("0732842342");
       driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[1]/div[2]/div/button[4]")).click();
    }
    @Test(priority = 6)
    void payment()
    {
       WebDriverWait wait = new WebDriverWait(driver,20);
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[3]/div[2]/form/div[2]/button")));
       driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[3]/div[2]/form/div[2]/button")).click();

       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[4]/div[2]/div/button")));
       driver.findElement(By.id("paymentmethod_1")).click();
       driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[4]/div[2]/div/button")).click();

       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[5]/div[2]/form/div/div/div/div/table/tbody/tr[1]/td[2]/select")));
       WebElement pay = driver.findElement(By.name("CreditCardType"));
       Select debit_card =new Select(pay);
       debit_card.selectByVisibleText("Visa");
       driver.findElement(By.id("CardholderName")).sendKeys("harry patel");
       driver.findElement(By.id("CardNumber")).sendKeys("238749823747237");
       WebElement date_month =driver.findElement(By.name("ExpireMonth"));
       Select month =new Select(date_month);
       month.selectByVisibleText("03");
       WebElement month_year =driver.findElement(By.name("ExpireYear"));
       Select year =new Select(month_year);
       year.selectByVisibleText("2024");
       driver.findElement(By.name("CardCode")).sendKeys("232");
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[5]/div[2]/div/button")));
       driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[5]/div[2]/div/button")).click();
    }

    @Test//(priority = 7)
    void Close_Browser(){
        driver.close();
    }
}
