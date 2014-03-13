package repositorio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import modelo.Medico;

@Singleton
public class RepositorioMedicos {

	
	private List<Medico> listaMedicos;

	public List<Medico> getListaMedicos() {
		return listaMedicos;
	}

	public void setListaMedicos(List<Medico> listaMedicos) {
		this.listaMedicos = listaMedicos;
	}
	
	public void inserirMedico(Medico medico) {
		listaMedicos.add(medico);
	}
	
	@PostConstruct
	public void preCarregar() {
		listaMedicos = new ArrayList<Medico>();
		listaMedicos.add(new Medico("João Paulo", "Dermartologista"));
		listaMedicos.add(new Medico("Pedro Alvares", "Cardiologista"));
		listaMedicos.add(new Medico("Maria Fernandes", "Ginecologista"));
		listaMedicos.add(new Medico("Marcos Uhlman", "Ortopedista"));
	}

}
