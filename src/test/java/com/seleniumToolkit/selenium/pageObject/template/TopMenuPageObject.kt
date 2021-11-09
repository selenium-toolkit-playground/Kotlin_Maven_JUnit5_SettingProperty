package com.seleniumToolkit.selenium.pageObject.template

import com.seleniumToolkit.selenium.framework.driver.WebDriverManager
import com.seleniumToolkit.selenium.pageObject.*
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class TopMenuPageObject : AbstractPageObject() {
    var headerXPath: String? = "//header//*[contains(@class, 'fusion-header')]//*[contains(@class, 'fusion-header') and not(contains(@style,'display: none'))]"

    //Field declarations
    @FindBy(xpath = "//a[@title='home']")
    var homeMenu: WebElement? = null

    @FindBy(xpath = "//a[@title='about']")
    var aboutMenu: WebElement? = null

    @FindBy(xpath = "//a[@title='solutions']")
    var solutionsMenu: WebElement? = null

    @FindBy(xpath = "//a[@title='getStarted']")
    var getStartedMenu: WebElement? = null

    @FindBy(xpath = "//a[@title='chromeExtension']")
    var chromeExtensionMenu: WebElement? = null

    @FindBy(xpath = "//a[@title='showcase']")
    var showcaseMenu: WebElement? = null

    @FindBy(xpath = "//a[@title='seleniumHelp']")
    var seleniumHelpMenu: WebElement? = null

    //HelperMethods
    fun clickHomeMenu(): Home {
        click(homeMenu!!)
        return Home()
    }

    fun clickAboutMenu(): About {
        click(aboutMenu!!)
        return About()
    }

    fun clickSolutionsMenu(): Solution {
        click(solutionsMenu!!)
        return Solution()
    }

    fun clickGetStartedMenu(): GetStarted {
        click(getStartedMenu!!)
        return GetStarted()
    }

    fun clickChromeExtensionMenu(): ChromeExtension {
        click(chromeExtensionMenu!!)
        return ChromeExtension()
    }

    fun clickShowcaseMenu(): Showcase {
        click(showcaseMenu!!)
        return Showcase()
    }

    fun clickSeleniumHelpMenu(): SeleniumHelp {
        click(seleniumHelpMenu!!)
        return SeleniumHelp()
    }

    fun setHeaderUnfixedPos() {
        for (element in WebDriverManager.getWebdriver().findElements(By.xpath(headerXPath))!!) {
            WebDriverManager.getWebdriverAsJsExecutor().executeScript("arguments[0].setAttribute('style', 'position:unset!important')", element)
        }
    }

    fun resetHeaderPos() {
        for (element in WebDriverManager.getWebdriver().findElements(By.xpath(headerXPath))!!) {
            WebDriverManager.getWebdriverAsJsExecutor().executeScript("arguments[0].setAttribute('style', 'position:fixed!important')", element)
        }
    }
}