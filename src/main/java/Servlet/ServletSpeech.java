package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.BaseRecognizeCallback;

import Integracion.Speech;


/**
 * Servlet implementation class ServletSpeech
 */
@WebServlet("/ServletSpeech")
public class ServletSpeech extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SpeechResults transcript;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {		
		Speech sp=new Speech();
		 String texto = null;
		try {
			texto = sp.voz_a_texto();
		} catch (InterruptedException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		 
		 req.setAttribute("texto", texto);
		 RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
		 dispatcher.forward(req, resp);
	}

	private void response(HttpServletResponse resp, String msg) throws IOException {
			PrintWriter out = resp.getWriter();
			String txt="txtNombre";
			out.println("document.getElementById("+txt+").value = "+ msg);
	}
}
