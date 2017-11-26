package model;

public final class cuenta {
	private Integer cueId;
	private Integer cueSaldo;
	private String cueFecApertura;
	private String cueEstado;
	private int cueSobregiro;
	private cliente cli;
	
	public cuenta(cliente cli) {
		this.cli = cli;	
	}

	public cuenta(Integer cueId, Integer cueSaldo, String cueFecApertura, String cueEstado, int cueSobregiro,cliente cli) {
		this.cueId = cueId;
		this.cueSaldo = cueSaldo;
		this.cueFecApertura = cueFecApertura;
		this.cueEstado = cueEstado;
		this.cueSobregiro = cueSobregiro;
		this.cli = cli;
	}

	public Integer getCueId() {
		return cueId;	
	}
	public void setCueId(Integer cueId) {
		this.cueId = cueId;	
		}
	public Integer getCueSaldo() {
		return cueSaldo;
	}
	public void setCueSaldo(Integer cueSaldo) {
		this.cueSaldo = cueSaldo;
	}
	public String getCueFecApertura() {
		return cueFecApertura;
	}
	public void setCueFecApertura(String cueFecApertura) {
		this.cueFecApertura = cueFecApertura;
	}
	public String getCueEstado() {
		return cueEstado;
	}
	public void setCueEstado(String cueEstado) {
		this.cueEstado = cueEstado;
	}
	public int getCueSobregiro() {
		return cueSobregiro;
	}
	public void setCueSobregiro(int cueSobregiro) {
		this.cueSobregiro = cueSobregiro;
	}
	public cliente getCli() {
		return cli;
	}
	public void setCli(cliente cli) {
		this.cli = cli;
	}

	@Override
	public String toString() {
		return "cuenta [cueId=" + cueId + ", cueSaldo=" + cueSaldo + ", cueFecApertura=" + cueFecApertura
				+ ", cueEstado=" + cueEstado + ", cueSobregiro=" + cueSobregiro + ", cli=" + cli + "]";
	}
	
}
