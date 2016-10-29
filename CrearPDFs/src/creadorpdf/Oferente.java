package creadorpdf;

public class Oferente {
	
	private String Nombre;
	private String DNI;
	private String Monto;
	private String Horario;
	private String Telefono;
	
	Oferente(String name, String dni, String monto, String hs, String tel ){
		
		Nombre=name;
		DNI=dni;
		Monto=monto;
		Horario=hs;
		Telefono=tel;	
	}
	
	public String getNombre(){
		return this.Nombre;
	}
	public String getDNI(){
		return this.DNI;
	}
	public String getMonto(){
		return this.Monto;
	}
	public String getHorario(){
		return this.Horario;
	}
	public String getTelefono(){
		return this.Telefono;
	}

}
