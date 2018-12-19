import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ec.edu.ups.proyectoFinal.entidad.Docente;
import ec.edu.ups.proyectoFinal.logica.Registro;

public class Principal {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Registro r = new Registro();
		SimpleDateFormat formato= new SimpleDateFormat( "yyyy-MM-dd");
		Docente d = new Docente("0105432017", "Sagbay", "Jefferson", "jeffersonsagbay@gmail.com",
				"asdfghjkl", "0983139122", formato.parse("1995-10-24"), "fisica");

		r.agregarDocente(d);
		Docente d1 = new Docente("0105432025", "Sagbay", "Jefferson", "jeffersonsagbay@gmail.com",
				"asdfghjkl", "0983139122", formato.parse("1995-10-24"), "fisica");

		r.agregarDocente(d1);
		for (int i = 0; i < r.docenteList.size(); i++) {
			System.out.println(r.docenteList.get(i).toString());
		}
	

	}

}
