package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CalculatorTest {

    @Test
    public void calculatorAddTest() throws MalformedURLException{

       //desired capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Pixel 3");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "https://cybertek-appium.s3.amazonaws.com/calculator.apk");
        URL url = new URL("http://localhost:4723/");
        //set URL FOR THE appium server




        //launch appiumDriver

        AppiumDriver<MobileElement> driver= new AndroidDriver<MobileElement>(url,capabilities);
      //  System.out.println("driver.getTitle() = " + driver.getTitle());

       assertEquals("android", driver.getPlatformName());

       MobileElement clearElem= driver.findElement(MobileBy.AccessibilityId("clear"));
        System.out.println("clearElem = " + clearElem);
        assertTrue(clearElem.isDisplayed());


        driver.closeApp();


    }
}
