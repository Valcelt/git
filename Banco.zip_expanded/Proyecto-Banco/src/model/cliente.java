package model;

public abstract class cliente extends persona {
	protected String cliCategoria;
	protected ejecutivo eje;

	public cliente() {	
	}

	public cliente(String cliCategoria, ejecutivo eje) {
		this.cliCategoria = cliCategoria;
		this.eje = eje;
	}

	public String getCliCategoria() {
		return cliCategoria;	
	}
	public void setCliCategoria(String cliCategoria) {
		this.cliCategoria = cliCategoria;	
	}
	public ejecutivo getEje() {	
		return eje;
	}
	public void setEje(ejecutivo eje) {
		this.eje = eje;
	}

	@Override
	public String toString() {
		return "cliente [cliCategoria=" + cliCategoria + ", eje=" + eje	+ ", perRut=" + perRut + ", perNombre="+ perNombre 
				+ ", perApePaterno=" + perApePaterno + ", perApeMaterno=" + perApeMaterno + ", perNacionalidad=" + perNacionalidad 
				+ ", perFecNacimiento=" + perFecNacimiento + "]";
	}
	
	


	

}
