package com.automation.Tests.Day25_excel_io;

import com.automation.Utilities.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import javax.print.attribute.standard.SheetCollate;
import java.io.File;
import java.util.Map;

public class ReadDataFromExcel {


    @Test
    public void readExcelFileTest() throws Exception {
        // we need to get a file as an object
        File file = new File("VytrackTestUsers.xlsx");
        //object that represents excel file
        Workbook workbook = WorkbookFactory.create(file);
        //get QA1-short
        Sheet workSheet = workbook.getSheet("QA1-short");
        //get 1st row
        Row firstRow = workSheet.getRow(0);
        //get 1st cell
        Cell firstCell = firstRow.getCell(0);
        //get string value
        String value = firstCell.getStringCellValue();
        String secondValue = firstRow.getCell(1).getStringCellValue();

        System.out.println(value);
        System.out.println(secondValue);

        int lastCell = firstRow.getLastCellNum();
        System.out.println("################################################");
        for (int i = 0; i < lastCell; i++) {
            System.out.print(firstRow.getCell(i) + " | ");
        }

        //last row is 16th --> index is 15

        //index of last row
        int numberOfRows = workSheet.getLastRowNum();
        //returns how many rows at all
        int numberOfRows2 = workSheet.getPhysicalNumberOfRows();

        System.out.println("\nIndex of last row : " + numberOfRows);
        System.out.println("\nNumber of rows : " + numberOfRows2);

        System.out.println("################################################");

        for (int row = 0; row < workSheet.getPhysicalNumberOfRows(); row++) {
            for (int cell = 0; cell < workSheet.getRow(row).getLastCellNum(); cell++) {
                String cellValue = workSheet.getRow(row).getCell(cell).getStringCellValue();
                System.out.println(cellValue + " | ");
            }
            System.out.println();
        }


    }

    @Test
    public void excelUtilityTest() {
        String path = "VytrackTestUsers.xlsx";
        String spreadSheet = "QA1-all";
        ExcelUtil excelUtil = new ExcelUtil(path, spreadSheet);
        excelUtil.getDataList().forEach(System.out::println); // for each loopun kisaltmasi

        for (Map<String, String> record : excelUtil.getDataList()) {
            System.out.println(record);
        }
    }

    @Test
    public void getColumnNamesTest() {
        String path = "VytrackTestUser.xlsx";
        String spreadSheet = "QA1-short";
        ExcelUtil excelUtil = new ExcelUtil(path, spreadSheet);

        System.out.println(excelUtil.getColumnsNames());


    }

}
