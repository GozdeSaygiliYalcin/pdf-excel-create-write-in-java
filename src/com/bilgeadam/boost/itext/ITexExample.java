package com.bilgeadam.boost.itext;

import java.io.FileOutputStream;

import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;


public class ITexExample {
	
	private final String FONT = "/System/Library/Fonts/Supplemental/Arial Unicode.ttf";
	private Document pdf;
	private Font font;

	public static void main(String[] args) {
		
		ITexExample iText = new ITexExample();
		try {
			
			iText.createPDDFile();
			iText.pdf.open();
			iText.createPDF();
			iText.pdf.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	private void createPDF() throws DocumentException {
		this.pdf.add(new Paragraph("One day in your life said love would remind you. How could you leave it all behind" + this.getFont()));
	}

	private void createPDDFile() throws Exception {
		this.pdf = new Document(PageSize.A4, 20, 20, 20, 20);
		
		FileOutputStream fos = new FileOutputStream("/Users/gozde/Desktop/Coding/01-BilgeAdam_Boost/ITextExample/itex.pdf");
		PdfWriter.getInstance(this.pdf, fos);
		
	}
	
	private Font getFont() {
		if(this.font == null) {
			this.font = FontFactory.getFont(FONT);
		}
		return this.font;
	}

}
