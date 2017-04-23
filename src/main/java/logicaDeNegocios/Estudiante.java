package logicaDeNegocios;

import Integracion.BaseDeDatos;

public class Estudiante {
	
	private String numeroIdentificacion;
	private String numeroCarnet; 
	private String fechaNacimiento;
	private String apellido1;
	private String apellido2;
	private String nombre;
	private String email;	
	
	public void registrarEstudiante(String pNumeroIdentificacion, String pNumeroCarnet, String pFechaNacimiento, String pApellido1,
			String pApellido2, String pNombre, String pEmail)
	{
        
		setNumeroIdentificacion(pNumeroIdentificacion);
		setNumeroCarnet(pNumeroCarnet);
		setNombre(pNombre);
		setApellido1(pApellido1);
		setApellido2(pApellido2);
		setFechaNacimiento(pFechaNacimiento);
		setEmail(pEmail);
		
		BaseDeDatos conexion = new BaseDeDatos();
        conexion.insertDelete("insert into estudiante values (pNumeroIdentificacion,pNombre,pApellido1,pApellido2,pNumeroCarnet,pFechaNacimiento,pEmail)" );
	}
	
	// Métodos get y set
	public String getNumeroIdentificacion() 
	{
		return numeroIdentificacion;
	}
	public void setNumeroIdentificacion(String pNumeroIdentificacion) 
	{
		numeroIdentificacion = pNumeroIdentificacion;
	}
	public String getNumeroCarnet() 
	{
		return numeroCarnet;
	}
	public void setNumeroCarnet(String pNumeroCarnet) 
	{
		numeroCarnet = pNumeroCarnet;
	}
	
	public String getFechaNacimiento() 
	{
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String pFechaNacimiento) 
	{
		fechaNacimiento = pFechaNacimiento;
	}
	public String getApellido1() 
	{
		return apellido1;
	}
	public void setApellido1(String pApellido1) 
	{
		apellido1 = pApellido1;
	}
	public String getApellido2() 
	{
		return apellido2;
	}
	
	public void setApellido2(String pApellido2) 
	{
		this.apellido2 = pApellido2;
	}
	
	public String getNombre() 
	{
		return nombre;
	}
	
	public void setNombre(String pNombre) 
	{
		this.nombre = pNombre;
	}
	
	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String pEmail) 
	{
		this.email = pEmail;
	}
}
