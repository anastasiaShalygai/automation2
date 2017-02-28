package shortTask;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by Anastasiya on 27.02.2017.
 */
public class ShortTest {
    private WebDriver driverFireFox;
    private String url;

    @Before
    public void setUp() {
        driverFireFox = new FirefoxDriver();
    }

    @Test
    public void shortTest1() {
        url = "https://www.google.com/";
        String pageTitle;
        String currentUrl;
        int titleLength;
        int pageSourceLength;

        driverFireFox.get(url);
        pageTitle = driverFireFox.getTitle();
        titleLength = driverFireFox.getTitle().length();
        System.out.println("pageTitle = " + pageTitle);
        System.out.println("titleLength = " + titleLength);

        currentUrl = driverFireFox.getCurrentUrl();
        Assert.assertEquals(currentUrl, url);
        driverFireFox.getPageSource();
        pageSourceLength = driverFireFox.getPageSource().length();
        System.out.print("page sourse length = " + pageSourceLength);
    }

    @Test
    public void shortTest2() {
        url = "https://www.google.com.ua/search?q=w3";
        driverFireFox.navigate().to(url);
        driverFireFox.findElement(By.xpath(".//div/div/div[1]/div/h3/a")).click();
        driverFireFox.navigate().back();
        driverFireFox.navigate().forward();
        driverFireFox.navigate().refresh();
    }

    @Test
    public void shortTest3() {
        url = "http://toolsqa.wpengine.com/automation-practice-form/";
        driverFireFox.get(url);
        WebElement elementName = driverFireFox.findElement(By.name("firstname"));
        WebElement elementLastName = driverFireFox.findElement(By.name("lastname"));
        elementName.sendKeys("Name");
        elementLastName.sendKeys("Last name");
        WebElement elementButton = driverFireFox.findElement(By.id("submit"));
        elementButton.click();
    }

    @Test
    public void shortTest4() {
        url = "http://toolsqa.wpengine.com/automation-practice-form/";
        driverFireFox.get(url);
        WebElement elementLink = driverFireFox.findElement(By.partialLinkText("Partial"));
        elementLink.click();

        WebElement elementButton = driverFireFox.findElement(By.tagName("button"));
        System.out.println(elementButton.toString());
        System.out.println(elementButton.getText());

        WebElement elementLinkTest = driverFireFox.findElement(By.linkText("Link Test"));
        elementLinkTest.click();
    }

    @Test
    public void shortTest5() {
        url = "http://toolsqa.wpengine.com/automation-practice-form/";
        driverFireFox.get(url);

        WebElement radioButtonFemale = driverFireFox.findElement(By.id("sex-1"));
        radioButtonFemale.click();

        List<WebElement> yearsOfExp = driverFireFox.findElements(By.name("exp"));
        for (WebElement element : yearsOfExp) {
            String third = "3";
            String sValue = element.getAttribute("value");
            if (sValue.equalsIgnoreCase(third)) {
                element.click();
            }
        }
        WebElement checkBoxAutomation = driverFireFox.findElement(By.id("profession-1"));
        System.out.println("checkBoxAutomation = " + checkBoxAutomation.isSelected());
        WebElement checkBoxSelenium = driverFireFox.findElement(By.cssSelector("#tool-1"));
        checkBoxSelenium.click();
    }

    @Test
    public void shortTest6() {
        driverFireFox.get("http://toolsqa.wpengine.com/automation-practice-form/");
        WebElement dropDownContinents = driverFireFox.findElement(By.id("continents"));
        Select select = new Select(dropDownContinents);
        select.selectByIndex(1);
        select.selectByVisibleText("Africa");
        for (WebElement str : select.getOptions()) {
            System.out.println(str.getText());
        }
        select.selectByIndex(3);
    }

    @After
    public void tearDown() {
        driverFireFox.close();
    }


}
