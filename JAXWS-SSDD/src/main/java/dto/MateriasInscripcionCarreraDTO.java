package dto;

import java.util.List;

public class MateriasInscripcionCarreraDTO {
	
	private String error;
	private String estado;
	private List<MateriaInscripcionCarreraDTO> materiasIncripcionCarrera;
	
	public MateriasInscripcionCarreraDTO(String error, String estado) {
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

	public List<MateriaInscripcionCarreraDTO> getMateriasIncripcionCarrera() {
		return materiasIncripcionCarrera;
	}

	public void setMateriasIncripcionCarrera(List<MateriaInscripcionCarreraDTO> materiasIncripcionCarrera) {
		this.materiasIncripcionCarrera = materiasIncripcionCarrera;
	}
	
}
