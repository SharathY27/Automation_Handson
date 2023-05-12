package excel_to_Html;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_to_Html {

	static int count = 0;
	static StringBuilder sb = new StringBuilder();

	static void open_tag(StringBuilder sb, String tag) {
		sb.append("<").append(tag).append(">");
	}

	static void close_tag(StringBuilder sb, String tag) {
		sb.append("<").append("/" + tag).append(">");
	}

	static void tag_content(StringBuilder sb, Object content) {
		sb.append(content);
	}

	// Here we are going to convert Excel file to Html

	public static String convertExcelToHtml(String excelFilePath) throws IOException, InterruptedException {

		File htmlFile = new File(
				"src\\main\\resources\\Excel_to_Html\\BuiltIn_Functional_Interfaces_In_Java8_Html_File.html");

		BufferedWriter bw = new BufferedWriter(new FileWriter(htmlFile));
		bw.flush(); // flush method will removes all contents html file

		// Now read the excel file and iterate over each cells

		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(excelFilePath)); // For Excel workbook

		XSSFSheet sheet = workbook.getSheetAt(1); // For getting sheet in workbook

		int noOfRows = sheet.getPhysicalNumberOfRows();
		int noOfColumns = sheet.getRow(0).getPhysicalNumberOfCells();

		System.out.println(noOfRows + " , " + noOfColumns);
		FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator(); // this is to know
																									// the return type
																									// of cell

		for (Row row : sheet) {
			count += 1;
			open_tag(sb, "tr");
			for (Cell cell : row) {
				if (count == 1) {
					open_tag(sb, "th");
				} else {
					open_tag(sb, "td");
				}
				switch (formulaEvaluator.evaluate(cell).getCellType()) {
				case NUMERIC:
					if (count == 1) {
						open_tag(sb, "strong");
						tag_content(sb, String.valueOf(cell.getNumericCellValue()));
						close_tag(sb, "strong");

						close_tag(sb, "th");
					} else {
						tag_content(sb, String.valueOf(cell.getNumericCellValue()));
						close_tag(sb, "td");
					}
					break;

				case STRING:
					if (count == 1) {
						open_tag(sb, "strong");
						tag_content(sb, String.valueOf(cell.getStringCellValue()));
						close_tag(sb, "strong");
						close_tag(sb, "th");
					} else {
						tag_content(sb, cell.getStringCellValue());
						close_tag(sb, "td");
					}
					break;

				case BLANK:
					break;
				/*
				 * case _NONE: if (count == 1) { open_tag(sb, "strong"); tag_content(sb,
				 * String.valueOf(cell.getStringCellValue())); close_tag(sb, "strong");
				 * close_tag(sb, "th"); } else { tag_content(sb,
				 * String.valueOf(cell.getStringCellValue())); close_tag(sb, "td"); } break;
				 */
				default:
					break;
				}
			}
			close_tag(sb, "tr");
		}

		// For Special Characters we are not able to find it with apache POI
		
		System.out.println(sb);
		// Now we have created excel to html and content is in stringbuilder sb

		String html = "<html>\r\n" + "<head>\r\n" + "<style>\r\n" + "table{\r\n" + "	border-spacing : 3px;\r\n"
				+ "	border-collapse : collapse;\r\n" + "	background : rgb(40,168,40);\r\n"
				+ "	border-color : color;\r\n" + "	overflow:hidden;\r\n" + "	width: 100%;\r\n"
				+ "	margin:0 auto;\r\n" + "	position: relative;\r\n" + "	table-layout: fixed;\r\n"
				+ "	text-align:center;\r\n" + "}\r\n" + "\r\n" + "thead{\r\n" + "	font-size:large;\r\n"
				+ "	font-weight:bold;\r\n" + "	text-align:center;\r\n" + "	}\r\n" + "	\r\n" + "th{\r\n"
				+ "	white-space: nowrap;\r\n" + "	overflow:hidden;\r\n" + "	font-size:18px;\r\n"
				+ "	color:rgb(252,249,249);\r\n" + "	background:rgba(16,121,63);\r\n" + "	height: 55px;\r\n"
				+ "	}\r\n" + "	\r\n" + "th,td{\r\n" + "	white-space:nowrap;\r\n" + "	width:60%;\r\n"
				+ "	overflow-wrap:break-word;\r\n" + "	overflow:hidden;\r\n" + "	text-overflow:ellipsis;\r\n"
				+ "	padding:0.9em solid;\r\n" + "	border:1px solid #ccc;\r\n" + "	}\r\n" + "td{\r\n"
				+ "	height: 35px;\r\n" + "	background:white;\r\n" + "	}\r\n" + ".content{\r\n" + "	font-weight:bold;\r\n"
				+ "	font-family:Copperplate, Papyrus, fantasy;\r\n" + "	font-size:20px;\r\n"
				+ "	text-align:center;\r\n" + "	color:darkred;\r\n" + "	text-shadow: 2px 2px 5px whitesmoke;\r\n"
				+ "	background-color: #ffffff;\r\n" + "	text-shadow: 3px 3px 0 #bcbcbc, 4px 4px 0 #9c9c9c;\r\n"
				+ "	}\r\n" + ".content h1{\r\n" + "	margin-top: 3px;\r\n" + "	}\r\n" + ".row{\r\n"
				+ "	margin-top: -90px;\r\n" + "	margin-right: 10%;\r\n" + "	text-shadow: none;\r\n"
				+ "	text-align : right;\r\n" + "	}\r\n" + ".col{\r\n" + "	margin-top: -25px;\r\n"
				+ "	margin-right: 10%;\r\n" + "	text-shadow: none;\r\n" + "	text-align : right;\r\n" + "	}\r\n"
				+ "</style>\r\n" + "</head>\r\n" + "<body>\r\n" + "<div class=\"content\">\r\n"
				+ "<h1 data-heading=\"Downloaded Excel Sheet\">Downloaded Excel Sheet</h1>\r\n"
				+ "<h3 class=\"row\">No. of Rows: " + --noOfRows + "</h3>\r\n" + "<h3 class=\"col\">No. of Columns: "
				+ noOfColumns + " </h3>\r\n" + "</div>\r\n" + "<div>\r\n" + "<table>\r\n" + "<thead>\r\n" + "<tbody>"
				+ sb.toString() + "</tbody</table></div></body></html>";

		bw.write(html);
		bw.close();
		sb = new StringBuilder();
		count = 0;
		Thread.sleep(3000);

		System.out.println(html);
		return htmlFile.getAbsolutePath();
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		convertExcelToHtml("src\\main\\resources\\Excel_to_Html\\BuiltIn_Functional_Interfaces_In_Java8.xlsx");
	}

}
