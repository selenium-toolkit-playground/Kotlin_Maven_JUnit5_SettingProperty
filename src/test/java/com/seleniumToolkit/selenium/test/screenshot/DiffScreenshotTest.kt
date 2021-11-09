package com.seleniumToolkit.selenium.test.screenshot

import com.seleniumToolkit.selenium.framework.assertBase.ReportAssert
import com.seleniumToolkit.selenium.framework.screenshot.core.Capture
import com.seleniumToolkit.selenium.framework.screenshot.core.ScreenShootMaker
import com.seleniumToolkit.selenium.framework.tag.SeleniumTest
import com.seleniumToolkit.selenium.pageObject.Home
import com.seleniumToolkit.selenium.pageObject.template.AbstractSeleniumToolkitPageObject
import java.io.File

class DiffScreenshotTest : AbstractScreenshotTest() {
    @SeleniumTest
    fun screenshotScrollDiffSuccess() {
        val diffScreenshot = "screenshots/ScreenshotTest_ScreenshotScrollPageDiffSuccess"
        deleteFileIfExist("$diffScreenshot.png")
        val home: Home = AbstractSeleniumToolkitPageObject.Companion.loadSeleniumToolkitPage()
        val getStarted = home.topMenuPageObject.clickGetStartedMenu()
        getStarted!!.waitUntilUrlContains(getStarted.URL)
        getStarted.prepareFixedElementsForScreenshot()
        ReportAssert.assertTrue("Screenshot should be same, but is not", ScreenShootMaker.page.shoot(Capture.FULL_SCROLL, 2000).cutOut(getStarted.slider).equalsWithDiff("screenshots/reference/ScreenshotTest_ScreenshotScrollPageDiffSuccess.png", diffScreenshot))
        getStarted.resetFixedElementsForScreenshot()
        val screenshotFile = File("$diffScreenshot.png")
        ReportAssert.assertFalse("File should not exist", screenshotFile.exists())
    }

    @SeleniumTest
    fun screenshotScrollDiffFailedDimensionMissmatch() {
        val diffScreenshot = "target/screenshots/ScreenshotTest_ScreenshotScrollPageDimensionMissmatchDiff"
        deleteFileIfExist("$diffScreenshot.png")
        val home: Home = AbstractSeleniumToolkitPageObject.Companion.loadSeleniumToolkitPage()
        val seleniumHelp = home.topMenuPageObject.clickSeleniumHelpMenu()
        //home.topMenuPageObject.clickAboutMenu();
        seleniumHelp!!.prepareFixedElementsForScreenshot()
        ReportAssert.assertFalse("Screenshot should be same, but is not", ScreenShootMaker.page.shoot(Capture.FULL_SCROLL, 2000).cutOut(seleniumHelp.slider).equalsWithDiff("screenshots/reference/ScreenshotTest_ScreenshotScrollPageDimensionMissmatch.png", "target/screenshots/ScreenshotTest_ScreenshotScrollPageDimensionMissmatchDiff"))
        seleniumHelp.resetFixedElementsForScreenshot()
        val screenshotFile = File("$diffScreenshot.png")
        ReportAssert.assertFalse("File should not exist, because Dimensiot missmatch", screenshotFile.exists())
    }

    @SeleniumTest
    fun screenshotScrollPageDiffFailed() {
        val diffScreenshot = "target/screenshots/ScreenshotTest_ScreenshotScrollPageDiffFalse"
        deleteFileIfExist("$diffScreenshot.png")
        val home: Home = AbstractSeleniumToolkitPageObject.Companion.loadSeleniumToolkitPage()
        val showcase = home.topMenuPageObject.clickShowcaseMenu()
        showcase!!.waitUntilUrlContains(showcase.URL)
        home.prepareFixedElementsForScreenshot()
        ReportAssert.assertFalse("Screenshot should be same, but is not", ScreenShootMaker.page.shoot(Capture.FULL_SCROLL, 2000).equalsWithDiff("screenshots/reference/DiffScreenshotTest_screenshotScrollPageDiffFailed.png", diffScreenshot, 0.00))
        home.resetFixedElementsForScreenshot()
        val screenshotFile = File("$diffScreenshot.png")
        ReportAssert.assertTrue("File should exist", screenshotFile.exists())
    }

    @SeleniumTest
    fun screenshotElementDiffSuccess() {
        val diffScreenshot = "target/screenshots/ScreenshotTest_ScreenshotElementDiffSuccess"
        deleteFileIfExist("$diffScreenshot.png")
        val home: Home = AbstractSeleniumToolkitPageObject.Companion.loadSeleniumToolkitPage()
        home.prepareFixedElementsForScreenshot()
        ReportAssert.assertTrue("Screenshot should be same, but is not", ScreenShootMaker.element.shoot(home.solutionButton).equalsWithDiff("screenshots/reference/DiffScreenshotTest_screenshotElementDiffSuccess.png", diffScreenshot))
        home.resetFixedElementsForScreenshot()
        val screenshotFile = File("$diffScreenshot.png")
        ReportAssert.assertFalse("File should not exist", screenshotFile.exists())
    }
}