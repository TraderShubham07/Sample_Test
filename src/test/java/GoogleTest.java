import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

    @Test
    public void verifyGoogleLogo() {
        driver.get("https://www.google.com");

        // Locate Google logo by XPath
        WebElement logo = driver.findElement(By.xpath("//img[@alt='Google']"));

        // Verify that the logo is displayed
        Assert.assertTrue(logo.isDisplayed(), "Google logo is not displayed!");
    }
}
