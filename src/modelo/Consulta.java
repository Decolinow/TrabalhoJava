package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Consulta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nomeCliente;
	private String nomePlano;
	private Medico medico;
	private Date data;
	private boolean cancelado;
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getNomePlano() {
		return nomePlano;
	}
	public void setNomePlano(String nomePlano) {
		this.nomePlano = nomePlano;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public boolean isCancelado() {
		return cancelado;
	}
	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}
	public Consulta(String nomeCliente, String nomePlano, Medico medico,
			Date data, boolean cancelado) {
		super();
		this.nomeCliente = nomeCliente;
		this.nomePlano = nomePlano;
		this.medico = medico;
		this.data = data;
		this.cancelado = cancelado;
	}
	
	public String getStatus() {
		if (cancelado)
			return "Cancelado";
		else
			return "Confirmado";
	}
	
	
}

