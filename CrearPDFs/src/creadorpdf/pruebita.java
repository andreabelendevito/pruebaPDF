package creadorpdf;
import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class pruebita {
	
	private static String FILE = "/home/army/Escritorio/otroPDF.pdf";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
                    Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
                    Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
                    Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 5,
                    Font.BOLD);

	public static void main(String[] args) {
		
		try {
            Document document = new Document();//creo un nuevo documento
            
            //FILE ES EL PATH LA RUTA DONDE SE CREARA EL PDF
            PdfWriter.getInstance(document, new FileOutputStream(FILE));//creo un nuevo FOS para escribir el archivo
            
            document.open(); //abro el documento
            
            addTitlePage(document);
//            Chapter capitulo= new Chapter(1);
//            document.add(capitulo);
//            Paragraph parrafo= new Paragraph();
//            document.add(parrafo);
//            
//            Section seccion= capitulo.addSection(parrafo);
//            document.add(seccion);
//            
//            crearTabla(seccion);
            agregarContenido(document);
            
            document.close();
            
        } 
		catch (Exception e) {
            e.printStackTrace();
        }       
   
		
		
		
		
		
		
		
		
}
	private static void addTitlePage(Document document)
            throws DocumentException {
    Paragraph preface = new Paragraph();
    
    preface.add(new Paragraph("Comprobante asignación sala de ensayo", catFont));

    Date hoy= new Date();
	String miFecha= DateAFecha(hoy);
    
    preface.add(new Paragraph("Se extiende comprobante a: " + System.getProperty("user.name") + ", el dia" + miFecha, smallBold));
   
    document.add(preface);
    
}
	
	
	
	
	public static void crearTabla (Section unaSeccion) throws BadElementException {
		PdfPTable table = new PdfPTable(3); //creo una tabla de 3 col y 3 fil
		
		PdfPCell c1 = new PdfPCell(new Phrase("Oferente"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Horario"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Beneficio"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);
        
        table.addCell("1.0");
        table.addCell("1.1");
        table.addCell("1.2");
        table.addCell("2.1");
        table.addCell("2.2");
        table.addCell("2.3");

        
        unaSeccion.add(table);
        
        
	}
	private static void agregarContenido(Document document) throws DocumentException {
		
		Chapter capitulo= new Chapter(1);
		document.add(capitulo);
        Paragraph parrafo= new Paragraph();
        document.add(parrafo);
        
        Section seccion= capitulo.addSection(parrafo);
        document.add(seccion);
        
        crearTabla(seccion);
        
        document.close();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	public static String DateAFecha(Date date){
		
		Date unaFecha=date;
		String diaSem;
			if(unaFecha.getDay()==0)
				diaSem="Domingo";
			else if(unaFecha.getDay()==1)
				diaSem="Lunes";
			else if(unaFecha.getDay()==2)
				diaSem="Martes";
			else if (unaFecha.getDay()==3)
				diaSem="Miercoles";
			else if(unaFecha.getDay()==4)
				diaSem="Jueves";
			else if(unaFecha.getDay()==5)
				diaSem="Viernes";
			else
				diaSem="Sabado";
		
		String mes;
			if(unaFecha.getMonth()==0)
				mes="Enero";
			else if(unaFecha.getMonth()==1)
				mes="Febrero";
			else if(unaFecha.getMonth()==2)
				mes="Marzo";
			else if(unaFecha.getMonth()==3)
				mes="Abril";
			else if(unaFecha.getMonth()==4)
				mes="Mayo";
			else if(unaFecha.getMonth()==5)
				mes="Junio";
			else if(unaFecha.getMonth()==6)
				mes="Julio";
			else if(unaFecha.getMonth()==7)
				mes="Agosto";
			else if(unaFecha.getMonth()==8)
				mes="Septiembre";
			else if(unaFecha.getMonth()==9)
				mes="Octubre";
			else if(unaFecha.getMonth()==10)
				mes="Noviembre";
			else 
				mes="Diciembre";
		
				
				
				
		int diaNum= unaFecha.getDate(); //de 1 a 31
		int hs= unaFecha.getHours(); //0 a 23
		int min= unaFecha.getMinutes(); // 0 a 59
		int seg= unaFecha.getSeconds(); 
		
		int año=unaFecha.getYear()+1900;
		
		String fechaRet=diaSem+ " "+ diaNum+ " de "+ mes+ " a las " + hs +":"+min+":"+seg+ " hs"+ " ARG "+ año;
		return fechaRet;		
		
	}

}
