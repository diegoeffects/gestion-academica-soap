package datos;

public class Inscripcion {
	
	private int idInscripcion;
	private Instancia instancia;
	private String descripcion;
	private String desde;
	private String hasta;
	private String fechaInicio;
	private String fechaFin;
	private String anio;
	
	public Inscripcion() {} // CONSTRUCTOR HIBERNATE

	public Inscripcion(Instancia instancia, String descripcion, String desde, String hasta, String fechaInicio,
			String fechaFin, String anio) {
		super();
		this.instancia = instancia;
		this.descripcion = descripcion;
		this.desde = desde;
		this.hasta = hasta;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.anio = anio;
	}

	public int getIdInscripcion() {
		return idInscripcion;
	}

	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
	}

	public Instancia getInstancia() {
		return instancia;
	}

	public void setInstancia(Instancia instancia) {
		this.instancia = instancia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDesde() {
		return desde;
	}

	public void setDesde(String desde) {
		this.desde = desde;
	}

	public String getHasta() {
		return hasta;
	}

	public void setHasta(String hasta) {
		this.hasta = hasta;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	@Override
	public String toString() {
		return "Inscripcion [idInscripcion=" + idInscripcion + ", instancia=" + instancia + ", descripcion="
				+ descripcion + ", desde=" + desde + ", hasta=" + hasta + ", fechaInicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + ", anio=" + anio + "]";
	}
	
}
