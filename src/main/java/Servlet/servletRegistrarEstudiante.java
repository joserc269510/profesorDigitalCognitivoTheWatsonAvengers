package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicaDeNegocios.Estudiante;

/**
 * Servlet implementation class servletRegistrarEstudiante
 */
@WebServlet("/servletRegistrarEstudiante")
public class servletRegistrarEstudiante extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numeroIdentificacion= request.getParameter("txtIdentificacion");
	   	 String numeroCarnet= request.getParameter("txtCarnet"); 
	   	 String fechaNacimiento =request.getParameter("txtNacimiento");
	   	 String apellido1=request.getParameter("txtApellido1") ;
	   	 String apellido2= request.getParameter("txtApellido2");
	   	 String nombre= request.getParameter("txtNombre");
	   	 String email= request.getParameter("txtEmail");
	   	 
	   Estudiante estudiante= new Estudiante();
	   estudiante.registrarEstudiante(numeroIdentificacion, numeroCarnet, fechaNacimiento, apellido1, apellido2, nombre, email);
	 
	   response.setContentType("text/html");
	}

}
