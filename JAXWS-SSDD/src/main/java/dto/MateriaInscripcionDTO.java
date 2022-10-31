package dto;

public class MateriaInscripcionDTO {
	
	private int idMateria;
	private String materia;
	private String comision;
	private String docente;
	private String horarioCursada;
	private String fechaMesa;
	private int anioCarrera;
	
	public MateriaInscripcionDTO(int idMateria, String materia, String comision, String docente, String horarioCursada, String fechaMesa, int anioCarrera) {
		super();
		this.idMateria = idMateria;
		this.materia = materia;
		this.comision = comision;
		this.docente = docente;
		this.horarioCursada = horarioCursada;
		this.fechaMesa = fechaMesa;
		this.anioCarrera = anioCarrera;
	}

	public int getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getComision() {
		return comision;
	}

	public void setComision(String comision) {
		this.comision = comision;
	}

	public String getDocente() {
		return docente;
	}

	public void setDocente(String docente) {
		this.docente = docente;
	}

	public String getHorarioCursada() {
		return horarioCursada;
	}

	public void setHorarioCursada(String horarioCursada) {
		this.horarioCursada = horarioCursada;
	}

	public String getFechaMesa() {
		return fechaMesa;
	}

	public void setFechaMesa(String fechaMesa) {
		this.fechaMesa = fechaMesa;
	}

	public int getAnioCarrera() {
		return anioCarrera;
	}

	public void setAnioCarrera(int anioCarrera) {
		this.anioCarrera = anioCarrera;
	}
	
	public int compareTo(MateriaInscripcionDTO o){
	     return(anioCarrera - o.anioCarrera);
	}
	
}
