package dto;

public class EstudianteMateriaDTO {
	
	private int orden;
	private String apellido;
	private String nombre;
	private String dni;
	private String primerParcial;
	private String segundoParcial;
	private String notaCursada;
	private String notaFinal;
	private String notaDefinitiva;
	
	public EstudianteMateriaDTO(int orden, String apellido, String nombre, String dni, String primerParcial,
			String segundoParcial, String notaCursada, String notaFinal,
			String notaDefinitiva) {
		super();
		this.orden = orden;
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.primerParcial = primerParcial;
		this.segundoParcial = segundoParcial;
		this.notaCursada = notaCursada;
		this.notaFinal = notaFinal;
		this.notaDefinitiva = notaDefinitiva;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPrimerParcial() {
		return primerParcial;
	}

	public void setPrimerParcial(String primerParcial) {
		this.primerParcial = primerParcial;
	}

	public String getSegundoParcial() {
		return segundoParcial;
	}

	public void setSegundoParcial(String segundoParcial) {
		this.segundoParcial = segundoParcial;
	}

	public String getNotaCursada() {
		return notaCursada;
	}

	public void setNotaCursada(String notaCursada) {
		this.notaCursada = notaCursada;
	}

	public String getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(String notaFinal) {
		this.notaFinal = notaFinal;
	}

	public String getNotaDefinitiva() {
		return notaDefinitiva;
	}

	public void setNotaDefinitiva(String notaDefinitiva) {
		this.notaDefinitiva = notaDefinitiva;
	}
	
}
