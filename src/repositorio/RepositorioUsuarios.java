package repositorio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Singleton;

import modelo.Medico;
import modelo.Usuario;

@Singleton
public class RepositorioUsuarios {

	
	private List<Usuario> listaUsuarios;

	public RepositorioUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
	public RepositorioUsuarios() {
		listaUsuarios = new ArrayList<Usuario>();
		Usuario usu = new Usuario("Secretária 1", "func@func.com", "sec1", "123");
		Usuario usu2 = new Usuario("Secretaria 2", "cliente@func.com", "sec2", "123");
		listaUsuarios.add(usu);
		listaUsuarios.add(usu2);
	}
		
	public void InserirUsuario(Usuario usuario) {
		this.listaUsuarios.add(usuario);
	}
	
	public Usuario logar(String login, String senha) {
		Usuario resultado = null;
		for (Usuario usuario : listaUsuarios) {
			String loginUsu = usuario.getLogin();
			String senhaUsu = usuario.getSenha();
			if ((loginUsu.equals(login)) && (senhaUsu.equals(senha))) {
				resultado = usuario;
				break;
			}
		}
		return resultado;
	}

}
