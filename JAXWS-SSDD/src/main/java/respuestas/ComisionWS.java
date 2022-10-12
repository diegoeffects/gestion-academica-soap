package respuestas;

public class ComisionWS {
	
	private int idComision;
	private String materia;
	private String docente;
	private String descripcion;
	private String turno;
	
	public ComisionWS(int idComision, String materia, String docente, String descripcion, String turno) {
		super();
		this.idComision = idComision;
		this.materia = materia;
		this.docente = docente;
		this.descripcion = descripcion;
		this.turno = turno;
	}

	public int getIdComision() {
		return idComision;
	}

	public void setIdComision(int idComision) {
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

	@Override
	public String toString() {
		return "ComisionWS [idComision=" + idComision + ", materia=" + materia + ", docente=" + docente
				+ ", descripcion=" + descripcion + ", turno=" + turno + "]";
	}
	
}
