package managedbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import modelo.Usuario;

import repositorio.RepositorioUsuarios;

@ManagedBean	
@SessionScoped
public class LogarMB {

	@EJB
	private RepositorioUsuarios repositorio;
	
	public String login;
	public String senha;
	public Usuario usuario;
	public boolean logado;
	public String resultado;
	
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
		
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public boolean isLogado() {
		return logado;
	}
	public void setLogado(boolean logado) {
		this.logado = logado;
	}
	public String logar() {
		this.usuario = this.repositorio.logar(this.login, this.senha);
		if (usuario == null) {
			this.logado = false;
			this.login = "";
			this.senha = "";
			this.resultado = "Usuário não encontrado.";
			return null;
		} else {
			this.logado = true;
			this.resultado = "";
			this.login = "";
			this.senha = "";
			return "principal.xhtml";
		}
	}
	public String logout() {
		this.logado = false;
		this.usuario = null;
		this.login = "";
		this.senha = "";
		return "index.xhtml";
	}
	
}
