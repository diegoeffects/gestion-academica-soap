package respuestas;

public class MateriaInscripcionCarreraWS {
	
	private String idComision;
	private String materia;
	private String docente;
	private String descripcion;
	private String turno;
	
	public MateriaInscripcionCarreraWS(String idComision, String materia, String docente, String descripcion, String turno) {
		super();
		this.idComision = idComision;
		this.materia = materia;
		this.docente = docente;
		this.descripcion = descripcion;
		this.turno = turno;
	}

	public String getIdComision() {
		return idComision;
	}

	public void setIdComision(String idComision) {
		this.idComision = idComision;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getDocente() {
		return docente;
	}

	public void setDocente(String docente) {
		this.docente = docente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
	
}
