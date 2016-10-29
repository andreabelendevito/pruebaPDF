package creadorpdf;

import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class FirstPdf {
        private static String FILE = "/home/army/Escritorio/SecondPdf.pdf";
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
                        
                        document.open(); //abro el documento
                        
                        addMetaData(document); //propiedades del documento
                        
                        
                        addTitlePage(document); // titulo y primer linea
                        
                        //Creo una lista de Strings con los datos de todos los oferentes 
                        
                     
                        addContent(document);
                        
                        document.close();
                        
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

       
        private static void addMetaData(Document document) {
                
        	 // iText allows to add metadata to the PDF which can be viewed in your Adobe
            // Reader
            // under File -> Properties
            
        	
        		document.addTitle("Comprobante asignación sala de ensayo");
                document.addSubject("Reserva al mejor postor");
                document.addKeywords("ofertas, adjudicacion, licitar");
                document.addAuthor("Funes y Devito");
                document.addCreator("Funes y Devito");
        }

        private static void addTitlePage(Document document)
                        throws DocumentException {
                Paragraph preface = new Paragraph();
                
                preface.add(new Paragraph("Comprobante asignación sala de ensayo", catFont));

                Date hoy= new Date();
        		String miFecha= DateAFecha(hoy);
                
                preface.add(new Paragraph("Se extiende comprobante a: " + System.getProperty("user.name") + ", el dia" + miFecha, smallBold));
                

                document.add(preface);
                // Start a new page
                //document.newPage();
        }

        private static void addContent(Document document) throws DocumentException {
                
        	Anchor anchor = new Anchor("", catFont);
                
            Paragraph Paragrafo = new Paragraph("", subFont);
                
            Chapter Capitulo = new Chapter(Paragrafo, 0);

                
            Section Seccion = Capitulo.addSection(Paragrafo);
                

                
            createTable(Seccion);

            // now add all this to the document
            document.add(Capitulo);

        }

        private static void createTable(Section subCatPart)
                        throws BadElementException {
                PdfPTable table = new PdfPTable(5);

               
                PdfPCell c1 = new PdfPCell(new Phrase("Oferente"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("Horario"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("DNI"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                table.setHeaderRows(1);
                
                c1 = new PdfPCell(new Phrase("Monto"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                table.setHeaderRows(1);
                
                c1 = new PdfPCell(new Phrase("Telefono"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                table.setHeaderRows(1);
                
                
                //Recibo una lista de Strings y los meto en las celdas
                
                Oferente[] offers= generarListaOferentes();
                
                for(int i=0; i<offers.length-1; i++){
                	
                	rellenarOfferATabla(offers[i], table );
                }
                
                subCatPart.add(table);

        }

        private static void addEmptyLine(Paragraph paragraph, int number) {
                for (int i = 0; i < number; i++) {
                        paragraph.add(new Paragraph(" "));
                }
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

        public static Oferente[] generarListaOferentes(){
        	
        	Oferente of1= new Oferente("Belu","12345858","200$","10 a 15 hs", "4668-4893");
        	
        	Oferente of2= new Oferente("Maria","35021693","600$","11 a 15 hs", "4667-4892");
        	
        	Oferente of3= new Oferente("Luis","1234567","350$","19 a 22 hs", "4651-4891");
        	
        	Oferente of4= new Oferente("Daniel","98765432","987$","08 a 17 hs", "4347-4894");
        	
        	Oferente of5= new Oferente("Jorge","15935741","1000$","01 a 02 hs", "4689-4895");
        	
        	Oferente of6= new Oferente("Jesica","95175363","110$","03 a 07 hs", "4451-4896");
        	
        	Oferente of7= new Oferente("Leandro","58972636","624$","13 a 14 hs", "4666-4897");
        	
        	
        	
        	//los cargo en una lista
        	
        	Oferente[] offers= new Oferente[8];
        	
        	//cargo los oferentes en la lista
        	
        	offers[0]=of1; offers[1]=of2;offers[2]=of3; offers[3]=of4;offers[4]=of5; offers[5]=of6; offers[6]=of7;
        	
        	return offers;
        	
        }

        public static void rellenarOfferATabla(Oferente offer, PdfPTable tabla ){
        	
        	tabla.addCell(offer.getNombre());
            tabla.addCell(offer.getHorario());
            tabla.addCell(offer.getDNI());
            tabla.addCell(offer.getMonto());
            tabla.addCell(offer.getTelefono());
        		
        }


        public void crearElementosNecesarios(){
        	Anchor anchor = new Anchor("", catFont);
            Chapter Capitulo = new Chapter(new Paragraph(anchor), 0);

            Paragraph Paragrafo = new Paragraph("", subFont);
            Section Seccion = Capitulo.addSection(Paragrafo);
            
        }



}