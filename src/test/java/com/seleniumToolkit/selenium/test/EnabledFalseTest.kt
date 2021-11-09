package com.seleniumToolkit.selenium.test

import com.seleniumToolkit.selenium.framework.assertBase.ReportAssert
import com.seleniumToolkit.selenium.framework.driver.WebDriverManager
import com.seleniumToolkit.selenium.framework.tag.SeleniumTest
import com.seleniumToolkit.selenium.pageObject.template.AbstractSeleniumToolkitPageObject
import io.qameta.allure.Feature
import org.junit.jupiter.api.Disabled

class EnabledFalseTest {
    @Disabled
    @SeleniumTest
    @Feature("Enabled False")
    fun webseiteVerfügbar() {
        AbstractSeleniumToolkitPageObject.Companion.loadSeleniumToolkitPage()
        ReportAssert.assertEquals(WebDriverManager.getWebdriver().title, "Selenium-Toolkit")
    }
}