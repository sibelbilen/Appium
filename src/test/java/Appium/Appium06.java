package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class Appium06 {


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
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/Casper/IdeaProjects/APPIUM_MOBILTEST/src/Apps/Calculator.apk");
        capabilities.setCapability("appPackage", "com.android.chrome");
        capabilities.setCapability("appActivity", "org.chromium.chrome.browser.ChromeTabbedActivity");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.get("https://www.amazon.com");
        System.out.println(driver.getContext() + "<====app acildigindaki tur");
       // burda aplikasyonun hangi turleri oldugunu gorem icin getContextHandles() kullaniyoruz.
        Set<String> butunturler = driver.getContextHandles();
        for (String tur: butunturler) {
            System.out.println(tur);
            if (tur.contains("WEBVIEW_chrome")) {
                driver.context(tur);
            }
        }




        System.out.println(driver.getContext() + "<====degisimden sonraki tur");
        Thread.sleep(7000);

//        MobileElement homeScreenLogo = driver.findElementByAccessibilityId("Amazon");
//      assertTrue(homeScreenLogo.isDisplayed());
//        System.out.println("Ana sayfadayiz");
//MobileElement aramabuttonu=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.widget.Button");
//aramabuttonu.click();

        MobileElement sigin=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[1]");
        sigin.click();
MobileElement welcometext=driver.findElementByXPath("//android.widget.TextView[@text='Welcome']");
        Assert.assertEquals(welcometext.getText(),"Welcome");

        System.out.println("test bitt...");
        Thread.sleep(5000);
        //close session
        driver.closeApp();
    }


//        driver.get("https://www.amazon.com");
//
//        System.out.println(driver.getContext() + "<====app acildigindaki tur");
//        //burda aplikasyonun hangi turleri oldugunu gorem icin getContextHandles() kullaniyoruz.
////        Set<String> butunturler = driver.getContextHandles();
////        for (String tur: butunturler) {
////            System.out.println(tur);
////            if (tur.contains("WEBVIEW_chrome")) {
////                driver.context(tur);
////            }
////        }
//
//        System.out.println(driver.getContext() + "<====degisimden sonraki tur");
//        Thread.sleep(7000);

//        MobileElement homeScreenLogo = driver.findElementByAccessibilityId("Amazon");
//        Assert.assertTrue(homeScreenLogo.isDisplayed());
//        System.out.println("Ana sayfadayiz");
//
////        System.out.println(driver.getCurrentUrl() +"<========= url ");
//        Thread.sleep(3000);
//        MobileElement signInButton = driver.findElementByAccessibilityId("Sign in ›");
//        signInButton.click();
//        Thread.sleep(5000);
//        MobileElement welcomeText = driver.findElementByXPath("//android.widget.TextView[@text='Welcome']");
//
//        Assert.assertEquals(welcomeText.getText(), "Welcome");
//
//        System.out.println("test bitt...");
//        Thread.sleep(5000);
//        //close session
//        driver.closeApp();

    }




