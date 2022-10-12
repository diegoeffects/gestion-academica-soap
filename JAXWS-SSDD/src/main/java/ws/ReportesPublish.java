package ws;

import javax.xml.ws.*;

public class ReportesPublish {

	public static void main(String[] args) {
		
		Endpoint.publish("http://localhost:1515/ws/reportes", new ReportesImpl());

	}

}
