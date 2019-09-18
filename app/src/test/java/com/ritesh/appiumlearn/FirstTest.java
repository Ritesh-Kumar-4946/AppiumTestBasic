package com.ritesh.appiumlearn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

public class FirstTest {
    AndroidDriver androidDriver;
    WebDriver driver;
    WebDriverWait wait;
    String AppURL = "http://www.seleniumeasy.com";

    @BeforeTest
    private void setup() throws MalformedURLException {
//        driver = setUp.establishConnection();
//        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        // printLog("TestCase capabilities");
        // Create an object for Desired Capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Name of mobile web browser to automate. ‘Safari’ for iOS and ‘Chrome’
        // or ‘Browser’ for Android
//        capabilities.setCapability("browserName", "Chrome");

        // The kind of mobile device or emulator to use - iPad Simulator, iPhone
        // Retina 4-inch, Android Emulator, Galaxy S4 etc
        capabilities.setCapability("deviceName", "MZ3PL6BDV000004494");

        // Which mobile OS platform to use - iOS, Android, or FirefoxOS
        capabilities.setCapability("platformName", "Android");

        // Java package of the Android app you want to run- Ex:
        // com.example.android.myApp
        capabilities.setCapability("appPackage", "com.nivesh.production");

        // Activity name for the Android activity you want to launch from your
        // package
        capabilities.setCapability("appActivity", "com.nivesh.production.activity.splash.SplashActivity");

        // Initialize the driver object with the URL to Appium Server and
        // passing the capabilities
//        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//        driver = new RemoteWebDriver(new URL("http://192.168.10.221:4723/wd/hub"), capabilities);
//        androidDriver = new AndroidDriver(new URL("http://192.168.10.221:4723/wd/hub"), capabilities);
        androidDriver = new AndroidDriver(new URL("http://172.16.2.67:4723/wd/hub"), capabilities);

//        wait = new WebDriverWait(driver, 5);
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        androidDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void MyTest() throws MalformedURLException {
        printLog("TestCase Running");
        try {
            printLog("Wait 5 sec");
////            https://sqa.stackexchange.com/questions/24207/appium-same-code-is-working-sometimes-and-failing-sometimes
//            WebDriverWait wait = new WebDriverWait(androidDriver, 30);
//            wait.until(ExpectedConditions.elementToBeClickable(By.id("digit_1")));


            Thread.sleep(5000);
            androidDriver.navigate().back();
            androidDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            printLog("emailid Enter");
            androidDriver.findElement(By.id("com.nivesh.production:id/edt_login_email")).sendKeys("riteshkumar.4946@gmail.com");

            printLog("Wait 5 sec");
            androidDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            printLog("password Enter");
            androidDriver.findElement(By.id("com.nivesh.production:id/edt_login_password")).sendKeys("123456789");

            printLog("Wait 5 sec");
            androidDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            printLog("Click Toggle button");
            androidDriver.findElement(By.id("com.nivesh.production:id/iv_password_toggle")).click();

            printLog("Wait 5 sec");
            androidDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


            printLog("Click Login Button");
            androidDriver.findElement(By.id("com.nivesh.production:id/btn_login")).click();
            printLog("Click Perform");

//            printLog("Wait 5 sec");
//            androidDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//            printLog("Click Navigation");
//            androidDriver.findElementByName("Open navigation drawer").click();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @AfterTest
    public void End() {
//        driver.quit();
    }


    private void printLog(String strLog) {
        System.out.println(strLog);
    }
}
