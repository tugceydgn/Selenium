package com.automation.Tests.Day28_write_into_excel;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

public class WriteIntoExcelFile {

    @Test
    public void writeIntoFileTest() throws IOException {

        FileInputStream inputStream = new FileInputStream("VytrackTestUsers.xlsx");

        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet("QA3-short");
        Row row = sheet.getRow(1); //2nd row
        Cell cell = row.getCell(5); //get result column
        cell.setCellValue("PASSED"); //I am changing from n/a to passed

        Row firstRow = sheet.getRow(0);
        Cell newCell = firstRow.createCell(6);
        newCell.setCellValue("Date of execution"); //give the name to this cell


        //write date and time info second row, last column
        Row secondRow = sheet.getRow(1); //2nd row
        Cell newCell2 = secondRow.createCell(6);
        newCell2.setCellValue(LocalDateTime.now().toString());

        // I create if I want to write something into the file
        //don't forget to close excel file if you opened it
        FileOutputStream outputStream = new FileOutputStream("VytrackTestUsers.xlsx");
        workbook.write(outputStream);
        workbook.close();

    }
}
