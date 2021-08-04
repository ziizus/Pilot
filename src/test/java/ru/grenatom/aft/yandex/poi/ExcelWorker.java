package ru.grenatom.aft.yandex.poi;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWorker {
    public static XSSFWorkbook wb;
    public static XSSFSheet sheet;

    public ExcelWorker(String excelPath)
    {
        try {
            FileInputStream fis = new FileInputStream(excelPath);
            wb = new XSSFWorkbook(fis);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public String readData (int row, int column ){

        sheet = wb.getSheet("data");
        String data = sheet.getRow(row).getCell(column).toString();
        return data;
    }
}