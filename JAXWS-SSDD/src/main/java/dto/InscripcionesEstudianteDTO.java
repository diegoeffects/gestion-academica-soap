package dto;

import java.util.List;

public class InscripcionesEstudianteDTO {
	
	private String error;
	private String estado;
	private List<InscripcionEstudianteDTO> inscripcionesEstudiante;
	
	public InscripcionesEstudianteDTO(String error, String estado) {
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

	public List<InscripcionEstudianteDTO> getInscripcionesEstudiante() {
		return inscripcionesEstudiante;
	}

	public void setInscripcionesEstudiante(List<InscripcionEstudianteDTO> inscripcionesEstudiante) {
		this.inscripcionesEstudiante = inscripcionesEstudiante;
	}
	
}
