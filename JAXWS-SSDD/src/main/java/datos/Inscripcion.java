package datos;

public class Inscripcion {
	
	private int idInscripcion;
	private Instancia instancia;
	private String descripcion;
	private String desde;
	private String hasta;
	private String fecha;
	private String fechaCierre;
	private String anio;
	
	public Inscripcion() {} // CONSTRUCTOR HIBERNATE

	public Inscripcion(Instancia instancia, String descripcion, String desde, String hasta, String fecha,
			String fechaCierre, String anio) {
		super();
		this.instancia = instancia;
		this.descripcion = descripcion;
		this.desde = desde;
		this.hasta = hasta;
		this.fecha = fecha;
		this.fechaCierre = fechaCierre;
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(String fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	@Override
	public String toString() {
		return "Inscripcion [idInscripcion=" + idInscripcion + ", descripcion=" + descripcion + ", desde=" + desde
				+ ", hasta=" + hasta + ", fecha=" + fecha + ", fechaCierre=" + fechaCierre + ", anio=" + anio + "]";
	}
	
}
