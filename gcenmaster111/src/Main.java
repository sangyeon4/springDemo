import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelReaderClass {

    public ExcelReaderClass() {

    }

    public void loadExcel() {
        File f = new File("c:/filetest/data.xls"); 				// java.io.File
        Workbook wb = null;                        				// jxl.Workbook

        try {
            wb = Workbook.getWorkbook(f);
            Sheet s = wb.getSheet(0);             			    // jxl.Sheet

            int i = 0; // 엑셀 시트내의 행번호 카운트 변수

            while(true) {
                try {
                    Cell c = s.getCell(0, i);  		// jxl.Cell
                    System.out.println(c.getContents());       // cell 안에 data를 읽는 메서드
                    i++;

                }catch (Exception e) {
                    break; // 읽을 데이터가 더이상 없다면 while문 중지
                }
            }

        }catch (Exception e) {
            System.out.println("엑셀 파일 읽기 실패 ERR : " + e.getMessage());
        }
    } // end of loadExcel()


}