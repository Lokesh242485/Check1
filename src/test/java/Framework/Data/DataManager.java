package Framework.Data;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.ResourceLoader;

import java.io.*;

public  class DataManager {
    public static String DatafromExcel;
    static String filePath="CustomerDataRead.xlsx";
    public static String excelReader(String targetColumnName,int targetRowNumber) throws IOException {



        try {
            // Create a FileInputStream to read the Excel file
            InputStream inputStream = ResourceLoader.class.getClassLoader().getResourceAsStream(filePath);

            // Create a Workbook instance for the Excel file (XLSX format)
            Workbook workbook = new XSSFWorkbook(inputStream);

            // Get the first sheet of the Excel file
            Sheet sheet = workbook.getSheetAt(0);

            // Find the column index for the target column name
            int columnIndex = -1;
            Row headerRow = sheet.getRow(0);
            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                Cell cell = headerRow.getCell(i);
                if (cell != null && cell.getCellType() == CellType.STRING && targetColumnName.equals(cell.getStringCellValue())) {
                    columnIndex = i;
                    break;
                }
            }

            if (columnIndex != -1) {
                // Get the specified row
                Row row = sheet.getRow(targetRowNumber);

                if (row != null) {
                    // Get the cell in the specified column for the given row
                    Cell cell = row.getCell(columnIndex);

                    if (cell != null) {
                        // Depending on the cell type, read and print the cell value
                        switch (cell.getCellType()) {
                            case STRING:
                                System.out.println("Value: " + cell.getStringCellValue());
                                DatafromExcel=cell.getStringCellValue();
                                break;
                            case NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    System.out.println("Date Value: " + cell.getDateCellValue());
                                } else {
                                    System.out.println("Numeric Value: " + cell.getNumericCellValue());
                                    DatafromExcel = String.valueOf((int) cell.getNumericCellValue());
                                }
                                break;
                            case BOOLEAN:
                                System.out.println("Boolean Value: " + cell.getBooleanCellValue());
                                break;
                            case BLANK:
                                System.out.println("Value is Mendetory");
                                break;
                            default:
                                System.out.println("UNKNOWN issue");
                                break;
                        }
                    } else {
                        System.out.println("Cell not found in the specified column and row.");
                    }
                } else {
                    System.out.println("Row not found for the specified row number.");
                }
            } else {
                System.out.println("Column not found for the specified column name.");
            }

            // Close the workbook and input stream
            workbook.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return DatafromExcel;
    }


    public static void writeEmailToExcel(String email) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            //email=excelReader("EmailID",1);

           // String sheetName = "Email";
            // Get the existing sheet by name
            Sheet sheet = workbook.getSheetAt(1);
            if (sheet == null) {
                System.err.println("Sheet  not found in the existing Excel file.");
                return;
            }
            // Create a new row and cell to store the email ID
            Row row = sheet.createRow(sheet.getLastRowNum() + 1); // Create a new row after the last row
            Cell cell = row.createCell(0); // Create a cell in the first column (column 0)
            cell.setCellValue(email);

            // Save the workbook to a file
            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                workbook.write(outputStream);
                System.out.println("Email ID written to Excel successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }



