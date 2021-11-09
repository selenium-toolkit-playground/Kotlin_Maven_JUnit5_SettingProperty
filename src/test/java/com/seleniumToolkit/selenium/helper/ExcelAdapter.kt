package com.seleniumToolkit.selenium.helper

import org.apache.poi.hssf.usermodel.HSSFDateUtil
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.ss.usermodel.DataFormatter
import org.apache.poi.ss.usermodel.ExcelNumberFormat
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.IOException
import java.text.SimpleDateFormat

object ExcelAdapter {
    private val row: XSSFRow? = null
    @Throws(Exception::class)
    fun getTableArray(FilePath: String, SheetName: String?): Array<Array<Any?>>? {
        var tabArray: Array<Array<Any?>>? = null
        try {
            val classLoader = System::class.java.classLoader
            val file = File("src/test/resources/$FilePath")
            val ExcelFile = FileInputStream(file)
            // Access the required test data sheet
            val excelWBook = XSSFWorkbook(ExcelFile)
            val excelWSheet = excelWBook.getSheet(SheetName)
            val startRow = 1
            val startCol = 1
            var ci: Int
            var cj: Int
            val totalRows = excelWSheet.lastRowNum
            val totalCols = excelWSheet.getRow(0).lastCellNum - startCol
            tabArray = Array(totalRows) { arrayOfNulls(totalCols) }
            ci = 0
            var i = startRow
            while (i <= totalRows) {
                cj = 0
                var j = startCol
                while (j <= totalCols) {
                    tabArray[ci][cj] = getCellData(excelWSheet, i, j)
                    j++
                    cj++
                }
                i++
                ci++
            }
        } catch (e: FileNotFoundException) {
            println("Could not read the Excel sheet")
            e.printStackTrace()
        } catch (e: IOException) {
            println("Could not read the Excel sheet")
            e.printStackTrace()
        }
        return tabArray
    }

    fun getCellData(excelWSheet: XSSFSheet, RowNum: Int, ColNum: Int): Any? {
        val cell = excelWSheet.getRow(RowNum).getCell(ColNum) ?: return null
        //System.out.println(cell);
        return if (cell.cellTypeEnum == CellType.NUMERIC) {
            //if cell is a date, format it in dd.mm.yyyy
            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                val formatter = SimpleDateFormat("dd-MM-yyyy")
                formatter.format(cell.dateCellValue)
            } else {
                //Currency stays formatted
                val enf = ExcelNumberFormat.from(cell.cellStyle)
                if (enf != null && enf.format.contains("CHF")) {
                    DataFormatter().formatCellValue(cell).replace(",", "’")
                } else {
                    if (enf != null && (enf.format.contains(".") || enf.format.contains(","))) {
                        cell.numericCellValue
                    } else {
                        cell.numericCellValue.toInt()
                    }
                }
            }
        } else cell.toString()
    }
}