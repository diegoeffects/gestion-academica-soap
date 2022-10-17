package datos;

public class TipoNota {
	
	private int idTipoNota;
	private String tipoNota;
	
	public TipoNota() {} // CONSTRUCTOR HIBERNATE

	public TipoNota(int idTipoNota, String tipoNota) {
		super();
		this.idTipoNota = idTipoNota;
		this.tipoNota = tipoNota;
	}

	public int getIdTipoNota() {
		return idTipoNota;
	}

	public void setIdTipoNota(int idTipoNota) {
		this.idTipoNota = idTipoNota;
	}

	public String getTipoNota() {
		return tipoNota;
	}

	public void setTipoNota(String tipoNota) {
		this.tipoNota = tipoNota;
	}

	@Override
	public String toString() {
		return "TipoNota [idTipoNota=" + idTipoNota + ", tipoNota=" + tipoNota + "]";
	}
	
}
