package Project.stepdefs;

import Constants.Element_Constants;
import Project.Base;
import Project.pageobjects.Price_Obj;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PriceSearch_Stepdefs extends Base {

    Price_Obj get = PageFactory.initElements(driver, Price_Obj.class);

    @Given("^user enters the search as \"([^\"]*)\"$")
    public void userEntersTheSearchAs(String place) throws InterruptedException {
        get.search(place);
    }


    @Given("^user selects max price$")
    public void userSelectsMaxPrice() throws InterruptedException {
        get.maxprice();
        Thread.sleep(500);
    }


    @When("^user clicks on advanced search options$")
    public void userClicksOnAdvancedSearchOptions() throws InterruptedException {
        get.advSearch();

    }


    @Then("^user chooses only the new homes and clicks on search to see the list of houses$")
    public void userChoosesOnlyTheNewHomesAndClicksOnSearchToSeeTheListOfHouses() throws InterruptedException {
        get.chooseOptions();


    }



    @And("^gets the houses price list$")
    public void getsTheHousesPriceList() throws InterruptedException, IOException {

       takeFullScreenShot();
        get.listOfProperties();

    }



    @Then("^user should see the contact details of the agent$")
    public void userShouldSeeTheContactDetailsOfTheAgent() throws InterruptedException, IOException {
        get.contactDetails();


    }
}

