package dto;

import java.util.List;

public class InscripcionesDTO {
	
	private String error;
	private String estado;
	private List<InscripcionDTO> inscripciones;
	
	public InscripcionesDTO(String error, String estado) {
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

	public List<InscripcionDTO> getInscripciones() {
		return inscripciones;
	}

	public void setInscripciones(List<InscripcionDTO> inscripciones) {
		this.inscripciones = inscripciones;
	}
	
}
