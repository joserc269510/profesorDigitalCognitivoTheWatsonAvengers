package logicaDeNegocios;

import Integracion.BaseDeDatos;

public class Estudiante {
	
	public void registrarEstudiante(){
        BaseDeDatos conexion = new BaseDeDatos();
        conexion.insertDelete("insert into estudiante values ()");
	}
}
