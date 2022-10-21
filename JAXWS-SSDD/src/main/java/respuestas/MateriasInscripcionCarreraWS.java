package respuestas;

import java.util.List;

public class MateriasInscripcionCarreraWS {
	
	private String error;
	private String estado;
	private List<MateriaInscripcionCarreraWS> materiasIncripcionCarrera;
	
	public MateriasInscripcionCarreraWS(String error, String estado) {
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

	public List<MateriaInscripcionCarreraWS> getMateriasIncripcionCarrera() {
		return materiasIncripcionCarrera;
	}

	public void setMateriasIncripcionCarrera(List<MateriaInscripcionCarreraWS> materiasIncripcionCarrera) {
		this.materiasIncripcionCarrera = materiasIncripcionCarrera;
	}
	
}
