package com.seleniumToolkit.selenium.test

import com.seleniumToolkit.selenium.framework.allure.AllureUtils
import com.seleniumToolkit.selenium.framework.assertBase.ReportAssert
import com.seleniumToolkit.selenium.helper.TestObject
import org.junit.jupiter.api.Test

class AssertTest {
    @Test
    fun sample() {
        AllureUtils.startStep("ReportAssert.assertEquals")
        ReportAssert.assertEquals("1==1 int", 1, 1)
        ReportAssert.assertEquals("1==1 long", 1L, 1L)
        ReportAssert.assertEquals("\"1.0\"==\"1.0\" String", "1.0", "1.0")
        ReportAssert.assertArrayEquals("[1,2]==[1,2] int[]", intArrayOf(1, 2), intArrayOf(1, 2))
        ReportAssert.assertArrayEquals("[1,2]==[1,2] long[]", longArrayOf(1L, 2L), longArrayOf(1L, 2L))
        ReportAssert.assertArrayEquals("[1.0,2.0]==[1.0,2.0] float[]", floatArrayOf(1.0.toFloat(), 2.0.toFloat()), floatArrayOf(1.0.toFloat(), 2.0.toFloat()), 0f)
        ReportAssert.assertArrayEquals("[1.0,2.0]==[1.0,2.0] double[]", doubleArrayOf(1.0, 2.0), doubleArrayOf(1.0, 2.0), 0.0)
        ReportAssert.assertEquals("new TestObject(\"1.0\") == new TestObject(\"1.0\")", TestObject("1.0"), TestObject("1.0"))
        AllureUtils.stopStepPassed()
        AllureUtils.startStep("ReportAssert.assertNotEquals")
        ReportAssert.assertNotEquals("1!=2 int", 1, 2)
        ReportAssert.assertNotEquals("1!=2 long", 1L, 2L)
        ReportAssert.assertNotEquals("1.0!=2.0 float", 1.0.toFloat(), 2.0.toFloat())
        ReportAssert.assertNotEquals("1.0!=2.0 double", 1.0, 2.0)
        ReportAssert.assertNotEquals("\"1.0\"!=\"2.0\" String", "1.0", "2.0")
        ReportAssert.assertNotEquals("[1,2]!=[2,2] int[]", intArrayOf(1, 2), intArrayOf(2, 2))
        ReportAssert.assertNotEquals("[1,2]!=[2,2] long[]", longArrayOf(1L, 2L), longArrayOf(2L, 2L))
        ReportAssert.assertNotEquals("[1.0,2.0]!=[2.0,2.0] float[]", floatArrayOf(1.0.toFloat(), 2.0.toFloat()), floatArrayOf(2.0.toFloat(), 2.0.toFloat()))
        ReportAssert.assertNotEquals("[1.0,2.0]!=[2.0,2.0] double[]", doubleArrayOf(1.0, 2.0), doubleArrayOf(2.0, 2.0))
        ReportAssert.assertNotEquals("[1.0,2.0]!=[2.0,2.0] String[]", arrayOf("1.0", "2.0"), arrayOf("2.0", "2.0"))
        ReportAssert.assertNotEquals("new TestObject(\"1.0\") != new TestObject(\"2.0\")", TestObject("1.0"), TestObject("2.0"))
        AllureUtils.stopStepPassed()
        AllureUtils.startStep("ReportAssert.assertTrue/assertFalse")
        ReportAssert.assertTrue("ReportAssert.assertTrue", true)
        ReportAssert.assertFalse("ReportAssert.assertFalse", false)
        AllureUtils.stopStepPassed()
        AllureUtils.startStep("ReportAssert.assertNull")
        ReportAssert.assertNull("ReportAssert.assertNull null", null)
        AllureUtils.stopStepPassed()
        AllureUtils.startStep("ReportAssert.assertSame/assertNotSame")
        val t = TestObject("1.0")
        ReportAssert.assertSame("t = new TestObject(\"1.0\"); t == t", t, t)
        ReportAssert.assertNotSame("t = new TestObject(\"1.0\"); t !=  new TestObject(\"1.0\");", t, TestObject("1.0"))
        AllureUtils.stopStepPassed()
    }
}