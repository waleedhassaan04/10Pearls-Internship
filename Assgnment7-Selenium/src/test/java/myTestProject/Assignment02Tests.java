package myTestProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment02Tests {
    private WebDriver driver;
    ItemPage itemPage;

    @BeforeClass
    public void setUp() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Banee\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        itemPage = new ItemPage(driver);


    }

    @Test(description = "Test to verify that the item is being searched",priority = 1)
    public void SearchForItems() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        basePage.LoadPage();
        String searchheader = basePage.SearchItem();
        Thread.sleep(2000);
        Assert.assertEquals(searchheader, "\"Electronics\"");

    }
    @Test(description = "Test to verify that the filters are applied",priority = 2)
    public void ApplyFilters() throws InterruptedException {

        itemPage.BrandFilter();
        itemPage.PriceFilter();
        Thread.sleep(3000);
        Assert.assertEquals(itemPage.getUrl(), "https://www.daraz.pk/blueidea/?from=sideFilters&q=Electronics&price=500-5000");
    }
    @Test(description = "Test to verify that the results are greater than zero ",priority = 3)
    public void CountResults() throws InterruptedException {

        Thread.sleep(3000);
        int count = itemPage.count();
        Assert.assertNotEquals(count, 0);
    }
    @Test(description = "Test to verify that the shipping price is free", priority = 4)
    public void ShippingPrice() throws InterruptedException {

        Thread.sleep(3000);
        itemPage.SelectItem();
        String shipping = itemPage.ShippingPrice();
        System.out.println("Shipping Price: " + shipping);
        Assert.assertEquals(shipping, "Free","Shipping is not Free");
    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}
