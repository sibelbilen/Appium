package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium03 {


    @Test
    public void test01() throws MalformedURLException, InterruptedException {

        //ilk olarak cihazi tanimlanacak.

        DesiredCapabilities     capabilities=new DesiredCapabilities();

 //capabilitiesleri set etmemiz lazim.
//     capabilities.setCapability("platformName","Android");
//     capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Adroid");//seleiumdan geliyor hazir method
 //    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Adroid");//appiumdan geliyor

     //yukarda yazdiklarim 3 u ayni islemi goruyor.hangisiyle yazarsaniz

        //versiyonu yazacagiz.
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.1.0");

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"RealDevice");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/Casper/IdeaProjects/APPIUM_MOBILTEST/src/Apps/gestureTool.apk");
       capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
      capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");


        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        if (driver.isDeviceLocked()) {
            driver.unlockDevice();
        }

        System.out.println("app yuklendi");

        Thread.sleep(5000);
        MobileElement homeScreenTitle = driver.findElementById("android:id/title");
        Assert.assertTrue(homeScreenTitle.isDisplayed());
        System.out.println("Ana sayfa acildi");

        MobileElement testButton = driver.findElementById("com.davemac327.gesture.tool:id/testButton");
        testButton.click();
        System.out.println("Test button calisiyor :)");


        MobileElement testAGestureTitle = driver.findElementById("android:id/title");
        Assert.assertTrue(testAGestureTitle.isDisplayed());
        System.out.println("test screen acildi...");



driver.closeApp();

    }
}
