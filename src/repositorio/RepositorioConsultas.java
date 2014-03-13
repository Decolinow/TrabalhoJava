package repositorio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Singleton;

import modelo.Consulta;
import modelo.Medico;

@Singleton
public class RepositorioConsultas {

	
	private List<Consulta> listaConsultas;

	public List<Consulta> getListaConsultas() {
		if (this.listaConsultas == null) {
			this.listaConsultas = new ArrayList<Consulta>();
		}
		return listaConsultas;
	}

	public void setListaConsultas(List<Consulta> listaConsultas) {
		this.listaConsultas = listaConsultas;
	}
	
	public void inserir(Consulta consulta) {
		if (this.listaConsultas == null) {
			this.listaConsultas = new ArrayList<Consulta>();
		}
		this.listaConsultas.add(consulta);
	}
	
	public List<Consulta> getConsultasMedico(Medico medico) {
		if (this.listaConsultas == null) {
			this.listaConsultas = new ArrayList<Consulta>();
		}
		List<Consulta> res = new ArrayList<Consulta>();
		for (Consulta consulta : listaConsultas) {
			if ((consulta.getMedico() == medico)&&(!consulta.isCancelado())) {
				res.add(consulta);
			}
		}
		return res;
	}
}
