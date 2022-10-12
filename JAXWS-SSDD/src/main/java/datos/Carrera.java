package datos;

public class Carrera {
	
	private int idCarrera;
	private String carrera;
	
	public Carrera() {} // CONSTRUCTOR HIBERNATE

	public Carrera(String carrera) {
		super();
		this.carrera = carrera;
	}

	public int getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	@Override
	public String toString() {
		return "Carrera [idCarrera=" + idCarrera + ", carrera=" + carrera + "]";
	}
	
}
