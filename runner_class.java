import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class runner_class {
    WebDriver driver;

 @Test
    void all_class() throws InterruptedException {
        TestNgHomeWork j= new TestNgHomeWork();
        j.OpenBrowser();
        j.select_item();
        j.Register_as_guest();
        j.payment();
        j.Close_Browser();
    }
}
