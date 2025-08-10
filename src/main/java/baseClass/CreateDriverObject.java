package baseClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateDriverObject {

    static WebDriver driver;

    public static void main(String[] args) throws IOException {
        WebDriver myDriver = getDriver("chrome");  // "edge" ya "firefox" bhi de sakte ho
        myDriver.get("https://www.google.com");
    }

    public static WebDriver getDriver(String browserType) throws IOException {
        try {
            if (browserType.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } 
            else if (browserType.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            } 
            else if (browserType.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } 
            else {
                System.out.println("Please enter only Chrome, Edge, or Firefox for browser type.");
            }

            if (driver != null) {
                driver.manage().window().maximize();
            }
        } 
        catch (Exception e) {
           
        }
        return driver;
    }
}
