package respuestas;

public class HistorialAcademicoWS {
	
	private String materia;
	private String docente;
	private int nota;
	private String fecha;

	public HistorialAcademicoWS(String materia, String docente, int nota, String fecha) {
		super();
		this.materia = materia;
		this.docente = docente;
		this.nota = nota;
		this.fecha = fecha;
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

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
}
