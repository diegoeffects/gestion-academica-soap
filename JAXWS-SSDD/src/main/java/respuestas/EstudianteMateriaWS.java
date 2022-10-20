package respuestas;

public class EstudianteMateriaWS {
	
	private int orden;
	private String apellido;
	private String nombre;
	private String dni;
	private String primerParcial;
	private String segundoParcial;
	private String tercerParcial;
	private String primerRecuperatorio;
	private String segundoRecuperatorio;
	private String tercerRecuperatorio;
	private String tp1;
	private String tp2;
	private String tp3;
	private String notaCursada;
	private String notaFinal;
	private String notaDefinitiva;
	
	public EstudianteMateriaWS(int orden, String apellido, String nombre, String dni, String primerParcial,
			String segundoParcial, String tercerParcial, String primerRecuperatorio, String segundoRecuperatorio,
			String tercerRecuperatorio, String tp1, String tp2, String tp3, String notaCursada, String notaFinal,
			String notaDefinitiva) {
		super();
		this.orden = orden;
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.primerParcial = primerParcial;
		this.segundoParcial = segundoParcial;
		this.tercerParcial = tercerParcial;
		this.primerRecuperatorio = primerRecuperatorio;
		this.segundoRecuperatorio = segundoRecuperatorio;
		this.tercerRecuperatorio = tercerRecuperatorio;
		this.tp1 = tp1;
		this.tp2 = tp2;
		this.tp3 = tp3;
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

	public String getTercerParcial() {
		return tercerParcial;
	}

	public void setTercerParcial(String tercerParcial) {
		this.tercerParcial = tercerParcial;
	}

	public String getPrimerRecuperatorio() {
		return primerRecuperatorio;
	}

	public void setPrimerRecuperatorio(String primerRecuperatorio) {
		this.primerRecuperatorio = primerRecuperatorio;
	}

	public String getSegundoRecuperatorio() {
		return segundoRecuperatorio;
	}

	public void setSegundoRecuperatorio(String segundoRecuperatorio) {
		this.segundoRecuperatorio = segundoRecuperatorio;
	}

	public String getTercerRecuperatorio() {
		return tercerRecuperatorio;
	}

	public void setTercerRecuperatorio(String tercerRecuperatorio) {
		this.tercerRecuperatorio = tercerRecuperatorio;
	}

	public String getTp1() {
		return tp1;
	}

	public void setTp1(String tp1) {
		this.tp1 = tp1;
	}

	public String getTp2() {
		return tp2;
	}

	public void setTp2(String tp2) {
		this.tp2 = tp2;
	}

	public String getTp3() {
		return tp3;
	}

	public void setTp3(String tp3) {
		this.tp3 = tp3;
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
