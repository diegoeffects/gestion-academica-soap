package datos;

public class Materia {
	
	private int idMateria;
	private Carrera carrera;
	private String materia;
	private int anioCarrera;
	
	public Materia() {} // CONSTRUCTOR HIBERNATE

	public Materia(Carrera carrera, String materia, int anioCarrera) {
		super();
		this.carrera = carrera;
		this.materia = materia;
		this.anioCarrera = anioCarrera;
	}

	public int getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public int getAnioCarrera() {
		return anioCarrera;
	}

	public void setAnioCarrera(int anioCarrera) {
		this.anioCarrera = anioCarrera;
	}

	@Override
	public String toString() {
		return "Materia [idMateria=" + idMateria + ", carrera=" + carrera + ", materia=" + materia + ", anioCarrera="
				+ anioCarrera + "]";
	}
	
}
