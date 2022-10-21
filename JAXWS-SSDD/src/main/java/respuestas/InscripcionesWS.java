package respuestas;

import java.util.List;

public class InscripcionesWS {
	
	private String error;
	private String estado;
	private List<InscripcionWS> inscripciones;
	
	public InscripcionesWS(String error, String estado) {
		super();
		this.error = error;
		this.estado = estado;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<InscripcionWS> getInscripciones() {
		return inscripciones;
	}

	public void setInscripciones(List<InscripcionWS> inscripciones) {
		this.inscripciones = inscripciones;
	}
	
}
