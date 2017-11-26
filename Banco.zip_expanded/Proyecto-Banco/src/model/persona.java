package model;

public abstract class persona {
	protected String perRut;
	protected String perNombre;
	protected String perApePaterno;
	protected String perApeMaterno;
	protected String perNacionalidad;
	protected String perFecNacimiento;
	
	public persona() {	}

	public persona(String perRut, 
			String perNombre, 
			String perApePaterno, 
			String perApeMaterno, 
			String perNacionalidad,
			String perFecNacimiento) {
		this.perRut = perRut;
		this.perNombre = perNombre;
		this.perApePaterno = perApePaterno;
		this.perApeMaterno = perApeMaterno;
		this.perNacionalidad = perNacionalidad;
		this.perFecNacimiento = perFecNacimiento;
	}
	
	public persona(String perRut, String perNombre) {
		this.perRut = perRut;
		this.perNombre = perNombre;
	}

	public String getPerRut() {		return perRut;	}
	public void setPerRut(String perRut) {		this.perRut = perRut;	}
	public String getPerNombre() {		return perNombre;	}
	public void setPerNombre(String perNombre) {		this.perNombre = perNombre;	}
	public String getPerApePaterno() {		return perApePaterno;	}
	public void setPerApePaterno(String perApePaterno) {		this.perApePaterno = perApePaterno;	}
	public String getPerApeMaterno() {		return perApeMaterno;	}
	public void setPerApeMaterno(String perApeMaterno) {		this.perApeMaterno = perApeMaterno;	}
	public String getPerNacionalidad() {		return perNacionalidad;	}
	public void setPerNacionalidad(String perNacionalidad) {		this.perNacionalidad = perNacionalidad;	}
	public String getPerFecNacimiento() {		return perFecNacimiento;	}
	public void setPerFecNacimiento(String perFecNacimiento) {		this.perFecNacimiento = perFecNacimiento;	}

	@Override
	public String toString() {
		return "persona [perRut=" + perRut 
				+ ", perNombre=" + perNombre 
				+ ", perApePaterno=" + perApePaterno
				+ ", perApeMaterno=" + perApeMaterno 
				+ ", perNacionalidad=" + perNacionalidad 
				+ ", perFecNacimiento="	+ perFecNacimiento + "]";
	}
	
	
}
