package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium09Selector_test_Case {


    @Test
    public void test01() throws MalformedURLException, InterruptedException {

        //ilk olarak cihazi tanimlanacak.

        DesiredCapabilities capabilities = new DesiredCapabilities();

        //capabilitiesleri set etmemiz lazim.
//     capabilities.setCapability("platformName","Android");
//     capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Adroid");//seleiumdan geliyor hazir method
        //    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Adroid");//appiumdan geliyor

        //yukarda yazdiklarim 3 u ayni islemi goruyor.hangisiyle yazarsaniz

        //versiyonu yazacagiz.
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/Casper/IdeaProjects/APPIUM_MOBILTEST/src/Apps/gestureTool.apk");
        capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");


        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").textStartsWith(\"Add\")").click();

        Thread.sleep(5000);

        System.out.println(driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/done\").enabled(false)").getAttribute("enabled"));


        //session kapat

//        driver.closeApp();
    }

}

