/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.io.IOException;



import com.google.gdata.client.spreadsheet.SpreadsheetService;

import com.google.gdata.util.ServiceException;
import java.io.File;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

class readingdata {

    SpreadsheetService service = new SpreadsheetService("Sheet1");

    public readingdata() {

    }

    public String searching(String uname) throws IOException, BiffException {
        String p;

        java.io.File file = new java.io.File("D:\\programming\\java projects\\admin\\Blood Donor Information.xls");

        Workbook wb = Workbook.getWorkbook(file);
        Sheet s = wb.getSheet(0);

        int row = s.getRows();
        int col = s.getColumns();

        for (int i = 1; i < row; i++) {

            jxl.Cell c = s.getCell(1, i);

            if (c.getContents().equalsIgnoreCase(uname)) {
                c = s.getCell(2, i);
                return c.getContents();
            }

        }
        return "user not found";
    }

    public String searching3(String uname) throws IOException, BiffException {
        String p = new String();
      
        java.io.File file = new java.io.File("D:\\programming\\java projects\\admin\\Blood Donor Information.xls");

        Workbook wb = Workbook.getWorkbook(file);
        Sheet s = wb.getSheet(0);

        int row = s.getRows();
        int col = s.getColumns();

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                jxl.Cell c = s.getCell(j, i);
  System.out.println(uname);
                if (c.getContents().equalsIgnoreCase(uname)) {
                    System.out.println("here");
                    c = s.getCell(3, i);
                    p += c.getContents() + "---------";
                    c = s.getCell(6, i);
                    p += c.getContents() + "---------";
                    c = s.getCell(7, i);
                    p += c.getContents() + "---------";
                    c = s.getCell(8, i);
                    p += c.getContents() + "&";
                    break;
                }
            }
        }
        System.out.println(p);
        if (p.length() == 0) {
            return "No search result";
        } else {
            return p;
        }
    }

    public void update(String[] p) throws WriteException, IOException, BiffException {

        java.io.File file = new java.io.File("D:\\programming\\java projects\\admin\\Blood Donor Information.xls");

        Workbook wb = Workbook.getWorkbook(file);

        Sheet s = wb.getSheet(0);

        int row = s.getRows();
        int col = s.getColumns();
        WritableWorkbook wkr = Workbook.createWorkbook(new File("Blood Donor Information.xls"), wb);
        
        System.out.println("here1");
        WritableSheet getsht = wkr.getSheet(0);
        WritableCell getcl;
        getcl = getsht.getWritableCell(8, 1);
        for (int i = 1; i <= 9; i++) {
            System.out.println(p[i]);
            if (i == 3) {
                p[2] = p[2].replace("#", " ");
            }
            Label label = new Label(i, row, p[i - 1]);
            getsht.addCell(label);
        }

        wkr.write();
        wkr.close();

    }

    public data search2(String str1) throws ServiceException, IOException, BiffException {
        data d = null;
        String p;

        java.io.File file = new java.io.File("D:\\programming\\java projects\\admin\\Blood Donor Information.xls");

        Workbook wb = Workbook.getWorkbook(file);
        Sheet s = wb.getSheet(0);

        int row = s.getRows();
        int col = s.getColumns();

        for (int i = 1; i < row; i++) {
            jxl.Cell c = s.getCell(1, i);
            String val8 = c.getContents();
            c = s.getCell(3, i);
            String val1 = c.getContents();
            c = s.getCell(4, i);
            String val2 = c.getContents();
            c = s.getCell(5, i);
            String val3 = c.getContents();
            c = s.getCell(6, i);
            String val4 = c.getContents();
            c = s.getCell(7, i);
            String val5 = c.getContents();
            c = s.getCell(9, i);
            String val6 = c.getContents();
            c = s.getCell(8, i);
            String val7 = c.getContents();;

            if (val1.equalsIgnoreCase(str1) | val2.equalsIgnoreCase(str1) | val3.equalsIgnoreCase(str1) | val4.equalsIgnoreCase(str1) | val5.equalsIgnoreCase(str1) | val6.equalsIgnoreCase(str1) | val8.equalsIgnoreCase(str1)) {
                d = new data(val1, val2, val3, val4, val5, val6, val7);
wb.close();
                return d;

            }

        }
        wb.close();
        
        return d;
    }

}
