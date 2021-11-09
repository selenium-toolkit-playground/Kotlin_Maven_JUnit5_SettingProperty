package com.seleniumToolkit.selenium.test.screenshot

import java.io.File

open class AbstractScreenshotTest {
    fun deleteFileIfExist(filePath: String?) {
        val file = File(filePath)
        if (file.exists()) {
            file.delete()
        }
    }
}