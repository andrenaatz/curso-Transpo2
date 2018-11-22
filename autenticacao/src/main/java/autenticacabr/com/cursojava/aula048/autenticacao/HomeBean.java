package autenticacabr.com.cursojava.aula048.autenticacao;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@ViewScoped
public class HomeBean {

	private Usuario usuario;
	
	@PostConstruct
	public void carregarDados(){
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession)ctx.getExternalContext().getSession(false);
		if(session != null){
			usuario = (Usuario)session.getAttribute("usuarioLogado");
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
