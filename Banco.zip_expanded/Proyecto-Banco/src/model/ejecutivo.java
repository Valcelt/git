package model;

public final class ejecutivo extends persona{
	private String ejeFecContrato;

	public ejecutivo() {		
			
	}

	public ejecutivo(String perRut, String perNombre, String perApePaterno, String perApeMaterno,
			String perNacionalidad, String perFecNacimiento, String ejeFecContrato) {
		this.ejeFecContrato = ejeFecContrato;
	}
	
	public ejecutivo(String perRut,String perNombre,String ejeFecContrato) {
		this.ejeFecContrato = ejeFecContrato;
	}

	public String getEjeFecContrato() {
		return ejeFecContrato;	
	}
	public void setEjeFecContrato(String ejeFecContrato) {		
		this.ejeFecContrato = ejeFecContrato;
	}

	@Override
	public String toString() {
		return "ejecutivo [ejeFecContrato=" + ejeFecContrato + ", perRut=" + perRut + ", perNombre=" + perNombre
				+ ", perApePaterno=" + perApePaterno + ", perApeMaterno=" + perApeMaterno + ", perNacionalidad="+ perNacionalidad 
				+ ", perFecNacimiento=" + perFecNacimiento + "]";
	}
	
	
	
}
