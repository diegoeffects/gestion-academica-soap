package datos;

public class TipoUsuario {
	
	private int idTipoUsuario;
	private String tipoUsuario;
	
	public TipoUsuario() {} // CONSTRUCTOR HIBERNATE

	public TipoUsuario(String tipoUsuario) {
		super();
		this.tipoUsuario = tipoUsuario;
	}

	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public String toString() {
		return "TipoUsuario [idTipoUsuario=" + idTipoUsuario + ", tipoUsuario=" + tipoUsuario + "]";
	}
	
}
