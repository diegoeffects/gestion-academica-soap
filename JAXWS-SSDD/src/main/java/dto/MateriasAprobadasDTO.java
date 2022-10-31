package dto;

import java.util.List;

public class MateriasAprobadasDTO {
	
	private String error;
	private String estado;
	private String estudiante;
	private String carrera;
	private List<MateriaAprobadaDTO> materiasAprobadas;
	
	public MateriasAprobadasDTO(String error, String estado, String estudiante, String carrera) {
		super();
		this.error = error;
		this.estado = estado;
		this.estudiante = estudiante;
		this.carrera = carrera;
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

	public String getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(String estudiante) {
		this.estudiante = estudiante;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public List<MateriaAprobadaDTO> getMateriasAprobadas() {
		return materiasAprobadas;
	}

	public void setMateriasAprobadas(List<MateriaAprobadaDTO> materiasAprobadas) {
		this.materiasAprobadas = materiasAprobadas;
	}
	
}
