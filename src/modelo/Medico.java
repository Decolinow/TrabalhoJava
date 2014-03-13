package modelo;

import java.io.Serializable;

public class Medico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8183322718052064619L;

	private String nome;
	private String especialidade;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	public Medico(String nome, String especialidade) {
		super();
		this.nome = nome;
		this.especialidade = especialidade;
	}
	
}
