package com.seleniumToolkit.selenium.test.screenshot

import com.seleniumToolkit.selenium.framework.assertBase.ReportAssert
import com.seleniumToolkit.selenium.framework.screenshot.core.Capture
import com.seleniumToolkit.selenium.framework.screenshot.core.ScreenShootMaker
import com.seleniumToolkit.selenium.framework.tag.SeleniumTest
import com.seleniumToolkit.selenium.pageObject.Home
import com.seleniumToolkit.selenium.pageObject.template.AbstractSeleniumToolkitPageObject
import java.io.File

class ElementScreenshotTest : AbstractScreenshotTest() {
    @SeleniumTest
    fun screenshot() {
        val screenshotFilePath = "screenshots/ElementScreenshotTest_screenshot.png"
        deleteFileIfExist(screenshotFilePath)
        val home: Home = AbstractSeleniumToolkitPageObject.Companion.loadSeleniumToolkitPage()
        home.prepareFixedElementsForScreenshot()
        ScreenShootMaker.page.shoot(Capture.FULL_SCROLL).cropAround(home.solutionButton, 0, 0).withName("ElementScreenshotTest_screenshot").save()
        home.resetFixedElementsForScreenshot()
        val screenshotFile = File(screenshotFilePath)
        ReportAssert.assertTrue("File should exist", screenshotFile.exists())
    }
}