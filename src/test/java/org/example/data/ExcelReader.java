package org.example.data;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    static FileInputStream fis = null;

    public static FileInputStream getFis()  {
        String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\org\\example\\data\\data.xlsx";
        File srcFile = new File(filePath);
        try {
            fis=new FileInputStream(srcFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fis;
    }

    public Object[][] getExcelData() throws IOException {
        fis= getFis();
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int rowsNum = (sheet.getLastRowNum()+1);
        int colsNum = 3;
        String[][] excelData=new String[rowsNum][colsNum];

        for (int i=0;i<rowsNum;i++){
            for (int j=0;j<colsNum;j++){
                XSSFRow row = sheet.getRow(i);
                excelData[i][j] = row.getCell(j).toString();
            }
        }

        workbook.close();
        return excelData;
    }
}
