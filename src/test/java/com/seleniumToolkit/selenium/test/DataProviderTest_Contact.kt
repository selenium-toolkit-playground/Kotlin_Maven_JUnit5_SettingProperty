package com.seleniumToolkit.selenium.test

import com.google.common.base.Strings
import com.seleniumToolkit.selenium.framework.assertBase.ReportAssert
import com.seleniumToolkit.selenium.framework.tag.SeleniumTest
import com.seleniumToolkit.selenium.helper.ExcelAdapter
import com.seleniumToolkit.selenium.pageObject.Home
import com.seleniumToolkit.selenium.pageObject.template.AbstractSeleniumToolkitPageObject
import io.qameta.allure.Feature
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class DataProviderTest_Contact {
    @SeleniumTest
    @MethodSource("contactProvider")
    @Feature("DataProvider")
    fun contactWithStandardDataproviderParallel(name: String?, email: String?, phone: String?, message: String?, errorSize: Int?) {
        testContact(name, email, phone, message, errorSize)
    }

    @SeleniumTest
    @MethodSource("contactProviderFromExcel")
    @Feature("DataProvider")
    fun contactWithExcelDataproviderNotParallel(name: String?, email: String?, phone: String?, message: String?, errorSize: Int?) {
        testContact(name, email, phone, message, errorSize)
    }

    private fun testContact(name: String?, email: String?, phone: String?, message: String?, errorSize: Int?) {
        val home: Home = AbstractSeleniumToolkitPageObject.Companion.loadSeleniumToolkitPage()
        val getStarted = home.topMenuPageObject.clickGetStartedMenu()
        if (!Strings.isNullOrEmpty(name)) {
            getStarted!!.enterName(name)
        }
        if (!Strings.isNullOrEmpty(email)) {
            getStarted!!.enterEmail(email)
        }
        if (!Strings.isNullOrEmpty(phone)) {
            getStarted!!.enterPhoneNumber(phone)
        }
        if (!Strings.isNullOrEmpty(message)) {
            getStarted!!.enterMessage(message)
        }
        getStarted!!.clickSubmitButton()
        ReportAssert.assertEquals("Test the Size of Errorlist", getStarted.getErrorFieldSize(), errorSize)
    }

    companion object {
        @JvmStatic
        fun contactProvider(): Stream<Arguments> {
            return Stream.of(
                    Arguments.of("Michel", "no Vailid", "052 000 00 00", "", 3),
                    Arguments.of("Michel", "info@selenium-toolkit.com", "", "", 2)
            )
        }

        @Throws(Exception::class)
        @JvmStatic
        fun contactProviderFromExcel(): Array<Array<Any?>>? {
            return ExcelAdapter.getTableArray("testdata/contactInput.xlsx", "Daten")
        }
    }
}