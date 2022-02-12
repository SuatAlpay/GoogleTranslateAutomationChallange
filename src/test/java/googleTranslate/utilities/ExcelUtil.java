package googleTranslate.utilities;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;

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
}
