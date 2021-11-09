package com.seleniumToolkit.selenium.pageObject.template

import com.google.common.base.Strings
import com.seleniumToolkit.selenium.framework.dataLoader.TestDataProvider
import com.seleniumToolkit.selenium.framework.driver.WebDriverManager
import com.seleniumToolkit.selenium.pageObject.Home
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.WebDriverWait
import java.util.concurrent.TimeUnit

abstract class AbstractSeleniumToolkitPageObject : AbstractPageObject() {
    var topMenuPageObject = TopMenuPageObject()
    private val titleBy = By.xpath("//*[@data-type='text']")

    @FindBy(id = "sliders-container")
    var slider: WebElement? = null

    @FindBy(id = "hubspot-messages-iframe-container")
    var chatButton: WebElement? = null
    val textOfTitle: String?
        get() {
            val wait = WebDriverWait(WebDriverManager.getWebdriver(), 10)
            wait.until { driver: WebDriver -> !Strings.isNullOrEmpty(getText(driver.findElement(titleBy))) }
            return getText(WebDriverManager.getWebdriver().findElement(titleBy))
        }

    fun prepareFixedElementsForScreenshot() {
        WebDriverManager.getWebdriverAsJsExecutor().executeScript("arguments[0].setAttribute('style', 'position:unset!important;')", chatButton)
        topMenuPageObject.setHeaderUnfixedPos()
    }

    fun resetFixedElementsForScreenshot() {
        WebDriverManager.getWebdriverAsJsExecutor().executeScript("arguments[0].setAttribute('style', 'position:fixed!important;')", chatButton)
        topMenuPageObject.resetHeaderPos()
    }

    companion object {
        fun loadSeleniumToolkitPage(): Home {
            WebDriverManager.getWebdriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)
            WebDriverManager.getWebdriver()[TestDataProvider.getTestData("startUrl")]
            return Home()
        }
    }

    init {
        PageFactory.initElements(WebDriverManager.getWebdriver(), this)
    }
}