package com.seleniumToolkit.selenium.helper

import java.util.*

class TestObject(var string: String) {
    override fun toString(): String {
        return "TestObject{" +
                "string='" + string + '\'' +
                '}'
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as TestObject
        return string == that.string
    }

    override fun hashCode(): Int {
        return Objects.hash(string)
    }
}