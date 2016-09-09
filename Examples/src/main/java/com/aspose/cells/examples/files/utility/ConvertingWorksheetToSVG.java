package com.aspose.cells.examples.files.utility;

import com.aspose.cells.*;
import com.aspose.cells.examples.Utils;

public class ConvertingWorksheetToSVG {

	public static void main(String[] args) throws Exception {
		// ExStart:1
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(ConvertingWorksheetToSVG.class) + "files/";

		String path = dataDir + "Template.xlsx";

		// Create a workbook object from the template file
		Workbook workbook = new Workbook(path);

		// Convert each worksheet into svg format in a single page.
		ImageOrPrintOptions imgOptions = new ImageOrPrintOptions();
		imgOptions.setSaveFormat(SaveFormat.SVG);
		imgOptions.setOnePagePerSheet(true);

		// Convert each worksheet into svg format
		int sheetCount = workbook.getWorksheets().getCount();

		for (int i = 0; i < sheetCount; i++) {
			Worksheet sheet = workbook.getWorksheets().get(i);

			SheetRender sr = new SheetRender(sheet, imgOptions);

			for (int k = 0; k < sr.getPageCount(); k++) {
				// Output the worksheet into Svg image format
				sr.toImage(k, path + sheet.getName() + k + ".output.svg");
			}
		}

		// Print message
		System.out.println("Excel to SVG conversion completed successfully.");
		// ExEnd:1
	}
}
