package datos;

public class NotaComision {
	
	private int idNotaComision;
	private Comision comision;
	private Usuario usuario;
	private TipoNota tipoNota;
	private int nota;
	private String fecha;
	
	public NotaComision() {} // CONSTRUCTOR HIBERNATE

	public NotaComision(Comision comision, Usuario usuario, TipoNota tipoNota, int nota,
			String fecha) {
		super();
		this.comision = comision;
		this.usuario = usuario;
		this.tipoNota = tipoNota;
		this.nota = nota;
		this.fecha = fecha;
	}

	public int getIdNotaComision() {
		return idNotaComision;
	}

	public void setIdNotaComision(int idNotaComision) {
		this.idNotaComision = idNotaComision;
	}

	public Comision getComision() {
		return comision;
	}

	public void setComision(Comision comision) {
		this.comision = comision;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoNota getTipoNota() {
		return tipoNota;
	}

	public void setTipoNota(TipoNota tipoNota) {
		this.tipoNota = tipoNota;
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

	@Override
	public String toString() {
		return "NotaComision [idNotaComision=" + idNotaComision + ", comision=" + comision + ", usuario=" + usuario
				+ ", nota=" + nota + ", fecha=" + fecha + "]";
	}
	
}
