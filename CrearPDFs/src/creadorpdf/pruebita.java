package creadorpdf;
import java.util.Date;

public class pruebita {

	public static void main(String[] args) {
		
		System.out.println(new Date());
		Date hoy= new Date();
		String miFecha= DateAFecha(hoy);
		System.out.println(miFecha);
		
		

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
