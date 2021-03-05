package Project.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.*;
import Project.Base;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Price_Obj extends Base {

    @FindBy(xpath = "//input[@id='search-input-location']")
    private WebElement search_ele;
    /*@FindBy(xpath= "ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content']//li[3]//a[1]")
    WebElement choose_ele;*/
    @FindBy(xpath = "//select[@id='forsale_price_max']")
    private WebElement maxprice_ele;
    @FindBy(xpath = "//span[contains(text(),'Advanced search options')]")
    private WebElement adv_search_link;
    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[2]/div[1]/fieldset[2]/div[1]")
    WebElement checkbox_ele;
    @FindBy(xpath = "//label[contains(text(),'New homes')]")
    WebElement Nhome_ele;
    @FindBy(xpath = "//label[contains(text(),'Retirement homes')]")
    WebElement homes_ele;
    @FindBy(xpath = "//label[contains(text(),'Shared ownership')]")
    WebElement shared_ele;
    @FindBy(xpath = "//label[contains(text(),'Auctions')]")
    WebElement auction_ele;
    @FindBy(id = "search-submit")
    WebElement search_btn_ele;
    @FindBy(xpath = "//div[@class='css-1e28vvi-PriceContainer e2uk8e8']")
    //  @FindBy(css = "div.css-1wn73pq-SearchResultsWrapper.es0c9wm13:nth-child(6) div.css-aoaxu8-InnerWrapper.es0c9wm12 main.css-1ndyouf-Main.eqgqnb30 div.css-8jz4jb-SearchResultsLayoutGroup.es0c9wm6 div.css-kdnpqc-ListingsContainer.earci3d2 div.earci3d1.css-tk5q7b-Wrapper-ListingCard-StyledListingCard.e2uk8e10 div.css-hbmpg0-StyledWrapper.e2uk8e27 div.css-wfndrn-StyledContent.e2uk8e18 div.css-qmlb99-CardHeader.e2uk8e9 > div.css-1e28vvi-PriceContainer.e2uk8e8")
    WebElement price_container_ele;
    @FindBy(xpath = "//div[@class ='css-zays2g-ImageContainer e2uk8e24']")
    WebElement img_ele;
    @FindBy(xpath = "css-9sl42s-AgentDetailsContainer e11937k12")
    WebElement agent_ele;


    public void search(String place) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(search_ele)).sendKeys("london");
        // search_ele.sendKeys("london");
        Thread.sleep(1000);
        search_ele.click();
       /* Actions actions = new Actions(driver);
        actions.moveToElement(choose_ele).click();*/
    }

    public void maxprice() throws InterruptedException {
        Select price = new Select(maxprice_ele);
        price.selectByIndex(9);
        maxprice_ele.click();


    }

    public void advSearch() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(adv_search_link)).click();
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");


    }

    public void chooseOptions() throws InterruptedException {

        homes_ele.click();
        shared_ele.click();
        auction_ele.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(search_btn_ele)).click();
        driver.manage().timeouts().pageLoadTimeout(200,TimeUnit.SECONDS);

    }


    public void listOfProperties() throws InterruptedException {
        // Wait wait = new FluentWait<WebDriver>(driver).ignoring(TimeoutException.class);

        List<WebElement> plist = driver.findElements(By.xpath("//div[@class='css-1e28vvi-PriceContainer e2uk8e8']"));
        for (WebElement list : plist) {
            System.out.println(list.getText());


        }
    }


    public void contactDetails() throws InterruptedException, IOException {

        scroll_to_WebE(img_ele);
        img_ele.click();
        takeFullScreenShot();




    }



}












