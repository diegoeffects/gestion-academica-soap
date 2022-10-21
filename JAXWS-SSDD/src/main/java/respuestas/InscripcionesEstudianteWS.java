package respuestas;

import java.util.List;

public class InscripcionesEstudianteWS {
	
	private String error;
	private String estado;
	private List<InscripcionEstudianteWS> inscripcionesEstudiante;
	
	public InscripcionesEstudianteWS(String error, String estado) {
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

	public List<InscripcionEstudianteWS> getInscripcionesEstudiante() {
		return inscripcionesEstudiante;
	}

	public void setInscripcionesEstudiante(List<InscripcionEstudianteWS> inscripcionesEstudiante) {
		this.inscripcionesEstudiante = inscripcionesEstudiante;
	}
	
}
