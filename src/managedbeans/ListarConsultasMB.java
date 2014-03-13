package managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import modelo.Consulta;
import repositorio.RepositorioConsultas;

@ManagedBean
public class ListarConsultasMB {

	@EJB 
	private RepositorioConsultas repositorioConsultas;
	
	public List<Consulta> consultas;

	
	
	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	@PostConstruct
    public void init(){
		this.consultas = repositorioConsultas.getListaConsultas();
	}
	
	public void cancelarConsulta(Consulta consulta) {
		consulta.setCancelado(true);
	}
	
	public void excluirConsulta(Consulta consulta) {
		repositorioConsultas.getListaConsultas().remove(consulta);
		init();
	}

}
