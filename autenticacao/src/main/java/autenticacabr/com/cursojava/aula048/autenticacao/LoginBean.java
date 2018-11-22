package autenticacabr.com.cursojava.aula048.autenticacao;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@ViewScoped
public class LoginBean {

	private String email;
	private String senha;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String autenticar(){
		FacesContext ctx = FacesContext.getCurrentInstance();
		if("b@teste.com".equals(email) && "e10adc3949ba59abbe56e057f20f883e".equals(gerarHash(senha))){
			Usuario usuario = new Usuario("Bagrinho", email, senha);
			HttpSession session = (HttpSession)ctx.getExternalContext().getSession(true);
			session.setAttribute("usuarioLogado", usuario);
			return "index.xhtml?faces-redirect=true";
		}else{
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Inválido", "Email ou senha inválido");
			ctx.addMessage(null, msg);
		}
		return null;
	}
	
	public static String gerarHash(String valor){
		try{
		 MessageDigest digest = MessageDigest.getInstance("MD5");
		 byte[] valorMD5 = digest.digest(valor.getBytes("UTF-8"));
        
         StringBuffer sb = new StringBuffer();
         for (byte b : valorMD5){
                sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1,3));
         }
         return sb.toString();
		}catch(Exception e){
			throw new IllegalArgumentException("Não foi possível converter o texto");
		}
	}
	
	
}











