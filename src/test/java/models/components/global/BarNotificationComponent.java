package models.components.global;

import models.components.Component;
import models.components.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

@ComponentCssSelector(value = "#bar-notification")
public class BarNotificationComponent extends Component {
    private static final By contentSel = By.cssSelector("p[class='content']");
    private static final By closeBtnSel = By.cssSelector("span[class='close']");

    public BarNotificationComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public void clickOnCloseBtn(){
        WebElement closeBtnElem = findElement(closeBtnSel);
        wait.until(ExpectedConditions.invisibilityOf(this.component));
    }

    public void verifyItemAddedToCart(){
        String expectedMsg = "The product has been added to your shopping cart";
        new WebDriverWait(driver,Duration.ofSeconds(10L)).until(ExpectedConditions.visibilityOf(findElement(contentSel)));
        String actualMsg = findElement(contentSel).getText();

        Assert.assertEquals(actualMsg,expectedMsg,"[ERR] Message content is incorrect");
    }


}
