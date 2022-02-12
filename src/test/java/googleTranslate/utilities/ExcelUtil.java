package googleTranslate.utilities;


import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtil {

    private Sheet workSheet;
    private Workbook workBook;
    private String filePath;

    public ExcelUtil(String path, String sheetName) {
        this.filePath = path;
        try {
            FileInputStream ExcelFile = new FileInputStream(path);
            workBook = WorkbookFactory.create(ExcelFile);
            workSheet = workBook.getSheet(sheetName);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public String getCellData(int rowNum, int colNum) {
        Cell cell;
        try {
            cell = workSheet.getRow(rowNum).getCell(colNum);
            String cellData = cell.toString();
            return cellData;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
