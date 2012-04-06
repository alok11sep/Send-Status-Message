package utility;

import java.io.*;
import com.lowagie.text.*;
import com.lowagie.text.rtf.*;


public class RTFClass {

	Font font;
	Chunk chunk;
	Paragraph p;
	Document document;
	

	public RTFClass() {
		document = new Document();
		p = new Paragraph();
	}

	public Paragraph addToParagraph(String txt, int format) {
		switch (format) {
		case 0:
			font = new Font(Font.getStyleValue("ARIAL"), 12, Font.NORMAL); // 1
		//	font.setColor(new Color(0x92, 0x90, 0x83));

			chunk = new Chunk(txt, font); // 2
			p.add(chunk);
			break;
		case 1:
			font = new Font(Font.TIMES_ROMAN, 12, Font.BOLD); // 1
			//font.setColor(new Color(0x92, 0x90, 0x83));

			chunk = new Chunk(txt, font); // 2
			p.add(chunk);
			break;
		case 2:
			font = new Font(Font.TIMES_ROMAN, 12, Font.BOLDITALIC); // 1
			//font.setColor(new Color(0x92, 0x90, 0x83));

			chunk = new Chunk(txt, font); // 2
			p.add(chunk);
			break;

		default:
			break;
		}
		return p;
	}
	public void writeTheData(Paragraph para){

		System.out.println("This example generate a RTF file name Sample.rtf");
		// Create Document object

		try {
			// Create writer to listen document object
			// and directs RTF Stream to the file Sample.rtf
			RtfWriter2
					.getInstance(document, new FileOutputStream("StartTemplate.oft"));
			// open the document object
			document.open();


			// Add the paragraph to document object
			document.add(para);
		} catch (Exception e) {
			System.out.println(e);
		}
		// close the document
		document.close();
	
	}
	public static void main(String[] args) {
		RTFClass class1 = new RTFClass();
		 Paragraph para = new Paragraph();
		 para = class1.addToParagraph("Alok", 0);
		 para = class1.addToParagraph("Maheshwary", 2);
		class1.writeTheData(para);
	}
}
