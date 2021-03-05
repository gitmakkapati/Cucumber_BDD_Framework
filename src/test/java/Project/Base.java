package Project;

import Constants.Element_Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;
    public static Properties prop;

    //method to initialize the browser from the property file

    public void initialization() throws InterruptedException, FileNotFoundException {
        String path = System.getProperty("user.dir") + "/src/test/java/Project/propertyfiles/environment_qa.properties";
        prop = new Properties();
        /** Stream to read the spreadsheet. */
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(fis);

        } catch (IOException e) {
            e.printStackTrace();
        }
        String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();

        String url = prop.getProperty("url");
        driver.get(url);
        //driver.manage().timeouts().pageLoadTimeout(Element_Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//body/div[@id='ui-cookie-consent-overlay-wrap']/div[2]/form[1]/div[1]/div[1]/div[1]/button[2]")).click();

    }


    public static boolean scroll_to_WebE(WebElement webe) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webe);
            return true;
        } catch (Exception e) {
             e.printStackTrace();
            return false;
        }
    }


    public String getReportConfigPath(){
        String reportConfigPath = prop.getProperty("reportConfigPath");
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }

    public void takeFullScreenShot() throws IOException {

        Date d = new Date();

        String filename = d.toString().replace("", "_").replace(":", "_") + ".png";
        String screenshotPath = SystemUtils.getUserDir() + " /target/screenshot/" + filename;

        //take screenshot image
        Screenshot screenshot =
                new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);

        //write to location

        ImageIO.write(screenshot.getImage(), "PNG", new File(screenshotPath));


    }

    public void closeBrowser(){
        driver.quit();


    }


}


