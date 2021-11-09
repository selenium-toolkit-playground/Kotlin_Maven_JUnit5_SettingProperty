package com.seleniumToolkit.selenium.setting

import com.seleniumToolkit.selenium.framework.interceptor.driver.WebDriverInterceptor
import io.appium.java_client.android.AndroidOptions
import io.appium.java_client.ios.IOSOptions
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.edge.EdgeOptions
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.ie.InternetExplorerOptions
import org.openqa.selenium.opera.OperaOptions
import org.openqa.selenium.safari.SafariOptions

class CustomWebDriverInterceptor : WebDriverInterceptor {
    override fun chromeInterceptor(chromeOptions: ChromeOptions, localExecution: Boolean): ChromeOptions {
        return chromeOptions
    }

    override fun firefoxInterceptor(firefoxOptions: FirefoxOptions, localExecution: Boolean): FirefoxOptions {
        return firefoxOptions
    }

    override fun internetExplorerInterceptor(internetExplorerOptions: InternetExplorerOptions, localExecution: Boolean): InternetExplorerOptions {
        return internetExplorerOptions
    }

    override fun edgeInterceptor(edgeOptions: EdgeOptions, localExecution: Boolean): EdgeOptions {
        return edgeOptions
    }

    override fun operaInterceptor(operaOptions: OperaOptions, localExecution: Boolean): OperaOptions {
        return operaOptions
    }

    override fun safariInterceptor(safariOptions: SafariOptions, localExecution: Boolean): SafariOptions {
        return safariOptions
    }

    override fun androidInterceptor(androidOptions: AndroidOptions, localExecution: Boolean): AndroidOptions {
        return androidOptions
    }

    override fun iosInterceptor(iOSOptions: IOSOptions, localExecution: Boolean): IOSOptions {
        return iOSOptions
    }
}