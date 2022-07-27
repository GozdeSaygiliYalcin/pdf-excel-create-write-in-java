package com.bilgeadam.boost.pdfbox;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.text.PDFTextStripper;

import lombok.Cleanup;

public class PDFBoxExample {
	
	public static void main(String[] args) {
		
		PDFBoxExample pdfBox = new PDFBoxExample();
		try {
			pdfBox.createPDF();
			pdfBox.createPDFWithImage();
			pdfBox.readPDF();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	private void readPDF() throws Exception {
		
		String documentPath = "/Users/gozde/Desktop/Coding/03-NeedfulThings/Notes/Clean Code'dan Notlar.pdf";
		PDDocument doc = PDDocument.load(new File(documentPath));
		PDFTextStripper stripper = new PDFTextStripper();
		String text = stripper.getText(doc);
		System.err.println(text);
		
	}

	private void createPDFWithImage() throws Exception {
		
		String imagePath = "/Users/gozde/Desktop/work.jpg";
		
		@Cleanup 
		PDDocument pdf = new PDDocument();   //pdf belgesi yaratıldı	
		PDPage page = new PDPage();          //sayfa yaratıldı
		pdf.addPage(page);				     //yaratılan sayfa belgeye ekleniyor
		PDImageXObject image = PDImageXObject.createFromFile(imagePath, pdf);
		
		@Cleanup 
		PDPageContentStream content = new PDPageContentStream(pdf, page);
		content.drawImage(image, 20f, 20f);
		
		content.beginText();				//begin ve end metotları arasında yaptıracağımız işlemleri yazıyoruz
		
		content.setFont(PDType1Font.TIMES_ROMAN, 12);
		content.setLeading(14.5f);
		content.newLineAtOffset(20, 750);
		content.showText("Hello everyone, what a wonderful day, right?");
		

		
		content.endText();
		content.close();
		pdf.save(new File("/Users/gozde/Desktop/Coding/01-BilgeAdam_Boost/PDFBoxExample/imageExample.pdf"));
		
	}

	private void createPDF() throws Exception {
		
			@Cleanup 
			PDDocument pdf = new PDDocument();   //pdf belgesi yaratıldı	
			PDPage page = new PDPage();          //sayfa yaratıldı
			pdf.addPage(page);				     //yaratılan sayfa belgeye ekleniyor
			
			@Cleanup 
			PDPageContentStream content = new PDPageContentStream(pdf, page);
			content.beginText();				//begin ve end metotları arasında yaptıracağımız işlemleri yazıyoruz
			
			content.setFont(PDType1Font.TIMES_ROMAN, 12);
			content.setLeading(14.5f);
			content.newLineAtOffset(20, 750);
			content.showText("Hello everyone, what a wonderful day, right?");
			
			content.endText();
			content.close();
			pdf.save(new File("/Users/gozde/Desktop/Coding/01-BilgeAdam_Boost/PDFBoxExample/gozde.pdf"));
		
		
	}

}
