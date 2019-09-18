package com.ritesh.appiumlearn;

import android.util.Log;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

import io.appium.java_client.android.AndroidDriver;

public class SetUp {

    private final String DEVICE_NAME = "MZ3PL6BDV000004494";
    private final String PLATFORM_NAME = "Android";
    private final String PLATFORM_VERSION = "8.1.0";
    private final String APP_PACKAGE = "appPackage";
    private final String APP_ACTIVITY = "appActivity";

    private final String APP_PACKAGE_ = "com.nivesh.production";
    private final String APP_ACTIVITY_ = "com.nivesh.production.activity.login";

    private String deviceName = "Micromax Q409A"; //device name can be found in device settings
    private String platformName = "Android";
    private String platformVersion = "8.1.0"; //version of your android
    private String port = "4723"; //port from Appium server
    private String url;

    private String getIp() throws UnknownHostException {
        InetAddress ip = InetAddress.getLocalHost();
        return ip.getHostAddress();
    }

    public AndroidDriver establishConnection() throws MalformedURLException {
        try {
            url = String.format("http://%s:%s/wd/hub", getIp(), port);
            Log.e("URL", "-> " + url);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability(DEVICE_NAME, deviceName);
        capability.setCapability(PLATFORM_NAME, platformName);
        capability.setCapability(PLATFORM_VERSION, platformVersion);

        capability.setCapability(APP_PACKAGE, APP_PACKAGE_);
        capability.setCapability(APP_ACTIVITY, APP_ACTIVITY_);

        return new AndroidDriver(new URL(url), capability);
    }


}
