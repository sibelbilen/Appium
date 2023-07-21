package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class Appium05 {


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
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/Casper/IdeaProjects/APPIUM_MOBILTEST/src/Apps/Calculator.apk");
//       capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
//      capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");


        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


MobileElement sekiz=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.slidingpanelayout.widget.SlidingPaneLayout/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.Button[2]");



        MobileElement eksi = driver.findElementById("com.google.android.calculator:id/op_sub");
        MobileElement esittir=driver.findElementByXPath("//android.widget.Button[@content-desc=\"eşittir\"]");

        sekiz.click();
        sekiz.click();
        eksi.click();
        sekiz.click();
        sekiz.click();
        esittir.click();
        MobileElement preResult = driver.findElementById("com.google.android.calculator:id/result_preview");
        System.out.println("Pre result "+ preResult.getText());
        String preResultText = preResult.getText();



        Thread.sleep(5000);
        MobileElement result = driver.findElementById("com.google.android.calculator:id/result_final");
        System.out.println("final result " + result.getText());

        assertEquals(result.getText(),preResultText);




    }
}
