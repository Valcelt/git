package model;

public final class natural extends cliente {
	private Integer natPatrimonio;

	public natural() {
	}

	public natural(String cliCategoria, ejecutivo eje, Integer natPatrimonio) {
		this.natPatrimonio = natPatrimonio;
	}
	public Integer getNatPatrimonio() {
		return natPatrimonio;
	}
	public void setNatPatrimonio(Integer natPatrimonio) {
		this.natPatrimonio = natPatrimonio;	
	}

	@Override
	public String toString() {
		return "natural [natPatrimonio=" + natPatrimonio + ", cliCategoria=" + cliCategoria + ", eje=" + eje+ ", perRut="
				+ perRut + ", perNombre=" + perNombre + ", perApePaterno=" + perApePaterno + ", perApeMaterno=" + perApeMaterno 
				+ ", perNacionalidad=" + perNacionalidad + ", perFecNacimiento="	+ perFecNacimiento + "]";
	}
	
	
	
}
