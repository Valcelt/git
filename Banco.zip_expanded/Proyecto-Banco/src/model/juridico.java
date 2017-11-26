package model;

public final class juridico extends cliente{
	private String jurRazSocial;
	/**
	 * 
	 */
	public juridico() {
	}
	/**
	 * @param cliCategoria
	 * @param eje
	 * @param jurRazSocial
	 */
	 
	public juridico(String cliCategoria, ejecutivo eje, String jurRazSocial) {
		this.jurRazSocial = jurRazSocial;
	}
	public String getJurRazSocial() {
		return jurRazSocial;
	}
	public void setJurRazSocial(String jurRazSocial) {
		this.jurRazSocial = jurRazSocial;
	}
	@Override
	public String toString() {
		return "juridico [jurRazSocial=" + jurRazSocial + ", cliCategoria=" + cliCategoria + ", eje=" + eje
				+ ", perRut=" + perRut + ", perNombre=" + perNombre + ", perApePaterno=" + perApePaterno
				+ ", perApeMaterno=" + perApeMaterno + ", perNacionalidad=" + perNacionalidad + ", perFecNacimiento="
				+ perFecNacimiento + "]";
	}


}
