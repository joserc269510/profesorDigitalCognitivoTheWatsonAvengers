package Integracion;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.BaseRecognizeCallback;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;



public class Speech 
{
	  String linea = null;
	  public void onTranscription(SpeechResults speechResults) {
	       System.out.println(speechResults);
	     }
	 
	  public String voz_a_texto() throws ServletException, IOException, InterruptedException, LineUnavailableException{
			SpeechToText s2t = new SpeechToText();
		   s2t.setUsernameAndPassword("4de7c2f3-a373-4f96-91c2-f4ae5f4fdf9d","dPdrXHg1ui6Q");
		   
		  int sampleRate = 16000;
		   AudioFormat format = new AudioFormat(sampleRate, 16, 1, true, false);
		   DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
		   
		   if (!AudioSystem.isLineSupported(info)) {
		     System.out.println("Line not supported");
		     System.exit(0);
		   }

		   TargetDataLine line = (TargetDataLine) AudioSystem.getLine(info);
		   line.open(format);
		   line.start();

		  
		
		   AudioInputStream audio2 = new AudioInputStream(line);

		   RecognizeOptions options = new RecognizeOptions.Builder().model("es-ES_NarrowbandModel")
		     .continuous(true)
		     .interimResults(true)
		     .inactivityTimeout(5) // use this to stop listening when the speaker pauses, i.e. for 5s
		     .contentType(HttpMediaType.AUDIO_RAW + "; rate=" + sampleRate)
		     .build();

		   s2t.recognizeUsingWebSocket(audio2, options, new BaseRecognizeCallback() {
		     @Override
		     public void onTranscription(SpeechResults speechResults) {
		       //System.out.println(speechResults);
		       System.out.println(speechResults.getResults().get(0).getAlternatives().get(0).getTranscript());
		       linea+=speechResults.getResults().get(0).getAlternatives().get(0).getTranscript();
		       
		     }
		   });

		   System.out.println("Listening to your voice for the next 30s...");
		   Thread.sleep(30 * 1000);

		   // closing the WebSockets underlying InputStream will close the WebSocket itself.
		   line.stop();
		   line.close();

		   System.out.println("Fin.");
		return linea;
		
		    
		   
		   //return results.getResults().get(0).getAlternatives().get(0).getTranscript();
		
		   
		 }
	 
		/* public static void main(String[] args) throws ServletException, IOException, InterruptedException, LineUnavailableException {
			 Speech ss = new Speech();
			 ss.voz_a_texto();
		}*/
		 
	 private static final long serialVersionUID = 1L;

}
