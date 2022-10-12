package respuestas;

public class EstudianteCarreraWS {
	
	private int idEstudiante;
	private String estudiante;
	private String carrera;
	
	public EstudianteCarreraWS(int idEstudiante, String estudiante, String carrera) {
		super();
		this.idEstudiante = idEstudiante;
		this.estudiante = estudiante;
		this.carrera = carrera;
	}
	
	public int getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
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
	
}
