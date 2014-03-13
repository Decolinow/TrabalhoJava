package managedbeans;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.*;

import modelo.Consulta;
import modelo.Medico;
import repositorio.RepositorioConsultas;
import repositorio.RepositorioMedicos;

@ManagedBean
@ViewScoped
public class ListarMedicoMB {

	@EJB 
	private RepositorioMedicos repositorio;
	
	@EJB 
	private RepositorioConsultas repositorioConsultas;
	
	public Medico medicoEscolhido;
	public List<Medico> medicos;
	public String nomeCliente;
	public String planoSaude;
	public Date data;
	public Date hora;

	public String resultado;
	public String getResultado() {
		return this.resultado;
	}
	
	@PostConstruct
    public void init(){
		this.medicos = repositorio.getListaMedicos();
	}

	public Medico getMedicoEscolhido() {
		return medicoEscolhido;
	}

	public void setMedicoEscolhido(Medico medicoEscolhido) {
		this.medicoEscolhido = medicoEscolhido;
	}

	public List<Medico> listar() {
		return this.repositorio.getListaMedicos();
	}
	
	public List<Medico> getMedicos() {
		return this.medicos;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getPlanoSaude() {
		return planoSaude;
	}

	public void setPlanoSaude(String planoSaude) {
		this.planoSaude = planoSaude;
	}

	public Date getData() {
		return data;
	}
	
	public String getDataExtenso() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(this.data);
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}	
	
	public void selecionarMedico(Medico medico) {
		this.medicoEscolhido = medico;
	}
	
	public void selecionarData(String ads) {
		if (this.data == null) {
			this.data = new Date();
		}
	}
	
	public String confirmarConsulta() {
		SimpleDateFormat sdfdata = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat sdfhora = new SimpleDateFormat("HH");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH");
		String dateInString = sdfdata.format(data) + " " + sdfhora.format(getHora());
		Date dataComparar = null;
		try {
			dataComparar = sdf.parse(dateInString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		boolean podeSeguir = true;
		List<Consulta> consultas = repositorioConsultas.getConsultasMedico(medicoEscolhido);
		for (Consulta consulta : consultas) {
			if (consulta.getData().equals(dataComparar)){
				podeSeguir = false;
			}
		}
		
		if (podeSeguir) {
			this.resultado = "";
			Consulta ncon = new Consulta(getNomeCliente(), getPlanoSaude(), getMedicoEscolhido(), dataComparar, false);
			repositorioConsultas.inserir(ncon);
			return "sucesso.xhtml";
		}
		else {
			this.resultado = "Este horário não está disponível";
			return null;
		}
	}
	
	public void limparTudo() {
		this.data = null;
		this.hora = null;
		this.medicoEscolhido = null;
		this.nomeCliente = null;
		this.planoSaude = null;
		this.medicos = repositorio.getListaMedicos();
	}

}
