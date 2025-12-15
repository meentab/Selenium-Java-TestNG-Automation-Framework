package utils;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;

public class ExcelReader {
    private Workbook workbook;

    public ExcelReader(String path) throws IOException {
        workbook = WorkbookFactory.create(new File(path));
    }

    public Workbook getWorkbook() {
        return workbook;
    }

    // Add helper methods to read sheets/cells as needed
}
