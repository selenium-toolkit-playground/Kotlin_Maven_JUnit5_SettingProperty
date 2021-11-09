package com.seleniumToolkit.selenium.pageObject.template

import com.seleniumToolkit.selenium.framework.assertBase.ReportAssert
import com.seleniumToolkit.selenium.framework.driver.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.support.ui.Wait
import org.openqa.selenium.support.ui.WebDriverWait

abstract class AbstractPageObject {
    protected fun click(element: WebElement) {
        element.click()
    }

    protected fun enter(element: WebElement, vararg input: CharSequence?) {
        element.sendKeys(*input)
    }

    protected fun enterRepalace(element: WebElement, input: CharSequence?) {
        element.clear()
        enter(element, input)
    }

    protected fun getValueOfInput(element: WebElement): String {
        return element.getAttribute("value")
    }

    protected fun selectByValue(element: WebElement?, value: String?) {
        Select(element).selectByValue(value)
    }

    protected fun selectByLabel(element: WebElement?, label: String?) {
        Select(element).selectByVisibleText(label)
    }

    protected fun selectByIndex(element: WebElement?, index: Int) {
        Select(element).selectByIndex(index)
    }

    protected fun getText(element: WebElement): String {
        return element.text
    }

    fun waitUntilUrlContains(text: String?) {
        val wait: Wait<WebDriver> = WebDriverWait(WebDriverManager.getWebdriver(), 30)
        try {
            wait.until { driver: WebDriver -> driver.currentUrl.contains(text!!) }
        } catch (pageLoadWaitError: Throwable) {
            ReportAssert.fail("Timeout during page load")
        }
    }

    init {
        PageFactory.initElements(WebDriverManager.getWebdriver(), this)
    }
}