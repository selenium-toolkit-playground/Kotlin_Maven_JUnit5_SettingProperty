package com.seleniumToolkit.selenium.test.screenshot

import com.seleniumToolkit.selenium.framework.assertBase.ReportAssert
import com.seleniumToolkit.selenium.framework.screenshot.core.Capture
import com.seleniumToolkit.selenium.framework.screenshot.core.ScreenShootMaker
import com.seleniumToolkit.selenium.framework.tag.SeleniumTest
import com.seleniumToolkit.selenium.pageObject.Home
import com.seleniumToolkit.selenium.pageObject.template.AbstractSeleniumToolkitPageObject
import java.io.File

class PageScreenshotTest : AbstractScreenshotTest() {
    @SeleniumTest
    fun screenshotScroll() {
        val screenshotFilePath = "screenshots/PageScreenshotTest_screenshotScroll.png"
        deleteFileIfExist(screenshotFilePath)
        val home: Home = AbstractSeleniumToolkitPageObject.Companion.loadSeleniumToolkitPage()
        home.clickSolutionButton()
        home.prepareFixedElementsForScreenshot()
        ScreenShootMaker.page.shoot(Capture.FULL_SCROLL)
                .withName("PageScreenshotTest_screenshotScroll")
                .save()
        home.resetFixedElementsForScreenshot()
        val screenshotFile = File(screenshotFilePath)
        ReportAssert.assertTrue("File should exist", screenshotFile.exists())
    }

    @SeleniumTest
    fun screenshotScrollWithCutOut() {
        val screenshotFilePath = "screenshots/PageScreenshotTest_screenshotScrollWithCutOut.png"
        deleteFileIfExist(screenshotFilePath)
        val home: Home = AbstractSeleniumToolkitPageObject.Companion.loadSeleniumToolkitPage()
        val solution = home.clickSolutionButton()
        solution!!.prepareFixedElementsForScreenshot()
        ScreenShootMaker.page.shoot(Capture.FULL_SCROLL)
                .cutOut(solution.slider)
                .withName("PageScreenshotTest_screenshotScrollWithCutOut")
                .save()
        solution.resetFixedElementsForScreenshot()
        val screenshotFile = File(screenshotFilePath)
        ReportAssert.assertTrue("File should exist", screenshotFile.exists())
    }
}