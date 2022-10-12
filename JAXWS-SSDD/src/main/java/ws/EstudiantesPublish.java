package ws;

import javax.xml.ws.*;

public class EstudiantesPublish {

	public static void main(String[] args) {
		
		Endpoint.publish("http://localhost:1515/ws/estudiantes", new EstudiantesImpl());

	}

}
