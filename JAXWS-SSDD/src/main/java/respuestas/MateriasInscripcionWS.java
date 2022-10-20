package respuestas;

import java.util.List;

public class MateriasInscripcionWS {
	
	private String error;
	private String estado;
	private String carrera;
	private String descripcion;
	private String idInstancia;
	private String instancia;
	private String turno;
	private List<MateriaInscripcionWS> materiasInscripcion;
	
	public MateriasInscripcionWS(String error, String estado, String carrera, String descripcion, String idInstancia,
			String instancia, String turno) {
		super();
		this.error = error;
		this.estado = estado;
		this.carrera = carrera;
		this.descripcion = descripcion;
		this.idInstancia = idInstancia;
		this.instancia = instancia;
		this.turno = turno;
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

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIdInstancia() {
		return idInstancia;
	}

	public void setIdInstancia(String idInstancia) {
		this.idInstancia = idInstancia;
	}

	public String getInstancia() {
		return instancia;
	}

	public void setInstancia(String instancia) {
		this.instancia = instancia;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public List<MateriaInscripcionWS> getMateriasInscripcion() {
		return materiasInscripcion;
	}

	public void setMateriasInscripcion(List<MateriaInscripcionWS> materiasInscripcion) {
		this.materiasInscripcion = materiasInscripcion;
	}
	
}
