package Integracion;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.BaseRecognizeCallback;

public class Speech {
	
	SpeechResults transcript;

	public String voz_a_texto() throws LineUnavailableException, InterruptedException
	{
		
		String texto;
		int sampleRate = 16000;
		
		SpeechToText s2t = new SpeechToText();
		/*s2t.setUsernameAndPassword("4a76e4e6-2f33-424f-a847-c06e5d3551f0", "tJwskp6qa47O");*/
		s2t.setUsernameAndPassword("c0e1dc84-14d0-41e2-b673-ca20b419cb5a", "qqrtXDD5YO0f");

		 AudioFormat format = new AudioFormat(sampleRate, 16, 1, true, false);
		 DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
		 if (!AudioSystem.isLineSupported(info))
		 {
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
		     .contentType(HttpMediaType.AUDIO_RAW + "; rate=" + sampleRate)
		     .build();
	        
		s2t.recognizeUsingWebSocket(audio2, options, new BaseRecognizeCallback() 
		{
			public void onTranscription(SpeechResults speechResults) 
			{
		    transcript=speechResults;
		       //System.out.println(speechResults);
		
		     }
		});

		System.out.println("Listening to your voice for the next 30s...");
		Thread.sleep(5 * 1000);

		   
   	   	texto=transcript.getResults().get(0).getAlternatives().get(0).getTranscript();
		 // closing the WebSockets underlying InputStream will close the WebSocket itself.
		 line.stop();
		 line.close();
		 System.out.println("Fin.");
		   
		 return texto;
	}
}
